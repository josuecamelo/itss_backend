package com.josuecamelo.estacionamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.josuecamelo.estacionamento.models.Cliente;
import com.josuecamelo.estacionamento.repositories.ClienteRepository;

@Service
public class ClienteService implements BaseService<Cliente> {
	@Autowired
	private ClienteRepository clienteRepository;
	
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	@Override
	public List<Cliente> findAll() {
		return this.clienteRepository.findAll();
	}

	@Override
	public Cliente create(Cliente Cliente) {
		return this.clienteRepository.save(Cliente);
	}

	@Override
	public Optional<Cliente> findById(long id) {
		return this.clienteRepository.findById(id);
	}

	@Override
	public Cliente save(Cliente Cliente) {
		return this.clienteRepository.save(Cliente);
	}

	@Override
	public void delete(Cliente t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResponseEntity<?> deleteById(long id) {
		 return this.clienteRepository.findById(id)
		           .map(record -> {
		               this.clienteRepository.deleteById(id);
		               return ResponseEntity.ok().build();
		           }).orElse(ResponseEntity.notFound().build());
	}

	@Override
	public Optional<Cliente> update(long id, Cliente t) {
		return this.findById(id).map(record -> {
			record.setNome(t.getNome());
			record.setCpf(t.getCpf());
			record.setTelefone(t.getTelefone());
			
			Cliente updated = this.save(record);
			
			return updated;
		});
	}	
}
