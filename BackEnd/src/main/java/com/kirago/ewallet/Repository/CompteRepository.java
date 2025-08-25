package com.kirago.ewallet.Repository;

import com.kirago.ewallet.Model.Compte;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, String> {

}