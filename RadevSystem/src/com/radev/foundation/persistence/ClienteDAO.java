package com.radev.foundation.persistence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.radev.foundation.entity.Cliente;
import com.radev.foundation.entity.Pedido;
import com.radev.foundation.persistence.manager.DAOManagerImpl;
import com.radev.foundation.persistence.manager.DBEntityManager;

public class ClienteDAO extends DAOManagerImpl<Object> {
	
	private Cliente cliente;
	private EntityManager em = DBEntityManager.getConnection();
	private List<Cliente> clientes = new ArrayList<Cliente>();
	
	@Override
	public void persist(Object entity) throws Exception, RuntimeException {
		
		super.persist(entity);

	}

	public Cliente findByLogin(String login) {
		
		Query q = em.createQuery("select u from Cliente u where u.login = :pLogin ");
		q.setParameter("pLogin", login); 
		
		try {
			return (Cliente)q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> listAll() {
		
		try {
			Query query = em.createQuery("select c from Cliente c");
			this.clientes = Collections.checkedList(query.getResultList(), Cliente.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return this.clientes;
		
	}

	public boolean excluir(int id) {
		try {
			em.getTransaction().begin();
			
			String query = "delete from Cliente where id_cliente ="+ id;
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

	public Cliente findByID(int id) {
		Query q = em.createQuery("select u from Cliente u where u.cliente_id = :pId ");
		q.setParameter("pId", id);

		try {
			return (Cliente) q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
	
}
