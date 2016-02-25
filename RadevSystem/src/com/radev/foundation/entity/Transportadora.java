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
@Table(name="transportadora")
public class Transportadora implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "TRANSPORTADORA_ID", sequenceName = "TRANSPORTADORA_SEQ", allocationSize = 1 )  
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "TRANSPORTADORA_ID" )  
    @Column(name = "transportadora_id", nullable = false )
	private int transportadora_id;
	@Column(nullable = false, unique=true)
	@Length(max=50)
	private String nome;
	public int getId() {
		return transportadora_id;
	}
	public void setId(int transportadora_id) {
		this.transportadora_id = transportadora_id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}	
	
}
