package com.kirago.ewallet.Service;

import com.kirago.ewallet.Model.Produit;
import com.kirago.ewallet.Repository.ProduitRepository;
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

    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
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
        if (produit.getId() == null || produit.getId().isEmpty()) {
            produit.setId("PDT#" + UUID.randomUUID().toString().substring(0, 7));
        }
        return produitRepository.save(produit);
    }

    // Supprimer un produit
    @Transactional
    public void delete(String id) {
        produitRepository.deleteById(id);
    }

}