package com.josuecamelo.estacionamento;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josuecamelo.estacionamento.models.Patio;
import com.josuecamelo.estacionamento.services.BaseService;

@RestController
@RequestMapping("/patios")
public class PatioController extends GenericRestController<Patio> {

	public PatioController(BaseService<Patio> baseService) {
		super(baseService);
		// TODO Auto-generated constructor stub
	}
	
}
