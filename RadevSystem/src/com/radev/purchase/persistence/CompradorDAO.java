package com.radev.purchase.persistence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.radev.foundation.entity.Vendedor;
import com.radev.foundation.persistence.manager.DAOManagerImpl;
import com.radev.foundation.persistence.manager.DBEntityManager;
import com.radev.purchase.entity.Comprador;

public class CompradorDAO extends DAOManagerImpl<Object> {
	
	private Comprador comprador;
	private EntityManager em = DBEntityManager.getConnection();
	private List<Comprador> compradores = new ArrayList<Comprador>();
	
	@Override
	public void persist(Object entity) throws Exception, RuntimeException {
		
		super.persist(entity);

	}

	public Comprador findById(int id) {
		
		Query q = em.createQuery("select c from Comprador c where c.id = :pId ");
		q.setParameter("pId", id); 
		
		try {
			return (Comprador)q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Comprador> listAll() {
		
		try {
			Query query = em.createQuery("select c from Comprador c");
			this.compradores = Collections.checkedList(query.getResultList(), Comprador.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return this.compradores;
		
	}
	
}
