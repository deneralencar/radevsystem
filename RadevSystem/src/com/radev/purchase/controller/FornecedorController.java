package com.radev.purchase.controller;

import java.util.List;

import com.radev.purchase.entity.Fornecedor;

public interface FornecedorController {
	public Fornecedor findById(int id);
	public void persist(Fornecedor fornecedor) throws Exception;
	public List<Fornecedor> listAll();
}
