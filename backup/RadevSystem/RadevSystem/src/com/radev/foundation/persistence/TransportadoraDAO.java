package com.radev.foundation.persistence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.radev.foundation.entity.Empresa;
import com.radev.foundation.entity.Produto;
import com.radev.foundation.entity.Transportadora;
import com.radev.foundation.persistence.manager.DAOManagerImpl;
import com.radev.foundation.persistence.manager.DBEntityManager;

public class TransportadoraDAO  extends DAOManagerImpl<Object> {

	private Transportadora transportadora;
	private EntityManager em = DBEntityManager.getConnection();
	private List<Transportadora> transportadoras = new ArrayList<Transportadora>();
	
	@Override
	public void persist(Object entity) throws Exception, RuntimeException {
		
		transportadora = findById(((Transportadora)entity).getId());
		
		if (transportadora == null)
			super.persist(entity);
		else {
			int id = transportadora.getId();
			
			transportadora = (Transportadora)entity;
			transportadora.setId(id);
			
			super.merge(transportadora);
		}
	}

	public Transportadora findById(int id) {
		
		Query q = em.createQuery("select t from Transportadora t where t.id = :pId");
		q.setParameter("pId", id); 
		
		try {
			return (Transportadora)q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
		
	}

	@SuppressWarnings("unchecked")
	public List<Transportadora> listAll() {
		
		try {
			Query query = em.createQuery("select t from Transportadora t");
			this.transportadoras = Collections.checkedList(query.getResultList(), Transportadora.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return this.transportadoras;
		
	}
	
}
