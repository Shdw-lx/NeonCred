package com.kirago.ewallet.Repository;

import com.kirago.ewallet.Model.Client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String> {


}
