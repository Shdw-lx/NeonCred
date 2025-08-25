package com.kirago.ewallet.Controller;

import com.kirago.ewallet.Model.Banque;
import com.kirago.ewallet.Service.BanqueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller REST pour la gestion des Banques.
 */
@RestController
@RequestMapping("/banque")
public class BanqueController {

    private final BanqueService banqueService;

    public BanqueController(BanqueService banqueService) {
        this.banqueService = banqueService;
    }

    // GET - Toutes les banques
    @GetMapping
    public List<Banque> getAll() {
        return banqueService.getAll();
    }

    // GET - Une banque par ID
    @GetMapping("/{id}")
    public Optional<Banque> getById(@PathVariable String id) {
        return banqueService.getById(id);
    }

    // POST - Créer une banque
    @PostMapping
    public Banque create(@RequestBody Banque banque) {
        return banqueService.save(banque);
    }

    // PUT - Mettre à jour une banque
    @PutMapping("/{id}")
    public Banque update(@PathVariable String id, @RequestBody Banque banque) {
        banque.setId(id);
        return banqueService.save(banque);
    }

    // DELETE - Supprimer une banque
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        banqueService.delete(id);
    }
}