package com.kirago.ewallet.Model;

import java.util.Objects;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "compte")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Compte {

    @Id
    @Column(name = "id_compte")
    private String id;

    private Long solde;

    @Column(name = "type_compte")
    private String typeCompte;

    private String statut;
    private String motDePasse;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur utilisateur;

    public Compte(Compte compte){
        this.id = compte.getId();
        this.solde = compte.getSolde();
        this.motDePasse = compte.getUtilisateur().getMotDePasse();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Compte)) return false;
        Compte compte = (Compte) o;
        return Objects.equals(id, compte.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
