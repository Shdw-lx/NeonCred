package com.kirago.ewallet.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "produit")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produit {

    @Id
    @Column(name = "id_produit")
    private String id;

    private String nom;

    private String image;

    private Long prix;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_commercant", nullable = false)
    private Commercant commercant;
    
}