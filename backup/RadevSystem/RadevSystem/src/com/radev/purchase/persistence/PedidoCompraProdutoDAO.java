package com.radev.purchase.persistence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.radev.foundation.persistence.manager.DAOManagerImpl;
import com.radev.foundation.persistence.manager.DBEntityManager;
import com.radev.purchase.entity.PedidoCompraProduto;

public class PedidoCompraProdutoDAO extends DAOManagerImpl<Object> {
	
	private PedidoCompraProduto pedidoCompraProduto;
	private EntityManager em = DBEntityManager.getConnection();
	private List<PedidoCompraProduto> pedidoCompraProdutos = new ArrayList<PedidoCompraProduto>();
	
	@Override
	public void persist(Object entity) throws Exception, RuntimeException {
		super.persist(entity);

	}

	public PedidoCompraProduto findById(int id) {
		
		Query q = em.createQuery("select p from PedidoCompraProduto p where p.id = :pId");
		q.setParameter("pId", id); 
		
		try {
			return (PedidoCompraProduto)q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
		
	}
		
	@SuppressWarnings("unchecked")
	public List<PedidoCompraProduto> listAll() {
		
		try {
			Query query = em.createQuery("select p from PedidoCompraProduto p where p.excluido != 1");
			this.pedidoCompraProdutos = Collections.checkedList(query.getResultList(), PedidoCompraProduto.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return this.pedidoCompraProdutos;
		
	}

	@SuppressWarnings("unchecked")
	public List<PedidoCompraProduto> list(int id) {
		
		try {
			Query query = em.createQuery("select p from PedidoCompraProduto p where p.id = :pId");
			this.pedidoCompraProdutos = Collections.checkedList(query.getResultList(), PedidoCompraProduto.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return this.pedidoCompraProdutos;
		
	}
	
	public boolean excluir(int id) {
		try {
			em.getTransaction().begin();
			
			String query = "update PedidoCompraProduto set excluido = 1 where PedidoCompraProduto.id = " + id;
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


	
}
