package com.josuecamelo.estacionamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.josuecamelo.estacionamento.models.Usuario;
import com.josuecamelo.estacionamento.services.BaseService;
import com.josuecamelo.estacionamento.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController extends GenericRestController<Usuario> {
	@Autowired
	private UsuarioService usuarioService;
	
	public UsuarioController(BaseService<Usuario> baseService, UsuarioService usuarioService) {
		super(baseService);
		// TODO Auto-generated constructor stub
		this.usuarioService = usuarioService;
	}
	
	@GetMapping("login/{login}/{senha}")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public ResponseEntity<?> login(@PathVariable String login, @PathVariable String senha) {
		return this.usuarioService.login(login, senha);
	}
}
