package com.radev.purchase.controller;

import java.util.List;

import com.radev.purchase.entity.PedidoCompra;

public interface PedidoCompraController {
	public PedidoCompra findById(int login);
	public void persist(PedidoCompra cliente) throws Exception;
	public List<PedidoCompra> listAll();
	public List<PedidoCompra> listAllLiberar();
	public int getLastPedido();
	public boolean excluir(int p);
	public boolean liberar(int p);
	public void updateValor(int p, float val);
}
