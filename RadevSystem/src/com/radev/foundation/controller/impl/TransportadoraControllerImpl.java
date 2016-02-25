package com.radev.foundation.controller.impl;

import java.util.List;

import com.radev.foundation.controller.TransportadoraController;
import com.radev.foundation.entity.Transportadora;
import com.radev.foundation.persistence.TransportadoraDAO;

public class TransportadoraControllerImpl implements TransportadoraController {

	private TransportadoraDAO transportadoraDAO = new TransportadoraDAO();
	
	@Override
	public Transportadora findById(int id) {
		return transportadoraDAO.findById(id);
	}

	@Override
	public void persist(Transportadora transportadora) throws Exception {
		try {
			transportadoraDAO.persist(transportadora);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Transportadora> listAll() {
		return transportadoraDAO.listAll();
	}

}
