package com.josuecamelo.estacionamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.josuecamelo.estacionamento.models.Patio;

@Repository
public interface PatioRepository extends JpaRepository<Patio, Long> {
	
}
