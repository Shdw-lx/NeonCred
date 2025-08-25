package com.kirago.ewallet.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "banque")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Banque {

    @Id
    @Column(name = "id_banque")
    private String id;

    @Column(name = "nom_banque")
    private String nomBanque;

    private Long reserve;

    @OneToMany(mappedBy = "banque", cascade = CascadeType.ALL, orphanRemoval = true)
    private java.util.List<Agent> agents;
}