package com.josuecamelo.estacionamento;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josuecamelo.estacionamento.models.Usuario;
import com.josuecamelo.estacionamento.services.BaseService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController extends GenericRestController<Usuario> {

	public UsuarioController(BaseService<Usuario> baseService) {
		super(baseService);
		// TODO Auto-generated constructor stub
	}
	
}
