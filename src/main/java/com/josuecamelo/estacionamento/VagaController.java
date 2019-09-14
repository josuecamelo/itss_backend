package com.josuecamelo.estacionamento;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josuecamelo.estacionamento.models.Vaga;
import com.josuecamelo.estacionamento.services.BaseService;

@RestController
@RequestMapping("/vagas")
public class VagaController extends GenericRestController<Vaga> {

	public VagaController(BaseService<Vaga> baseService) {
		super(baseService);
		// TODO Auto-generated constructor stub
	}
	
}
