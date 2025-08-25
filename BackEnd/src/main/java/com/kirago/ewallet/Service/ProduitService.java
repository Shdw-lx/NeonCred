package com.kirago.ewallet.Service;

import com.kirago.ewallet.Model.Produit;
import com.kirago.ewallet.Model.Compte;
import com.kirago.ewallet.Repository.ProduitRepository;
import com.kirago.ewallet.Repository.CompteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service pour la gestion des Produits.
 * Un produit appartient à un commerçant et peut être acheté via le e-wallet.
 */
@Service
public class ProduitService {

    private final ProduitRepository produitRepository;
    private final CompteRepository compteRepository;

    public ProduitService(ProduitRepository produitRepository, CompteRepository compteRepository) {
        this.produitRepository = produitRepository;
        this.compteRepository = compteRepository;
    }

    // Récupérer tous les produits
    public List<Produit> getAll() {
        return produitRepository.findAll();
    }

    // Récupérer un produit par ID
    public Optional<Produit> getById(String id) {
        return produitRepository.findById(id);
    }

    // Créer ou mettre à jour un produit
    @Transactional
    public Produit save(Produit produit) {
        produit.setId("PDT#" + UUID.randomUUID().toString().substring(0, 7));
        return produitRepository.save(produit);
    }

    // Supprimer un produit
    @Transactional
    public void delete(String id) {
        produitRepository.deleteById(id);
    }

    /**
     * Achat d'un produit par un client (débit du compte)
     */
    @Transactional
    public String acheterProduit(String produitId, String compteId) {
        Produit produit = produitRepository.findById(produitId)
                .orElseThrow(() -> new RuntimeException("Produit introuvable"));
        Compte compte = compteRepository.findById(compteId)
                .orElseThrow(() -> new RuntimeException("Compte introuvable"));

        if (compte.getSolde() < produit.getPrix()) {
            return "Solde insuffisant pour acheter ce produit";
        }

        compte.setSolde(compte.getSolde() - produit.getPrix());
        compteRepository.save(compte);

        return "Achat du produit '" + produit.getNom() + "' réussi";
    }
}