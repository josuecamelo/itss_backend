package com.josuecamelo.estacionamento.services;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.josuecamelo.estacionamento.enums.VagaStatus;
import com.josuecamelo.estacionamento.models.Estacionamento;
import com.josuecamelo.estacionamento.repositories.EstacionamentoRepository;
import com.josuecamelo.estacionamento.repositories.VagaRepository;

@Service
public class EstacionamentoService implements BaseService<Estacionamento> {
	@Autowired
	private EstacionamentoRepository estacionamentoRepository;
	
	@Autowired
	private VagaRepository vagaRepository;
	
	public EstacionamentoService(EstacionamentoRepository estacionamentoRepository, VagaRepository vagaRepository) {
		this.estacionamentoRepository = estacionamentoRepository;
		this.vagaRepository = vagaRepository;
	}
	
	@Override
	public List<Estacionamento> findAll() {
		return this.estacionamentoRepository.findAll();
	}

	@Override
	public Estacionamento create(Estacionamento estacionamento) {
		estacionamento.getVaga().setStatus(VagaStatus.OCUPADA);
		this.vagaRepository.save(estacionamento.getVaga());
		return this.estacionamentoRepository.save(estacionamento);
	}
	
	public Optional<Estacionamento> saida(long id) {
		return this.estacionamentoRepository.findById(id).map(record -> {
			record.setSaida(new Date());
			
			try {
				LocalDateTime l1 = record.getSaida().toInstant()
					      .atZone(ZoneId.systemDefault())
					      .toLocalDateTime();
				LocalDateTime l2 = record.getEntrada().toInstant()
					      .atZone(ZoneId.systemDefault())
					      .toLocalDateTime();
				
				long horas = l2.until(l1, ChronoUnit.HOURS);  
				
				if(horas < 1) {
					horas = 1;
				}
				
				record.setValorPago(horas * record.getVaga().getPatio().getTaxaHora());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			record.getVaga().setStatus(VagaStatus.DISPONIVEL);
			this.vagaRepository.save(record.getVaga());
			
			Estacionamento updated = this.save(record);
			return updated;
		});
	}
	
	
	@Override
	public Optional<Estacionamento> findById(long id) {
		return this.estacionamentoRepository.findById(id);
	}

	@Override
	public Estacionamento save(Estacionamento estacionamento) {
		return this.estacionamentoRepository.save(estacionamento);
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
