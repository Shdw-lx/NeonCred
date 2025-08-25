package com.kirago.ewallet.Service;

import com.kirago.ewallet.Model.Banque;
import com.kirago.ewallet.Repository.BanqueRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service pour la gestion des Banques.
 * Chaque banque peut avoir plusieurs agents et gérer plusieurs comptes.
 */
@Service
public class BanqueService {

    private final BanqueRepository banqueRepository;

    public BanqueService(BanqueRepository banqueRepository) {
        this.banqueRepository = banqueRepository;
    }

    // Récupérer toutes les banques
    public List<Banque> getAll() {
        return banqueRepository.findAll();
    }

    // Récupérer une banque par ID
    public Optional<Banque> getById(String id) {
        return banqueRepository.findById(id);
    }

    // Créer ou mettre à jour une banque
    @Transactional
    public Banque save(Banque banque) {
        return banqueRepository.save(banque);
    }

    // Supprimer une banque
    @Transactional
    public void delete(String id) {
        banqueRepository.deleteById(id);
    }
}