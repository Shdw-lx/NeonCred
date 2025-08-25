package com.kirago.ewallet.Controller;

import com.kirago.ewallet.Model.Commercant;
import com.kirago.ewallet.Service.CommercantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller REST pour la gestion des commerçants.
 */
@RestController
@RequestMapping("/commercant")
public class CommercantController {

    private final CommercantService commercantService;

    public CommercantController(CommercantService commercantService) {
        this.commercantService = commercantService;
    }

    // GET - Tous les commerçants
    @GetMapping
    public List<Commercant> getAll() {
        return commercantService.getAll();
    }

    // GET - Un commerçant par ID
    @GetMapping("/{id}")
    public Optional<Commercant> getById(@PathVariable String id) {
        return commercantService.getById(id);
    }

    // POST - Créer un commerçant
    @PostMapping
    public Commercant create(@RequestBody Commercant commercant) {
        return commercantService.save(commercant);
    }

    // PUT - Mettre à jour un commerçant
    @PutMapping("/{id}")
    public Commercant update(@PathVariable String id, @RequestBody Commercant commercant) {
        commercant.setId(id);
        return commercantService.save(commercant);
    }

    // DELETE - Supprimer un commerçant
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        commercantService.delete(id);
    }
}