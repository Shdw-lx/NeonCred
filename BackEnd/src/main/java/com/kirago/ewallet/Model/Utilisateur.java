package com.kirago.ewallet.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "utilisateur")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur {

    @Id
    @Column(name = "id_utilisateur")
    private String id;

    private String nom;

    private String prenom;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "mot_de_passe", nullable = false)
    private String motDePasse;

    @Column(nullable = false)
    private String role; // client, agent, commerçant

    private String image;

    // Relations bidirectionnelles optionnelles avec Client, Agent, Commercant
    @OneToOne(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private Client client;

    @OneToOne(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private Agent agent;

    @OneToOne(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private Commercant commercant;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private java.util.List<Compte> comptes;
}