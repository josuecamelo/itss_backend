package com.josuecamelo.estacionamento.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "estacionamentos")
public class Estacionamento {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="estacionamento_Seq")
	@SequenceGenerator(name="estacionamento_Seq", sequenceName="estacionamento_seq_id", allocationSize=1)
	@Column
	private Long id;
	
	@Column
	@CreationTimestamp
	private Date entrada;
	@Column
	private Date saida;
	@Column
	private Double valorPago;
	
	@ManyToOne
	@JoinColumn(name="veiculo_id")
	private Veiculo veiculo;
	@ManyToOne
	@JoinColumn(name="vaga_id")
	
	private Vaga vaga;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getEntrada() {
		return entrada;
	}
	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}
	public Date getSaida() {
		return saida;
	}
	public void setSaida(Date saida) {
		this.saida = saida;
	}
	public Double getValorPago() {
		return valorPago;
	}
	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public Vaga getVaga() {
		return vaga;
	}
	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}
	
	
}
