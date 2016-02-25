package com.radev.foundation.controller;

import java.util.List;

import com.radev.foundation.entity.Transportadora;

public interface TransportadoraController {
	public Transportadora findById(int id);
	public void persist(Transportadora transportadora) throws Exception;
	public List<Transportadora> listAll();
}
