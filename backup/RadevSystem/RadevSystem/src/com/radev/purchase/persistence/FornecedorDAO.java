package com.radev.purchase.persistence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.radev.foundation.persistence.manager.DAOManagerImpl;
import com.radev.foundation.persistence.manager.DBEntityManager;
import com.radev.purchase.entity.Fornecedor;

public class FornecedorDAO extends DAOManagerImpl<Object> {
	
	private EntityManager em = DBEntityManager.getConnection();
	private List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();

	@Override
	public void persist(Object entity) throws Exception, RuntimeException {
		
		super.persist(entity);

	}
	
	public Fornecedor findById(int id) {
		
		Query q = em.createQuery("select f from Fornecedor f where f.id = :pId ");
		q.setParameter("pId", id); 
		
		try {
			return (Fornecedor)q.getSingleResult();
		} catch (Exception e) {
			return null;
		}		
	}
	
	@SuppressWarnings("unchecked")
	public List<Fornecedor> listAll() {
		
		try {
			Query query = em.createQuery("select f from Fornecedor f");
			this.fornecedores = Collections.checkedList(query.getResultList(), Fornecedor.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return this.fornecedores;
		
	}
	
}
