package com.radev.foundation.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="cliente")

public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "CLIENTE_ID", sequenceName = "CLIENTE_SEQ", allocationSize = 1 )  
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "CLIENTE_ID" )  
    @Column(name = "cliente_id", nullable = false, unique=true )	
	private int cliente_id;
	@Column(nullable = false)
	@Length(max=50)
	private String nome;
	@Column(nullable = false)
	@Length(max=50)
	private String email;	
	@Length(max=50)
	private String cpf;	
	@Length(max=50)
	private String rg;
	@Length(max=50)
	private String pessoa;
	@Length(max=50)
	private String endereco;
	@Length(max=2)
	private String estado;
	@Length(max=50)
	private String cidade;
	@Length(max=3)
	private String ddd;
	@Length(max=10)
	private String fone;
	@Length(max=12)
	private String limitecredito;
	
	
	public int getId() {
		return cliente_id;
	}
	public void setId(int cliente_id) {
		this.cliente_id = cliente_id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getPessoa() {
		return pessoa;
	}
	public void setPessoa(String pessoa) {
		this.pessoa = pessoa;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public String getLimitecredito() {
		return limitecredito;
	}
	public void setLimitecredito(String limitecredito) {
		this.limitecredito = limitecredito;
	}

	
	

	

}
