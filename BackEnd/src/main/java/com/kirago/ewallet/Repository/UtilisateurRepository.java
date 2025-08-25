package com.kirago.ewallet.Repository;

import com.kirago.ewallet.Model.Utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, String> {

}