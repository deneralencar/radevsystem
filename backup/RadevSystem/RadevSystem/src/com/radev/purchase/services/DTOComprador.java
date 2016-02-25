package com.radev.purchase.services;

import java.util.List;

import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

import com.radev.purchase.controller.CompradorController;
import com.radev.purchase.controller.impl.CompradorControllerImpl;
import com.radev.purchase.entity.Comprador;


public class DTOComprador {
	
	public JSONObject getCompradores() throws JSONException{
		CompradorController compradorController = new CompradorControllerImpl();
		List<Comprador> compradorList = compradorController.listAll();
		
		if(compradorList == null){
			return null;
		}
		
		JSONArray ja = new JSONArray();
		for(Comprador u : compradorList){
			JSONObject jo = new JSONObject();
			jo.put("id", u.getId());
			jo.put("nome", u.getNome());
			jo.put("email", u.getEmail());
			jo.put("cpf", u.getCpf());
			jo.put("rg", u.getRg());
			
			ja.put(jo);
		}
		
		JSONObject mainObj = new JSONObject();
		mainObj.put("compradorlist", ja);
		return mainObj;
	}
	
	public boolean registerComprador(String name, String email, String rg, String cpf) throws Exception{
		Comprador comprador = new Comprador();
		comprador.setNome(name);
		comprador.setEmail(email);
		comprador.setCpf(cpf);
		comprador.setRg(rg);
		
		CompradorController compradorController = new CompradorControllerImpl();
		compradorController.persist(comprador);
		return true;
	}
	
}
