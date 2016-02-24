package com.radev.purchase.services;

import java.util.List;

import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

import com.radev.purchase.controller.FornecedorController;
import com.radev.purchase.controller.impl.FornecedorControllerImpl;
import com.radev.purchase.entity.Fornecedor;

public class DTOFornecedor {

	public JSONObject getFornecedores() throws JSONException{
		FornecedorController fornecedorController = new FornecedorControllerImpl();
		List<Fornecedor> fornecedorList = fornecedorController.listAll();
		
		if(fornecedorList == null){
			return null;
		}
		
		JSONArray ja = new JSONArray();
		for(Fornecedor f : fornecedorList){
			JSONObject jo = new JSONObject();
			jo.put("id", f.getId());
			jo.put("nome", f.getNome());
			jo.put("email", f.getEmail());
			jo.put("cpf", f.getCpf());
			jo.put("rg", f.getRg());
			
			ja.put(jo);
		}
		
		JSONObject mainObj = new JSONObject();
		mainObj.put("fornecedorlist", ja);
		return mainObj;
	}
	
	public boolean registerFornecedor(String name, String email, String rg, String cpf) throws Exception{
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome(name);
		fornecedor.setEmail(email);
		fornecedor.setCpf(cpf);
		fornecedor.setRg(rg);
		
		FornecedorController fornecedorController = new FornecedorControllerImpl();
		fornecedorController.persist(fornecedor);
		return true;
	}
	
}
