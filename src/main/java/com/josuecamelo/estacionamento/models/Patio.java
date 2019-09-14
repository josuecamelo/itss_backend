package com.josuecamelo.estacionamento.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "patios")
public class Patio {
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private String descricao;
	@Column
	private Double taxaHora;
	
	@OneToMany(mappedBy="patio", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JsonIgnore
	@Fetch(FetchMode.SUBSELECT)
	private List<Vaga> vagas;
	
	@Transient
	private List<Vaga> vagasTransient;	
	
	public Patio() {
		// TODO Auto-generated constructor stub
	}
	
	public Patio(String descricao) {
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getTaxaHora() {
		return taxaHora;
	}

	public void setTaxaHora(Double taxaHora) {
		this.taxaHora = taxaHora;
	}

	public List<Vaga> getVagas() {
		return vagas;
	}

	public void setVagas(List<Vaga> vagas) {
		this.vagas = vagas;
	}

	public List<Vaga> getVagasTransient() {
		return vagasTransient;
	}

	public void setVagasTransient(List<Vaga> vagasTransient) {
		this.vagasTransient = vagasTransient;
	}	
}
