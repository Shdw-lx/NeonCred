package com.kirago.ewallet.Controller;

import com.google.zxing.WriterException;
import com.kirago.ewallet.Dto.TransactionRequest;
import com.kirago.ewallet.Model.Transaction;
import com.kirago.ewallet.Service.TransactionService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * Controller REST pour la gestion des transactions.
 */
@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    // GET - Liste des transactions
    @GetMapping
    public List<Transaction> getAll() {
        return transactionService.getAll();
    }

    // GET - Une transaction par ID
    @GetMapping("/{id}")
    public Optional<Transaction> getById(@PathVariable String id) {
        return transactionService.getById(id);
    }

    // DELETE - Supprimer une transaction
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        transactionService.delete(id);
    }

    // ========== Transaction via formulaire ==========
    @PostMapping("/Payform")
    public ResponseEntity<Transaction> effectuerTransactionViaForm(@RequestBody TransactionRequest request) {
        Transaction transaction = transactionService.effectuerTransactionViaForm(request);
        return ResponseEntity.ok(transaction);
    }

    // ========== Transaction via QR Code ==========
    @PostMapping("/PayQr")
    public ResponseEntity<Transaction> effectuerTransactionViaQr(@RequestBody TransactionRequest request) {
        Transaction transaction = transactionService.effectuerTransactionViaQr(request);
        return ResponseEntity.ok(transaction);
    }

    // ========== Générer un QR Code pour un produit ==========
    @GetMapping("/GenerateQR")
    public ResponseEntity<String> genererQrCode(
            @RequestParam String commercantId,
            @RequestParam String produitId,
            @RequestParam Long montant
    ) throws WriterException, IOException {
        String qrCodeBase64 = transactionService.genererQrCode(commercantId, produitId, montant);
        return ResponseEntity.ok("data:image/png;base64," + qrCodeBase64);
    }

}