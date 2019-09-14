package com.josuecamelo.estacionamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.josuecamelo.estacionamento.models.Modelo;
import com.josuecamelo.estacionamento.repositories.ModeloRepository;

@Service
public class ModeloService implements BaseService<Modelo> {
	@Autowired
	private ModeloRepository modeloRepository;
	
	public ModeloService(ModeloRepository modeloRepository) {
		this.modeloRepository = modeloRepository;
	}
	
	@Override
	public List<Modelo> findAll() {
		return this.modeloRepository.findAll();
	}

	@Override
	public Modelo create(Modelo t) {
		return this.modeloRepository.save(t);
	}

	@Override
	public Modelo save(Modelo t) {
		return this.modeloRepository.save(t);
	}

	@Override
	public Optional<Modelo> update(long id, Modelo t) {
		return this.findById(id).map(record -> {
			record.setNome(t.getNome());
			Modelo updated = this.save(record);
			
			return updated;
		});
	}

	@Override
	public Optional<Modelo> findById(long id) {
		return this.modeloRepository.findById(id);
	}

	@Override
	public void delete(Modelo t) {
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
