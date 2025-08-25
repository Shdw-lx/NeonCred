package com.kirago.ewallet.Controller;

import com.kirago.ewallet.Model.Agent;
import com.kirago.ewallet.Service.AgentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller REST pour la gestion des Agents.
 */
@RestController
@RequestMapping("/agent")
public class AgentController {

    private final AgentService agentService;

    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    // GET - Tous les agents
    @GetMapping
    public List<Agent> getAll() {
        return agentService.getAll();
    }

    // GET - Un agent par ID
    @GetMapping("/{id}")
    public Optional<Agent> getById(@PathVariable String id) {
        return agentService.getById(id);
    }

    // POST - Créer un agent
    @PostMapping
    public Agent create(@RequestBody Agent agent) {
        return agentService.save(agent);
    }

    // PUT - Mettre à jour un agent
    @PutMapping("/{id}")
    public Agent update(@PathVariable String id, @RequestBody Agent agent) {
        agent.setId(id);
        return agentService.save(agent);
    }

    // DELETE - Supprimer un agent
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        agentService.delete(id);
    }
}