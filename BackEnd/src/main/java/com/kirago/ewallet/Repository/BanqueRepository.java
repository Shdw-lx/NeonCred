package com.kirago.ewallet.Repository;

import com.kirago.ewallet.Model.Banque;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BanqueRepository extends JpaRepository<Banque, String> {

}