package com.kirago.ewallet.Service;

import com.kirago.ewallet.Model.Agent;
import com.kirago.ewallet.Repository.AgentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service pour la gestion des Agents.
 * Un agent est un utilisateur autorisé à gérer les transactions en cash
 * et assister les clients.
 */
@Service
public class AgentService {

    private final AgentRepository agentRepository;

    public AgentService(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    // Récupérer tous les agents
    public List<Agent> getAll() {
        return agentRepository.findAll();
    }

    // Récupérer un agent par ID
    public Optional<Agent> getById(String id) {
        return agentRepository.findById(id);
    }

    // Créer ou mettre à jour un agent
    @Transactional
    public Agent save(Agent agent) {
        agent.setId("AGT#" + UUID.randomUUID().toString().substring(0, 7));
        return agentRepository.save(agent);
    }

    // Supprimer un agent
    @Transactional
    public void delete(String id) {
        agentRepository.deleteById(id);
    }
}