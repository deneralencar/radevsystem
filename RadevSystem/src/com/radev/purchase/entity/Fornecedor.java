package com.radev.purchase.entity;

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
@Table(name="fornecedor")

public class Fornecedor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "FORNECEDOR_ID", sequenceName = "FORNECEDOR_SEQ", allocationSize = 1 )  
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "FORNECEDOR_ID" )  
    @Column(name = "fornecedor_id", nullable = false, unique=true )	
	private int fornecedor_id;
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
	
	public int getId() {
		return fornecedor_id;
	}
	public void setId(int fornecedor_id) {
		this.fornecedor_id = fornecedor_id;
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

	
	

	

}
