package com.radev.purchase.services;

import java.util.List;

import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

import com.radev.purchase.controller.PedidoCompraController;
import com.radev.purchase.controller.PedidoCompraProdutoController;
import com.radev.purchase.controller.impl.PedidoCompraControllerImpl;
import com.radev.purchase.controller.impl.PedidoCompraProdutoControllerImpl;
import com.radev.purchase.entity.Fornecedor;
import com.radev.purchase.entity.PedidoCompra;
import com.radev.purchase.entity.PedidoCompraProduto;

public class DTOPedidoCompra {
	
		public JSONObject getpedidos() throws JSONException{
			PedidoCompraController pedidoCompraController = new PedidoCompraControllerImpl();
			List<PedidoCompra> pedidoCompraList = pedidoCompraController.listAll();
			
			if(pedidoCompraList == null){
				return null;
			}
			
			JSONArray ja = new JSONArray();
			for(PedidoCompra u : pedidoCompraList){
				JSONObject jo = new JSONObject();
				jo.put("id", u.getId());
				jo.put("fornecedor", u.getFornecedor().getId());
				jo.put("nomefornecedor", u.getFornecedor().getNome());
				jo.put("cpf", u.getFornecedor().getCpf());
				jo.put("data", u.getData());
				jo.put("valor", u.getValor());
				
				ja.put(jo);
			}
			
			JSONObject mainObj = new JSONObject();
			mainObj.put("pedidolist", ja);
			return mainObj;
		}
		
		public JSONObject getpedidosLiberar() throws JSONException{
			PedidoCompraController pedidoCompraController = new PedidoCompraControllerImpl();
			List<PedidoCompra> pedidoCompraList = pedidoCompraController.listAllLiberar();
			
			if(pedidoCompraList == null){
				return null;
			}
			
			JSONArray ja = new JSONArray();
			for(PedidoCompra u : pedidoCompraList){
				JSONObject jo = new JSONObject();
				jo.put("id", u.getId());
				jo.put("fornecedor", u.getFornecedor().getId());
				jo.put("nomefornecedor", u.getFornecedor().getNome());
				jo.put("valor", u.getValor());
				
				ja.put(jo);
			}
			
			JSONObject mainObj = new JSONObject();
			mainObj.put("pedidoCompralist", ja);
			return mainObj;
		}
		
		public JSONObject getpedido(int id) throws JSONException{
			PedidoCompraController pedidoCompraController = new PedidoCompraControllerImpl();
			PedidoCompra u = pedidoCompraController.findById(id);
			
			if(u == null){
				return null;
			}
			
			JSONArray ja = new JSONArray();

			JSONObject jo = new JSONObject();
			jo.put("id", u.getId());
			jo.put("fornecedor", u.getFornecedor().getId());
			jo.put("vendedor", u.getComprador());
			jo.put("cpf", u.getFornecedor().getCpf());
			jo.put("data", u.getData());
			jo.put("endc", u.getEndC());
			jo.put("ende", u.getEndE());
			jo.put("pgto", u.getCondPgto());
			
			ja.put(jo);
			
			JSONObject mainObj = new JSONObject();
			mainObj.put("pedido", ja);
			return mainObj;
		}
		
		public JSONObject getitens(int id) throws JSONException{
			PedidoCompraProdutoController pedidoCompraProdutoController = new PedidoCompraProdutoControllerImpl();
			List<PedidoCompraProduto> pedidoCompraProdutoList = pedidoCompraProdutoController.listAll();
			
			if(pedidoCompraProdutoList == null){
				return null;
			}
			
			JSONArray ja = new JSONArray();
			for(PedidoCompraProduto u : pedidoCompraProdutoList){
				if(u.getPedido() == id){
					JSONObject jo = new JSONObject();
					jo.put("id", u.getId());
					jo.put("item", u.getItem());
					jo.put("quantidade", u.getQtd());
					jo.put("produto", u.getProduto());
					
					ja.put(jo);
				}
			}
			
			JSONObject mainObj = new JSONObject();
			mainObj.put("itenlist", ja);
			return mainObj;
		}
		
		public boolean registerpedido(String data, String fornecedor, String comprador, String valor, String endC, String endE, String condPgto,
										String item[], String produto[], String qtd[]) throws Exception{
			PedidoCompra pedidoCompra = new PedidoCompra();
			Fornecedor f = new Fornecedor();
			//pedido.setId(Integer.parseInt(id));
			pedidoCompra.setData(data);
			f.setId(Integer.parseInt(fornecedor));
			pedidoCompra.setClientes(f);
			pedidoCompra.setComprador(Integer.parseInt(comprador));
			pedidoCompra.setValor(Float.parseFloat(valor));
			pedidoCompra.setEndC(endC);
			pedidoCompra.setEndE(endE);
			pedidoCompra.setCondPgto(condPgto);
			
			PedidoCompraController pedidoCompraController = new PedidoCompraControllerImpl();
			pedidoCompraController.persist(pedidoCompra);
			int lastID = pedidoCompraController.getLastPedido();
			
			
			for(int i = 0; i < item.length; i++){
			
				PedidoCompraProduto pedidoCompraProduto = new PedidoCompraProduto();
				pedidoCompraProduto.setItem(Integer.parseInt(item[i]));
				pedidoCompraProduto.setPedido(lastID);
				pedidoCompraProduto.setProduto(Integer.parseInt(produto[i]));
				pedidoCompraProduto.setQtd(Integer.parseInt(qtd[i]));
				
				PedidoCompraProdutoController pedidoCompraProdutoController = new PedidoCompraProdutoControllerImpl();
				pedidoCompraProdutoController.persist(pedidoCompraProduto);			
			}
			
			return true;
		}
		
		
		
		public boolean editItensPedido(int id, float val, String item[], String produto[], String qtd[]) throws Exception{
				PedidoCompraProdutoController pedidoCompraProdutoController = new PedidoCompraProdutoControllerImpl();
				pedidoCompraProdutoController.excluir(id);
				updateValor(id, val);
				
				for(int i = 0; i < item.length; i++){				
					PedidoCompraProduto pedidoCompraProduto = new PedidoCompraProduto();
					pedidoCompraProduto.setItem(Integer.parseInt(item[i]));
					pedidoCompraProduto.setPedido(id);
					pedidoCompraProduto.setProduto(Integer.parseInt(produto[i]));
					pedidoCompraProduto.setQtd(Integer.parseInt(qtd[i]));
					
					pedidoCompraProdutoController.persist(pedidoCompraProduto);			
				}
				
				return true;
		}
		
		public int getLastPedido(){
			PedidoCompraController pedidoCompraProdutoController = new PedidoCompraControllerImpl();
			return pedidoCompraProdutoController.getLastPedido();
			
		}
		
		public void updateValor(int id, float valor){
			PedidoCompraController pedidoCompraController = new PedidoCompraControllerImpl();
			pedidoCompraController.updateValor(id, valor);
			
		}
		
		public boolean delete(int id){
			PedidoCompraController pedidoCompraController = new PedidoCompraControllerImpl();
			return pedidoCompraController.excluir(id);
			
		}
		
		public boolean liberar(String liberar[]){
			PedidoCompraController pedidoCompraController = new PedidoCompraControllerImpl();
			for(String l : liberar){
				if(!pedidoCompraController.liberar(Integer.parseInt(l)))
					return false;
			}
			return true;
			
		}

	
}


