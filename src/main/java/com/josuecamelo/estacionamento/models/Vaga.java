package com.josuecamelo.estacionamento.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.josuecamelo.estacionamento.enums.VagaStatus;

@Entity
@Table(name = "vagas")
public class Vaga {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="vaga_Seq")
	@SequenceGenerator(name="vaga_Seq", sequenceName="vaga_seq_id", allocationSize=1)
	@Column
	private Long id;
	
	@Column(nullable=false)
	private Integer numero;	
	
	@ManyToOne
	@JoinColumn(name="patio_id")
	
	private Patio patio;
	@Enumerated(EnumType.ORDINAL)
	
	private VagaStatus status;
	
	@Transient
	private Estacionamento ultimaEstacionada;
	
	public Vaga() {
		// TODO Auto-generated constructor stub
	}
	
	public Vaga(Integer numero, Patio patio, VagaStatus status) {
		this.numero = numero;
		this.patio = patio;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Patio getPatio() {
		return patio;
	}

	public void setPatio(Patio patio) {
		this.patio = patio;
	}

	public VagaStatus getStatus() {
		return status;
	}

	public void setStatus(VagaStatus status) {
		this.status = status;
	}

	public Estacionamento getUltimaEstacionada() {
		return ultimaEstacionada;
	}

	public void setUltimaEstacionada(Estacionamento ultimaEstacionada) {
		this.ultimaEstacionada = ultimaEstacionada;
	}
}
