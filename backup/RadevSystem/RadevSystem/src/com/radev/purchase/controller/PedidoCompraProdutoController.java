package com.radev.purchase.controller;

import java.util.List;

import com.radev.purchase.entity.PedidoCompraProduto;

public interface PedidoCompraProdutoController {
	public PedidoCompraProduto findById(int id);
	public void persist(PedidoCompraProduto pedidoCompraProduto) throws Exception;
	public List<PedidoCompraProduto> listAll();
	public List<PedidoCompraProduto> list(int id);
	public boolean excluir(int p);
}
