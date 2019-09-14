package com.josuecamelo.estacionamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.josuecamelo.estacionamento.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
}