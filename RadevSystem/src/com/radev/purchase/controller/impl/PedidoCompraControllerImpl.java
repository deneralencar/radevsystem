package com.radev.purchase.controller.impl;

import java.util.List;

import com.radev.purchase.controller.PedidoCompraController;
import com.radev.purchase.entity.PedidoCompra;
import com.radev.purchase.persistence.PedidoCompraDAO;

public class PedidoCompraControllerImpl implements PedidoCompraController {
	
	private PedidoCompraDAO pedidoCompraDAO = new PedidoCompraDAO();
	
	public PedidoCompra findById(int id) {
		return pedidoCompraDAO.findById(id);
	}
	
	public void persist(PedidoCompra pedidoCompra) throws Exception {
		try {
			pedidoCompraDAO.persist(pedidoCompra);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public List<PedidoCompra> listAll() {
		return pedidoCompraDAO.listAll();		
	}
	
	public List<PedidoCompra> listAllLiberar() {
		return pedidoCompraDAO.listAllLiberar();		
	}
	
	public int getLastPedido() {
		return pedidoCompraDAO.getLastPedidoCompra();
	}

	public boolean excluir(int p) {			
		return pedidoCompraDAO.excluir(p);

	}
	public boolean liberar(int p) {			
		return pedidoCompraDAO.liberar(p);

	}

	@Override
	public void updateValor(int p, float val) {
		// TODO Auto-generated method stub
		
	}
	
}
