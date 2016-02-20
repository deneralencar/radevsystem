package com.radev.purchase.controller;

import java.util.List;

import com.radev.purchase.entity.PedidoCompraProduto;

public interface PedidoCompraProdutoController {
	public PedidoCompraProduto findByLogin(String login);
	public void persist(PedidoCompraProduto fornecedor) throws Exception;
	public List<PedidoCompraProduto> listAll();
	public boolean excluir(int p);
}
