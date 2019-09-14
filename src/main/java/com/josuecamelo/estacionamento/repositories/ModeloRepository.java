package com.josuecamelo.estacionamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.josuecamelo.estacionamento.models.Modelo;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {
	
}
