package com.radev.purchase.controller.impl;

import java.util.List;

import com.radev.purchase.controller.FornecedorController;
import com.radev.purchase.entity.Fornecedor;
import com.radev.purchase.persistence.FornecedorDAO;

public class FornecedorControllerImpl implements FornecedorController {

	FornecedorDAO fornecedorDAO = new FornecedorDAO();
	
	@Override
	public Fornecedor findById(int id) {
		return fornecedorDAO.findById(id);
	}

	@Override
	public void persist(Fornecedor fornecedor) throws Exception {
		try {
			fornecedorDAO.persist(fornecedor);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Fornecedor> listAll() {
		return fornecedorDAO.listAll();
	}

}
