package com.radev.foundation.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClienteServiceAltera extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClienteServiceAltera() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("json");
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String cpf = request.getParameter("cpf");
		String rg = request.getParameter("rg");
		String endereco = request.getParameter("endereco");
		String estado  = request.getParameter("estado");
		String cidade  = request.getParameter("cidade");
		String ddd = request.getParameter("ddd");
		String fone = request.getParameter("fone");
        String  limitecredito = request.getParameter("limitecredito"); 
		
		DTOCliente cliente = new DTOCliente();
		
		PrintWriter out = response.getWriter();
		try {
			out.print(cliente.alteraCliente(nome, email, cpf, rg, endereco, estado, cidade, ddd, fone, limitecredito));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.close();
		
	}
	
}
