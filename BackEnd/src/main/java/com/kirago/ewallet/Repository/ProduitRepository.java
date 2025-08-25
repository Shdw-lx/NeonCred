package com.kirago.ewallet.Repository;

import com.kirago.ewallet.Model.Produit;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ProduitRepository extends JpaRepository<Produit, String> {
    
}

