package com.josuecamelo.estacionamento;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josuecamelo.estacionamento.models.Cor;
import com.josuecamelo.estacionamento.services.BaseService;

@RestController
@RequestMapping("/cores")
@CrossOrigin(origins = "*")
public class CorController extends GenericRestController<Cor> {

	public CorController(BaseService<Cor> baseService) {
		super(baseService);
		// TODO Auto-generated constructor stub
	}
}
