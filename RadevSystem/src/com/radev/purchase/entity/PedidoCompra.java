package com.radev.purchase.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="pedidocompra")

public class PedidoCompra implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "PEDIDOCOMPRA_ID", sequenceName = "PEDIDOCOMPRA_SEQ", allocationSize = 1 )  
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "PEDIDOCOMPRA_ID" )  
    @Column(name = "pedidocompra_id", nullable = false, unique=true )	
	private int pedidocompra_id;
	@Column(nullable = false)
	private int comprador;
	@Length(max=50)
	private String data;	
	@Length(max=50)
	private String endC;
	@Length(max=50)
	private String endE;
	private Float valor;
	@Length(max=50)
	private String condPgto;
	@Column(nullable = false, columnDefinition = "int default 0")
	private int excluido;	
	@Column(nullable = false, columnDefinition = "int default 0")
	private int liberar;
	@ManyToOne
	@JoinColumn(name = "fornecedor_id")
	private Fornecedor fornecedor;
	@Column(nullable = false)
	private int moeda;
	
	public int getId() {
		return pedidocompra_id;
	}
	public void setId(int pedidoCompra_id) {
		this.pedidocompra_id = pedidoCompra_id;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setClientes(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	public int getComprador() {
		return comprador;
	}
	public void setComprador(int comprador) {
		this.comprador = comprador;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getEndC() {
		return endC;
	}
	public void setEndC(String endC) {
		this.endC = endC;
	}
	public String getEndE() {
		return endE;
	}
	public void setEndE(String endE) {
		this.endE = endE;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	public String getCondPgto() {
		return condPgto;
	}
	public void setCondPgto(String condPgto) {
		this.condPgto = condPgto;
	}
	public int getExcluido() {
		return excluido;
	}
	public void setExcluido(int excluido) {
		this.excluido = excluido;
	}
	
	public int getMoeda() {
		return moeda;
	}
	public void setMoeda(int moeda) {
		this.moeda = moeda;
	}		

}
