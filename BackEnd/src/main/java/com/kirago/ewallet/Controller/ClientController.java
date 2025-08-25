package com.kirago.ewallet.Controller;

import com.kirago.ewallet.Model.Client;
import com.kirago.ewallet.Service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller REST pour les Clients.
 * CRUD complet pour tester avec Postman.
 */
@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    // GET - Tous les clients
    @GetMapping
    public List<Client> getAll() {
        return clientService.getAll();
    }

    // GET - Un client par ID
    @GetMapping("/{id}")
    public Optional<Client> getById(@PathVariable String id) {
        return clientService.getById(id);
    }

    // POST - Créer un client
    @PostMapping
    public Client create(@RequestBody Client client) {
        return clientService.save(client);
    }

    // PUT - Mettre à jour un client
    @PutMapping("/{id}")
    public Client update(@PathVariable String id, @RequestBody Client client) {
        client.setId(id);
        return clientService.save(client);
    }

    // DELETE - Supprimer un client
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        clientService.delete(id);
    }
}