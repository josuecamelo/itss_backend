package com.josuecamelo.estacionamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.josuecamelo.estacionamento.models.Patio;
import com.josuecamelo.estacionamento.repositories.PatioRepository;

@Service
public class PatioService implements BaseService<Patio> {
	@Autowired
	private PatioRepository patioRepository;
	
	public PatioService(PatioRepository patioRepository) {
		this.patioRepository = patioRepository;
	}
	
	@Override
	public List<Patio> findAll() {
		return this.patioRepository.findAll();
	}

	@Override
	public Patio create(Patio t) {
		return this.patioRepository.save(t);
	}

	@Override
	public Patio save(Patio t) {
		return this.patioRepository.save(t);
	}

	@Override
	public Optional<Patio> update(long id, Patio t) {
		return this.findById(id).map(record -> {
			record.setDescricao(t.getDescricao());
			record.setTaxaHora(t.getTaxaHora());
			Patio updated = this.save(record);
			
			return updated;
		});
	}

	@Override
	public Optional<Patio> findById(long id) {
		return this.patioRepository.findById(id);
	}

	@Override
	public void delete(Patio t) {
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
