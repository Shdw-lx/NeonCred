package com.kirago.ewallet.Service;

import com.kirago.ewallet.Model.Transaction;
import com.kirago.ewallet.Model.Compte;
import com.kirago.ewallet.Dto.TransactionRequest;
import com.kirago.ewallet.Model.Produit;
import com.kirago.ewallet.Repository.TransactionRepository;
import com.kirago.ewallet.Repository.CompteRepository;
import com.kirago.ewallet.Repository.ProduitRepository;

import jakarta.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final CompteService compteService;
    private final ProduitRepository produitRepository;
    private final PasswordEncoder passwordEncoder;

    public TransactionService(TransactionRepository transactionRepository, CompteRepository compteRepository, CompteService compteService) {
        this.transactionRepository = transactionRepository;
        this.compteRepository = compteRepository;
        this.compteService = compteService;
        this.produitRepository = null;
        this.passwordEncoder = null;
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
    // ========== Transaction par formulaire ==========
    public Transaction effectuerTransactionViaForm(TransactionRequest request) {
        // Récupérer source et destination
        Compte source = compteRepository.findById(request.getSourceId())
                .orElseThrow(() -> new RuntimeException("Emetteur introuvable"));
        Compte destination = compteRepository.findById(request.getDestinationId())
                .orElseThrow(() -> new RuntimeException("Recepteur introuvable"));

        // Vérifier mot de passe
        if (!passwordEncoder.matches(request.getPassword(), source.getMotDePasse())) {
            throw new RuntimeException("Mot de passe incorrect");
        }

        // Vérifier solde
        if (source.getSolde() < request.getMontant()) {
            throw new RuntimeException("Solde insuffisant");
        }

        // Effectuer la transaction
        compteService.debiter(source.getId(), request.getMontant());
        compteService.crediter(destination.getId(), request.getMontant());

        compteRepository.save(source);
        compteRepository.save(destination);

        // Sauvegarder transaction
        Transaction transaction = new Transaction();
        transaction.setId("TRC#" + UUID.randomUUID().toString().substring(0, 7));
        transaction.setMontant(request.getMontant());
        transaction.setDateTransaction(LocalDateTime.now());
        transaction.setTypeTransaction(request.getType());
        transaction.setCompteSource(source);
        transaction.setCompteCible(destination);

        return transactionRepository.save(transaction);
    }

    @Transactional
    // ========== Transaction par QR Code ==========
    public Transaction effectuerTransactionViaQr(TransactionRequest request) {
        // Décoder QR code : format "PRODUIT:commercantId:produitId:montant"
        String[] parts = request.getQrCodeData().split(":");
        String commercantId = parts[1];
        String produitId = parts[2];
        Long montant = Long.parseLong(parts[3]);

        // Récupérer source, commerçant, produit
        Compte source = compteRepository.findById(request.getSourceId())
                .orElseThrow(() -> new RuntimeException("Client introuvable"));
        Compte destination = compteRepository.findById(commercantId)
                .orElseThrow(() -> new RuntimeException("Commerçant introuvable"));
        Produit produit = produitRepository.findById(produitId)
                .orElseThrow(() -> new RuntimeException("Produit introuvable"));

        // Vérifier mot de passe
        if (!passwordEncoder.matches(request.getPassword(), source.getMotDePasse())) {
            throw new RuntimeException("Mot de passe incorrect");
        }

        // Vérifier solde
        if (source.getSolde() < montant) {
            throw new RuntimeException("Solde insuffisant");
        }

        // Effectuer la transaction
        source.setSolde(source.getSolde() - montant);
        destination.setSolde(destination.getSolde() + montant);

        compteRepository.save(source);
        compteRepository.save(destination);

        // Sauvegarder transaction
        Transaction transaction = new Transaction();
        transaction.setId("UTL#" + UUID.randomUUID().toString().substring(0, 7));
        transaction.setMontant(montant);
        transaction.setDateTransaction(LocalDateTime.now());
        transaction.setCompteSource(source);
        transaction.setCompteCible(destination);
        transaction.setProduit(produit);

        return transactionRepository.save(transaction);
    }

    // ========== Générer un QR Code pour un produit ==========
    public String genererQrCode(String commercantId, String produitId, Long montant)
            throws WriterException, IOException {

        String qrContent = "PRODUIT:" + commercantId + ":" + produitId + ":" + montant;

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(qrContent, BarcodeFormat.QR_CODE, 250, 250);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);

        byte[] pngData = pngOutputStream.toByteArray();
        return Base64.getEncoder().encodeToString(pngData); // retourne l'image en base64
    }

}