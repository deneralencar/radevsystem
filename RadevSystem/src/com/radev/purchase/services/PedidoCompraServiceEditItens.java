package com.radev.purchase.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserService
 */
public class PedidoCompraServiceEditItens extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PedidoCompraServiceEditItens() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("json");

		String cabecalho[] = stringToList(request.getParameter("cabecalho"));
		String item[] = stringToList(request.getParameter("item"));
		String codigo[] = stringToList(request.getParameter("codigo"));
		String qtd[] = stringToList(request.getParameter("qtd"));	

		 DTOPedidoCompra pedidoCompra = new DTOPedidoCompra();
		  
		  PrintWriter out = response.getWriter(); 
		  try {			  
			  out.print(pedidoCompra.editItensPedido(Integer.parseInt(cabecalho[0]), Float.parseFloat(cabecalho[1]), item, codigo, qtd));
		  
		  } catch
		  (Exception e) { // TODO Auto-generated catch block
			  e.printStackTrace(); 
		  } out.close();		 

	}
	
	
	private String[] stringToList(String str){
		String tsrList[] = str.replace("[\"", "").replace("\"]", "").split("\",\"");
	
		return tsrList;
	}
	

	
	

}
