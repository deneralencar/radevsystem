package com.radev.foundation.services;

import java.util.List;

import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

import com.radev.foundation.controller.ClienteController;
import com.radev.foundation.controller.PedidoController;
import com.radev.foundation.controller.impl.ClienteControllerImpl;
import com.radev.foundation.controller.impl.PedidoControllerImpl;
import com.radev.foundation.entity.Cliente;
import com.radev.foundation.entity.Pedido;


public class DTOCliente {
	
		public JSONObject getclientes() throws JSONException{
			ClienteController clienteController = new ClienteControllerImpl();
			List<Cliente> clienteList = clienteController.listAll();
			
			if(clienteList == null){
				return null;
			}
			
			JSONArray ja = new JSONArray();
			for(Cliente u : clienteList){
				JSONObject jo = new JSONObject();
				jo.put("id", u.getId());
				jo.put("nome", u.getNome());
				jo.put("email", u.getEmail());
				jo.put("cpf", u.getCpf());
				jo.put("rg", u.getRg());
				jo.put("endereco", u.getEndereco());
				jo.put("estado", u.getEstado());
				jo.put("cidade", u.getCidade());
				jo.put("ddd", u.getDdd());
				jo.put("fone", u.getFone());
				jo.put("limitecredito", u.getLimitecredito());

				
				ja.put(jo);
			}
			
			JSONObject mainObj = new JSONObject();
			mainObj.put("clientelist", ja);
			return mainObj;
		}
		
		public boolean registercliente(String name, String email, String rg, String cpf, String endereco, String estado, String cidade, String ddd, String fone, String limitecredito) throws Exception{
			Cliente cliente = new Cliente();
			cliente.setNome(name);
			cliente.setEmail(email);
			cliente.setCpf(cpf);
			cliente.setRg(rg);
			cliente.setEndereco(endereco);
			cliente.setEstado(estado);
			cliente.setCidade(cidade);
			cliente.setDdd(ddd);
			cliente.setFone(fone);
			cliente.setLimitecredito(limitecredito);
			if(cpf.length() > 14)
				cliente.setPessoa("J");
			else
				cliente.setPessoa("F");
			
			ClienteController clienteController = new ClienteControllerImpl();
			clienteController.persist(cliente);
			return true;
		}
		
		public boolean delete(int i){
			ClienteController clienteController = new ClienteControllerImpl();
			return clienteController.excluir(i);
			
		}

		public JSONObject getCliente(int id) throws JSONException{
			ClienteController clienteController = new ClienteControllerImpl();
			Cliente u = clienteController.findById(id);
			
			if(u == null){
				return null;
			}
			
			JSONArray ja = new JSONArray();
			
			JSONObject jo = new JSONObject();
			jo.put("id", u.getId());
			jo.put("nome", u.getNome());
			jo.put("email", u.getEmail());
			jo.put("cpf", u.getCpf());
			jo.put("rg", u.getRg());
			jo.put("endereco", u.getEndereco());
			jo.put("estado", u.getEstado());
			jo.put("cidade", u.getCidade());
			jo.put("ddd", u.getDdd());
			jo.put("fone", u.getFone());
			jo.put("limitecredito", u.getLimitecredito());
			
			ja.put(jo);
			
			JSONObject mainObj = new JSONObject();
			mainObj.put("cliente", ja);
			return mainObj;
		}

		public boolean alteraCliente(String nome, String email, String cpf, String rg, String endereco, String estado, String cidade, String ddd, String fone, String limitecredito) throws Exception{
				Cliente cliente = new Cliente();
				cliente.setNome(nome);
				cliente.setEmail(email);
				cliente.setCpf(cpf);
				cliente.setRg(rg);
				cliente.setEndereco(endereco);
				cliente.setEstado(estado);
				cliente.setCidade(cidade);
				cliente.setDdd(ddd);
				cliente.setFone(fone);
				cliente.setLimitecredito(limitecredito);
				if(cpf.length() > 14)
					cliente.setPessoa("J");
				else
					cliente.setPessoa("F");
				
				ClienteController clienteController = new ClienteControllerImpl();
				clienteController.persist(cliente);
				return true;
		}
	
}


