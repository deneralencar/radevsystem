package com.radev.purchase.controller.impl;

import java.util.List;

import com.radev.purchase.controller.PedidoCompraProdutoController;
import com.radev.purchase.entity.PedidoCompraProduto;
import com.radev.purchase.persistence.PedidoCompraProdutoDAO;

public class PedidoCompraProdutoControllerImpl implements PedidoCompraProdutoController {

	private PedidoCompraProdutoDAO pedidoCompraProdutoDAO = new PedidoCompraProdutoDAO();
	
	@Override
	public PedidoCompraProduto findById(int id) {
		return pedidoCompraProdutoDAO.findById(id);
	}

	@Override
	public void persist(PedidoCompraProduto pedidoCompraProduto) throws Exception {
		try {
			pedidoCompraProdutoDAO.persist(pedidoCompraProduto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<PedidoCompraProduto> listAll() {
		return pedidoCompraProdutoDAO.listAll();
	}

	@Override
	public boolean excluir(int p) {
		return pedidoCompraProdutoDAO.excluir(p);
	}

	@Override
	public List<PedidoCompraProduto> list(int id) {
		return pedidoCompraProdutoDAO.list(id);
	}

}
