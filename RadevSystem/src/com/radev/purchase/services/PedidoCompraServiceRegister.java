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
public class PedidoCompraServiceRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PedidoCompraServiceRegister() {
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

		DTOPedidoCompra pedido = new DTOPedidoCompra();
		  
		PrintWriter out = response.getWriter();
		
		try {			  
<<<<<<< HEAD
			out.print(pedido.registerpedido(cabecalho[1], cabecalho[0], cabecalho[5], cabecalho[4], cabecalho[2], cabecalho[3], cabecalho[6], cabecalho[7], cabecalho[8], item, codigo, qtd));	  
=======
			out.print(pedido.registerpedido(cabecalho[1], cabecalho[0], cabecalho[5], cabecalho[4], cabecalho[2], cabecalho[3], cabecalho[6], cabecalho[7], item, codigo, qtd));	  
>>>>>>> branch 'master' of https://github.com/deneralencar/radevsystem.git
		} catch (Exception e) {
			System.out.print(e);
			e.printStackTrace(); 
		} 
		
		out.close();		 

	}
	
	
	private String[] stringToList(String str){
		String tsrList[] = str.replace("[\"", "").replace("\"]", "").split("\",\"");
	
		return tsrList;
	}
	

	
	

}
