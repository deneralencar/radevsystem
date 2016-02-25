package com.radev.foundation.services;

import java.util.List;

import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

import com.radev.foundation.controller.TransportadoraController;
import com.radev.foundation.controller.VendedorController;
import com.radev.foundation.controller.impl.TransportadoraControllerImpl;
import com.radev.foundation.controller.impl.VendedorControllerImpl;
import com.radev.foundation.entity.Transportadora;
import com.radev.foundation.entity.Vendedor;

public class DTOTransportadora {

	public JSONObject getTransportadoras() throws JSONException{
		TransportadoraController transportadoraController = new TransportadoraControllerImpl();
		List<Transportadora> transportadoraList = transportadoraController.listAll();
		
		if(transportadoraList == null){
			return null;
		}
		
		JSONArray ja = new JSONArray();
		for(Transportadora u : transportadoraList){
			JSONObject jo = new JSONObject();
			jo.put("id", u.getId());
			jo.put("nome", u.getNome());
			
			ja.put(jo);
		}
		
		JSONObject mainObj = new JSONObject();
		mainObj.put("transportadoralist", ja);
		return mainObj;
	}
	
	public boolean registerTransportadora(String nome) throws Exception{
		Transportadora transportadora = new Transportadora();
		transportadora.setNome(nome);
		
		TransportadoraController transportadoraController = new TransportadoraControllerImpl();
		transportadoraController.persist(transportadora);
		return true;
	}
	
}
