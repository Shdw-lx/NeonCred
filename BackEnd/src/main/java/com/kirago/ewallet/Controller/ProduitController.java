package com.kirago.ewallet.Controller;

import com.kirago.ewallet.Model.Produit;
import com.kirago.ewallet.Service.ProduitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller REST pour la gestion des Produits.
 */
@RestController
@RequestMapping("/produit")
public class ProduitController {

    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    // GET - Tous les produits
    @GetMapping
    public List<Produit> getAll() {
        return produitService.getAll();
    }

    // GET - Un produit par ID
    @GetMapping("/{id}")
    public Optional<Produit> getById(@PathVariable String id) {
        return produitService.getById(id);
    }

    // POST - Créer un produit
    @PostMapping
    public Produit create(@RequestBody Produit produit) {
        return produitService.save(produit);
    }

    // PUT - Mettre à jour un produit
    @PutMapping("/{id}")
    public Produit update(@PathVariable String id, @RequestBody Produit produit) {
        produit.setId(id);
        return produitService.save(produit);
    }

    // DELETE - Supprimer un produit
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        produitService.delete(id);
    }

    // POST - Achat produit
    @PostMapping("/{produitId}/acheter/{compteId}")
    public String acheter(@PathVariable String produitId, @PathVariable String compteId) {
        return produitService.acheterProduit(produitId, compteId);
    }
}