package com.josuecamelo.estacionamento.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "modelos")
public class Modelo {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="modelo_Seq")
	@SequenceGenerator(name="modelo_Seq", sequenceName="modelo_seq_id", allocationSize=1)
	@Column
	private Long id;
	
	@Column
	private String nome;
	
	@OneToMany(mappedBy="modelo", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Veiculo> veiculos;
	
	public Modelo() {
		// TODO Auto-generated constructor stub
	}
	
	public Modelo(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
}
