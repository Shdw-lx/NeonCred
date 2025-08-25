package com.kirago.ewallet.Service;

import com.kirago.ewallet.Model.Utilisateur;
import com.kirago.ewallet.Repository.UtilisateurRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;
import java.util.Optional;

/**
 * Service pour la gestion des Utilisateurs.
 * Contient les opérations CRUD.
 */
@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    // Récupérer tous les utilisateurs
    public List<Utilisateur> getAll() {
        return utilisateurRepository.findAll();
    }

    // Récupérer un utilisateur par son ID
    public Optional<Utilisateur> getById(String id) {
        return utilisateurRepository.findById(id);
    }

    // Créer ou mettre à jour un utilisateur
    @Transactional
    public Utilisateur save(Utilisateur utilisateur) {
        utilisateur.setId("UTL#" + UUID.randomUUID().toString().substring(0, 7));
        return utilisateurRepository.save(utilisateur);
    }

    // Supprimer un utilisateur
    @Transactional
    public void delete(String id) {
        utilisateurRepository.deleteById(id);
    }
}