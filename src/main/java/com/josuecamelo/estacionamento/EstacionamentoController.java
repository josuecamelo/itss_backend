package com.josuecamelo.estacionamento;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.josuecamelo.estacionamento.models.Estacionamento;
import com.josuecamelo.estacionamento.services.BaseService;
import com.josuecamelo.estacionamento.services.EstacionamentoService;

@RestController
@RequestMapping("/estacionamentos")
@CrossOrigin(origins = "*")
public class EstacionamentoController extends GenericRestController<Estacionamento> {
	@Autowired
	private EstacionamentoService estacionamentoService;
	public EstacionamentoController(BaseService<Estacionamento> baseService, EstacionamentoService estacionamentoService) {
		super(baseService);
	}
	
	@GetMapping("saida/{id}")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	public Optional<Estacionamento> saida(@PathVariable("id") Long id) {
		return this.estacionamentoService.saida(id);
	}
}
