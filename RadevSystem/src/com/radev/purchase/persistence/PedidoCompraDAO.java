package com.radev.purchase.persistence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.radev.foundation.persistence.manager.DAOManagerImpl;
import com.radev.foundation.persistence.manager.DBEntityManager;
import com.radev.purchase.entity.PedidoCompra;

public class PedidoCompraDAO extends DAOManagerImpl<Object> {

	private EntityManager em = DBEntityManager.getConnection();
	private List<PedidoCompra> pedidos = new ArrayList<PedidoCompra>();

	@Override
	public void persist(Object entity) throws Exception, RuntimeException {
		super.persist(entity);

	}

	public PedidoCompra findById(int pedido) {

		Query q = em
				.createQuery("select p from PedidoCompra p where p.pedidocompra_id = :pPedido ");
		q.setParameter("pLogin", pedido);

		try {
			return (PedidoCompra)q.getSingleResult();
		} catch (Exception e) {
			return null;
		}

	}

	public int getLastPedidoCompra() {

		Query q = em.createQuery("from PedidoCompra order by pedidocompra_id DESC");
		q.setMaxResults(1);

		try {
			PedidoCompra p = (PedidoCompra) q.getSingleResult();
			return p.getId();
		} catch (Exception e) {
			return 0;
		}

	}

	public boolean excluir(int id) {
		try {
			em.getTransaction().begin();
			
			String query = "update PedidoCompra set excluido = 1 where pedidocompra_id ="+ id;
			Query q = em.createNativeQuery(query);
			q.executeUpdate();
			
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			em.getTransaction().rollback(); // desfaz transacao se ocorrer erro
											// ao persitir
		} finally {
			if (em.getTransaction().isActive()) {
				em.getTransaction().commit();
			}
		}

		return false;
		// q.setParameter("id", id);
		// q.executeUpdate();
	}
	
	public boolean liberar(int id) {
		try {
			em.getTransaction().begin();
			
			String query = "update PedidoCompra set liberar = 1 where pedidocompra_id ="+ id;
			Query q = em.createNativeQuery(query);
			q.executeUpdate();
			
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			em.getTransaction().rollback(); // desfaz transacao se ocorrer erro
											// ao persitir
		} finally {
			if (em.getTransaction().isActive()) {
				em.getTransaction().commit();
			}
		}

		return false;
	}
	
	@SuppressWarnings("unchecked")
	public List<PedidoCompra> listAll() {

		try {
			Query query = em
					.createQuery("select p from PedidoCompra p inner join p.fornecedor c where p.excluido != 1 order by p.pedido_id");

			this.pedidos = Collections.checkedList(query.getResultList(),
					PedidoCompra.class);
		} catch (Exception e) {
			System.out.print(e);
			e.printStackTrace();
		}

		return this.pedidos;

	}
	
	@SuppressWarnings("unchecked")
	public List<PedidoCompra> listAllLiberar() {

		try {
			Query query = em
					.createQuery("select p from PedidoCompra p inner join p.fornecedor c where p.excluido != 1 and p.liberar != 1 order by p.pedidocompra_id");
			
			this.pedidos = Collections.checkedList(query.getResultList(),
					PedidoCompra.class);
		} catch (Exception e) {
			System.out.print(e);
			e.printStackTrace();
		}

		return this.pedidos;

	}

}
