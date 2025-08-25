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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur utilisateur;

    public Compte(Long solde) {
        this.solde = solde;
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
