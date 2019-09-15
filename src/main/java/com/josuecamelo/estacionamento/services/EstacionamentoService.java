package com.josuecamelo.estacionamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.josuecamelo.estacionamento.models.Estacionamento;
import com.josuecamelo.estacionamento.repositories.EstacionamentoRepository;

@Service
public class EstacionamentoService implements BaseService<Estacionamento> {
	@Autowired
	private EstacionamentoRepository estacionamentoRepository;
	
	public EstacionamentoService(EstacionamentoRepository estacionamentoRepository) {
		this.estacionamentoRepository = estacionamentoRepository;
	}
	
	@Override
	public List<Estacionamento> findAll() {
		return this.estacionamentoRepository.findAll();
	}

	@Override
	public Estacionamento create(Estacionamento estacionamento) {
		return this.estacionamentoRepository.save(estacionamento);
	}

	@Override
	public Optional<Estacionamento> findById(long id) {
		return this.estacionamentoRepository.findById(id);
	}

	@Override
	public Estacionamento save(Estacionamento Cliente) {
		return this.estacionamentoRepository.save(Cliente);
	}

	@Override
	public void delete(Estacionamento t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResponseEntity<?> deleteById(long id) {
		 return this.estacionamentoRepository.findById(id)
		           .map(record -> {
		               this.estacionamentoRepository.deleteById(id);
		               return ResponseEntity.ok().build();
		           }).orElse(ResponseEntity.notFound().build());
	}

	@Override
	public Optional<Estacionamento> update(long id, Estacionamento t) {
		return this.findById(id).map(record -> {
			record.setVeiculo(t.getVeiculo());
			record.setEntrada(t.getEntrada());
			record.setSaida(t.getSaida());
			record.setValorPago(t.getValorPago());
			record.setVaga(t.getVaga());			
			
			Estacionamento updated = this.save(record);
			return updated;
		});
	}

	/*@Override
	public Page<Cliente> findAll(Pageable pageable) {
		return this.clienteRepository.findAll(pageable);
	}	*/
}
