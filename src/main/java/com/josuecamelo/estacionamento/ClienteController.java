package com.josuecamelo.estacionamento;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josuecamelo.estacionamento.models.Cliente;
import com.josuecamelo.estacionamento.services.BaseService;

@RestController
@RequestMapping("/clientes")
public class ClienteController extends GenericRestController<Cliente> {

	public ClienteController(BaseService<Cliente> baseService) {
		super(baseService);
		// TODO Auto-generated constructor stub
	}
	
}
