package com.kirago.ewallet.Controller;

import com.kirago.ewallet.Model.Utilisateur;
import com.kirago.ewallet.Service.UtilisateurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller REST pour les Utilisateurs.
 * Permet de tester facilement avec Postman.
 */
@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    // GET - Tous les utilisateurs
    @GetMapping
    public List<Utilisateur> getAll() {
        return utilisateurService.getAll();
    }

    // GET - Un utilisateur par ID
    @GetMapping("/{id}")
    public Optional<Utilisateur> getById(@PathVariable String id) {
        return utilisateurService.getById(id);
    }

    // POST - Créer un utilisateur
    @PostMapping
    public Utilisateur create(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.save(utilisateur);
    }

    // PUT - Mettre à jour un utilisateur
    @PutMapping("/{id}")
    public Utilisateur update(@PathVariable String id, @RequestBody Utilisateur utilisateur) {
        utilisateur.setId(id);
        return utilisateurService.save(utilisateur);
    }

    // DELETE - Supprimer un utilisateur
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        utilisateurService.delete(id);
    }
}