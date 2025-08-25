package com.kirago.ewallet.Controller;

import com.kirago.ewallet.Model.Transaction;
import com.kirago.ewallet.Service.TransactionService;
import org.springframework.web.bind.annotation.*;

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

    // POST - Transfert entre comptes
    @PostMapping("/transferer")
    public Transaction transferer(@RequestParam String compteSource, @RequestParam String compteCible, @RequestParam Long montant) {
        return transactionService.transferer(compteSource, compteCible, montant);
    }
}