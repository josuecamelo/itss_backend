package com.josuecamelo.estacionamento;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josuecamelo.estacionamento.models.Veiculo;
import com.josuecamelo.estacionamento.services.BaseService;

@RestController
@RequestMapping("/veiculos")
@CrossOrigin(origins = "*")
public class VeiculoController extends GenericRestController<Veiculo> {

	public VeiculoController(BaseService<Veiculo> baseService) {
		super(baseService);
		// TODO Auto-generated constructor stub
	}
	
}
