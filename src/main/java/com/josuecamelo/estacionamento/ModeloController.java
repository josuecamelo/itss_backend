package com.josuecamelo.estacionamento;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josuecamelo.estacionamento.models.Modelo;
import com.josuecamelo.estacionamento.services.BaseService;

@RestController
@RequestMapping("/modelos")
public class ModeloController extends GenericRestController<Modelo> {

	public ModeloController(BaseService<Modelo> baseService) {
		super(baseService);
		// TODO Auto-generated constructor stub
	}
	
}
