package com.josuecamelo.estacionamento;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josuecamelo.estacionamento.models.Estacionamento;
import com.josuecamelo.estacionamento.services.BaseService;

@RestController
@RequestMapping("/estacionamentos")
@CrossOrigin(origins = "*")
public class EstacionamentoController extends GenericRestController<Estacionamento> {

	public EstacionamentoController(BaseService<Estacionamento> baseService) {
		super(baseService);
		// TODO Auto-generated constructor stub
	}
	
}
