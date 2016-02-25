package com.radev.purchase.controller.impl;

import java.util.List;

import com.radev.purchase.controller.CompradorController;
import com.radev.purchase.entity.Comprador;
import com.radev.purchase.persistence.CompradorDAO;

public class CompradorControllerImpl implements CompradorController {
	
	private CompradorDAO compradorDAO = new CompradorDAO();
	
	public Comprador findById(int id) {
		return compradorDAO.findById(id);
	}
	
	public void persist(Comprador comprador) throws Exception {
		try {
			compradorDAO.persist(comprador);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public List<Comprador> listAll() {
		return compradorDAO.listAll();		
	}

}
