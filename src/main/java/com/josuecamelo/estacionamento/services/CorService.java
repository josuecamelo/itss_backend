package com.josuecamelo.estacionamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.josuecamelo.estacionamento.models.Cor;
import com.josuecamelo.estacionamento.repositories.CorRepository;

@Service
public class CorService implements BaseService<Cor> {
	@Autowired
	private CorRepository corRepository;
	
	public CorService(CorRepository corRepository) {
		this.corRepository = corRepository;
	}

	@Override
	public List<Cor> findAll() {
		return this.corRepository.findAll();
	}

	@Override
	public Cor create(Cor t) {
		return this.corRepository.save(t);
	}

	@Override
	public Cor save(Cor t) {
		return this.corRepository.save(t);
	}

	@Override
	public Optional<Cor> update(long id, Cor t) {
		return this.findById(id).map(record -> {
			record.setNome(t.getNome());
			Cor updated = this.save(record);
			
			return updated;
		});
	}

	@Override
	public Optional<Cor> findById(long id) {
		return this.corRepository.findById(id);
	}

	@Override
	public void delete(Cor t) {
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
