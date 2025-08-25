package com.kirago.ewallet.Controller;

import com.kirago.ewallet.Model.Compte;
import com.kirago.ewallet.Service.CompteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller REST pour la gestion des Comptes.
 */
@RestController
@RequestMapping("/compte")
public class CompteController {

    private final CompteService compteService;

    public CompteController(CompteService compteService) {
        this.compteService = compteService;
    }

    // GET - Tous les comptes
    @GetMapping
    public List<Compte> getAll() {
        return compteService.getAll();
    }

    // GET - Un compte par ID
    @GetMapping("/{id}")
    public Optional<Compte> getById(@PathVariable String id) {
        return compteService.getById(id);
    }

    // POST - Créer un compte
    @PostMapping
    public Compte create(@RequestBody Compte compte) {
        return compteService.save(compte);
    }

    // PUT - Mettre à jour un compte
    @PutMapping("/{id}")
    public Compte update(@PathVariable String id, @RequestBody Compte compte) {
        compte.setId(id);
        return compteService.save(compte);
    }

    // DELETE - Supprimer un compte
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        compteService.delete(id);
    }

    // POST - Recharger un compte
    @PostMapping("/recharger")
    public Compte recharger(@PathVariable String id, @RequestParam Long montant) {
        return compteService.recharger(id, montant);
    }

    // POST - Débiter un compte
    @PostMapping("/debiter")
    public Compte debiter(@PathVariable String id, @RequestParam Long montant) {
        return compteService.debiter(id, montant);
    }
}