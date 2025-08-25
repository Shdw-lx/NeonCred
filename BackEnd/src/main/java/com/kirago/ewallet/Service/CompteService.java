package com.kirago.ewallet.Service;

import com.kirago.ewallet.Model.Compte;
import com.kirago.ewallet.Repository.CompteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service pour la gestion des Comptes.
 * Un compte est lié à un utilisateur (client) et possède un solde.
 */
@Service
public class CompteService {

    private final CompteRepository compteRepository;

    public CompteService(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    // Récupérer tous les comptes
    public List<Compte> getAll() {
        return compteRepository.findAll();
    }

    // Récupérer un compte par ID
    public Optional<Compte> getById(String id) {
        return compteRepository.findById(id);
    }

    // Créer ou mettre à jour un compte
    @Transactional
    public Compte save(Compte compte) {
        compte.setId("CPT#" + UUID.randomUUID().toString().substring(0, 7));
        return compteRepository.save(compte);
    }

    // Supprimer un compte
    @Transactional
    public void delete(String id) {
        compteRepository.deleteById(id);
    }

    /**
     * Recharger un compte avec un montant positif
     */
    @Transactional
    public Compte recharger(String compteId, Long montant) {
        Compte compte = compteRepository.findById(compteId)
                .orElseThrow(() -> new RuntimeException("Compte introuvable"));
        if (montant <= 0) {
            throw new IllegalArgumentException("Montant invalide");
        }
        compte.setSolde(compte.getSolde() + montant);
        return compteRepository.save(compte);
    }

    /**
     * Débiter un compte (ex : paiement)
     */
    @Transactional
    public Compte debiter(String compteId, Long montant) {
        Compte compte = compteRepository.findById(compteId)
                .orElseThrow(() -> new RuntimeException("Compte introuvable"));
        if (montant <= 0) {
            throw new IllegalArgumentException("Montant invalide");
        }
        if (compte.getSolde() < montant) {
            throw new RuntimeException("Solde insuffisant");
        }
        compte.setSolde(compte.getSolde() - montant);
        return compteRepository.save(compte);
    }
}