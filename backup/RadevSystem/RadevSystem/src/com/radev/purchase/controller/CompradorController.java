package com.radev.purchase.controller;

import java.util.List;

import com.radev.foundation.entity.Vendedor;
import com.radev.purchase.entity.Comprador;


public interface CompradorController {
	public Comprador findById(int id);
	public void persist(Comprador comprador) throws Exception;
	public List<Comprador> listAll();
}
