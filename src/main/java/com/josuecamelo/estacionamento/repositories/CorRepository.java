package com.josuecamelo.estacionamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.josuecamelo.estacionamento.models.Cor;

@Repository
public interface CorRepository extends JpaRepository<Cor, Long> {
	
}
