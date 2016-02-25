package com.radev.purchase.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="pedidocompraproduto")

public class PedidoCompraProduto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "PEDIDOCOMPRAPRODUTO_ID", sequenceName = "PEDIDOCOMPRAPRODUTO_SEQ", allocationSize = 1 )  
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "PEDIDOCOMPRAPRODUTO_ID" )  
    @Column(name = "pedidocompraproduto_id", nullable = false, unique=true )	
	private int pedidocompraproduto_id;
	@Column(nullable = false)
	private int qtd;
	@Column(nullable = false)
	private int pedido;
	@Column(nullable = false)
	private int produto;
	@Column(nullable = false)
	private int item;
	@Column(nullable = false, columnDefinition = "int default 0")
	private int excluido;	
	
	public int getId() {
		return pedidocompraproduto_id;
	}
	public void setId(int pedidoproduto_id) {
		this.pedidocompraproduto_id = pedidoproduto_id;
	}
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	public int getPedido() {
		return pedido;
	}
	public void setPedido(int pedido) {
		this.pedido = pedido;
	}
	public int getProduto() {
		return produto;
	}
	public void setProduto(int produto) {
		this.produto = produto;
	}
	public int getItem() {
		return item;
	}
	public void setItem(int item) {
		this.item = item;
	}

	
	
	

	

}
