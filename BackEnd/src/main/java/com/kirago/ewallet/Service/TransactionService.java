package com.kirago.ewallet.Service;

import com.kirago.ewallet.Model.Transaction;
import com.kirago.ewallet.Model.Compte;
import com.kirago.ewallet.Repository.TransactionRepository;
import com.kirago.ewallet.Repository.CompteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/*
 * Service de gestion des transactions.
 * Permet de créer et consulter l'historique des transferts et paiements.
 */
@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final CompteRepository compteRepository;

    public TransactionService(TransactionRepository transactionRepository, CompteRepository compteRepository) {
        this.transactionRepository = transactionRepository;
        this.compteRepository = compteRepository;
    }

    // Lister toutes les transactions
    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }

    // Récupérer une transaction par ID
    public Optional<Transaction> getById(String id) {
        return transactionRepository.findById(id);
    }

    // Supprimer une transaction
    @Transactional
    public void delete(String id) {
        transactionRepository.deleteById(id);
    }

    /**
     * Créer une transaction simple entre deux comptes
     */
    @Transactional
    public Transaction transferer(String compteSource, String compteCible, Long montant) {
        if (montant <= 0) {
            throw new IllegalArgumentException("Le montant doit être positif");
        }

        Compte source = compteRepository.findById(compteSource)
                .orElseThrow(() -> new RuntimeException("Compte source introuvable"));
        Compte destination = compteRepository.findById(compteCible)
                .orElseThrow(() -> new RuntimeException("Compte destination introuvable"));

        if (source.getSolde() < montant) {
            throw new RuntimeException("Solde insuffisant");
        }

        // Débit et crédit
        source.setSolde(source.getSolde() - montant);
        destination.setSolde(destination.getSolde() + montant);

        compteRepository.save(source);
        compteRepository.save(destination);

        // Enregistrer la transaction
        Transaction transaction = new Transaction();
        transaction.setMontant(montant);
        transaction.setDateTransaction(LocalDateTime.now());
        transaction.setCompteSource(source);
        transaction.setCompteCible(destination);
        transaction.setId("UTL#" + UUID.randomUUID().toString().substring(0, 7));
        return transactionRepository.save(transaction);
    }

    // Méthode utilitaire : génère un QR Code et le renvoie en Base64
    private String generateQRCodeBase64(String text, int width, int height) {
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

            ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);

            byte[] pngData = pngOutputStream.toByteArray();
            return Base64.getEncoder().encodeToString(pngData);
        } catch (WriterException | IOException e) {
            throw new RuntimeException("Erreur lors de la génération du QR Code", e);
        }
    }
}