package com.josuecamelo.estacionamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.josuecamelo.estacionamento.models.Vaga;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long> {
	Vaga findByStatus(String status);
}
