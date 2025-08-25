package com.kirago.ewallet.Service;

import com.kirago.ewallet.Model.Commercant;
import com.kirago.ewallet.Repository.CommercantRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service de gestion des commerçants.
 * Un commerçant peut vendre des produits et recevoir des paiements.
 */
@Service
public class CommercantService {

    private final CommercantRepository commercantRepository;

    public CommercantService(CommercantRepository commercantRepository) {
        this.commercantRepository = commercantRepository;
    }

    // Lister tous les commerçants
    public List<Commercant> getAll() {
        return commercantRepository.findAll();
    }

    // Récupérer un commerçant par ID
    public Optional<Commercant> getById(String id) {
        return commercantRepository.findById(id);
    }

    // Créer ou mettre à jour un commerçant
    @Transactional
    public Commercant save(Commercant commercant) {
        commercant.setId("CMC#" + UUID.randomUUID().toString().substring(0, 7));
        return commercantRepository.save(commercant);
    }

    // Supprimer un commerçant
    @Transactional
    public void delete(String id) {
        commercantRepository.deleteById(id);
    }
}