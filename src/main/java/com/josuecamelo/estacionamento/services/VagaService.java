package com.josuecamelo.estacionamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.josuecamelo.estacionamento.models.Vaga;
import com.josuecamelo.estacionamento.repositories.VagaRepository;

@Service
public class VagaService implements BaseService<Vaga> {
	@Autowired
	private VagaRepository vagaRepository;
	
	public VagaService(VagaRepository vagaRepository) {
		this.vagaRepository = vagaRepository;
	}
	
	@Override
	public List<Vaga> findAll() {
		return this.vagaRepository.findAll();
	}

	@Override
	public Vaga create(Vaga t) {
		return this.vagaRepository.save(t);
	}

	@Override
	public Vaga save(Vaga t) {
		return this.vagaRepository.save(t);
	}

	@Override
	public Optional<Vaga> update(long id, Vaga t) {
		return this.findById(id).map(record -> {
			record.setNumero(t.getNumero());
			record.setPatio(t.getPatio());
			record.setStatus(t.getStatus());
			Vaga updated = this.save(record);
			
			return updated;
		});
	}

	@Override
	public Optional<Vaga> findById(long id) {
		return this.vagaRepository.findById(id);
	}

	@Override
	public void delete(Vaga t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResponseEntity<?> deleteById(long id) {
		 return this.findById(id)
		           .map(record -> {
		               this.deleteById(id);
		               return ResponseEntity.ok().build();
		           }).orElse(ResponseEntity.notFound().build());
	}

}
