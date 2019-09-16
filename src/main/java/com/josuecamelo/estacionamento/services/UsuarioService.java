package com.josuecamelo.estacionamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.josuecamelo.estacionamento.models.Usuario;
import com.josuecamelo.estacionamento.repositories.UsuarioRepository;

@Service
public class UsuarioService implements BaseService<Usuario> {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	@Override
	public List<Usuario> findAll() {
		return this.usuarioRepository.findAll();
	}

	@Override
	public Usuario create(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}

	@Override
	public Optional<Usuario> findById(long id) {
		return this.usuarioRepository.findById(id);
	}

	@Override
	public Usuario save(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}

	@Override
	public void delete(Usuario t) {
		// TODO Auto-generated method stub
		
	}
	
	public ResponseEntity<?> login(String login, String senha) {
		ResponseEntity<?> res = null;
		Usuario u = this.usuarioRepository.findByLogin(login);
		res = ResponseEntity.notFound().build();
		
		if(u.getSenha().equals(senha)) {
			res = ResponseEntity.ok().build();
		}
		
		return res;
	}

	@Override
	public ResponseEntity<?> deleteById(long id) {
		 return this.usuarioRepository.findById(id)
		           .map(record -> {
		               this.usuarioRepository.deleteById(id);
		               return ResponseEntity.ok().build();
		           }).orElse(ResponseEntity.notFound().build());
	}

	@Override
	public Optional<Usuario> update(long id, Usuario usuario) {
		return this.findById(id).map(record -> {
			record.setLogin(usuario.getLogin());
			record.setNome(usuario.getNome());
			record.setSenha(usuario.getSenha());
			record.setTelefone(usuario.getTelefone());
			
			Usuario updated = this.save(record);
			
			return updated;
		});
	}	
}
