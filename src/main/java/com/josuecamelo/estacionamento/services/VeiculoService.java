package com.josuecamelo.estacionamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.josuecamelo.estacionamento.models.Veiculo;
import com.josuecamelo.estacionamento.repositories.VeiculoRepository;

@Service
public class VeiculoService implements BaseService<Veiculo> {
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	public VeiculoService(VeiculoRepository veiculoRepository) {
		this.veiculoRepository = veiculoRepository;
	}
	
	@Override
	public List<Veiculo> findAll() {
		return this.veiculoRepository.findAll();
	}

	@Override
	public Veiculo create(Veiculo t) {
		return this.veiculoRepository.save(t);
	}

	@Override
	public Veiculo save(Veiculo t) {
		return this.veiculoRepository.save(t);
	}

	@Override
	public Optional<Veiculo> update(long id, Veiculo t) {
		return this.findById(id).map(record -> {
			record.setCliente(t.getCliente());
			record.setCor(t.getCor());
			record.setModelo(t.getModelo());
			record.setPlaca(t.getPlaca());
			Veiculo updated = this.save(record);
			
			return updated;
		});
	}

	@Override
	public Optional<Veiculo> findById(long id) {
		return this.veiculoRepository.findById(id);
	}

	@Override
	public void delete(Veiculo t) {
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
