package com.josuecamelo.estacionamento.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "veiculos")
public class Veiculo {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="veiculo_Seq")
	@SequenceGenerator(name="veiculo_Seq", sequenceName="veiculo_seq_id", allocationSize=1)
	@Column
	private Long id;
	
	@Column(nullable=false)
	private String placa;
		
	@ManyToOne
	@JoinColumn(name="modelo_id")
	private Modelo modelo;
	
	@ManyToOne
	@JoinColumn(name="cor_id")
	private Cor cor;
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	@OneToMany(mappedBy="veiculo", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Estacionamento> estacionadas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Estacionamento> getEstacionadas() {
		return estacionadas;
	}

	public void setEstacionadas(List<Estacionamento> estacionadas) {
		this.estacionadas = estacionadas;
	}	
	
	
}
