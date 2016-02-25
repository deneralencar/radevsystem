package com.radev.purchase.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.json.JSONException;

public class FornecedorServiceList extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public FornecedorServiceList() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	
		DTOFornecedor fornecedores = new DTOFornecedor();
		
		PrintWriter out = response.getWriter();
		try {
			out.print(fornecedores.getFornecedores());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		out.close();
		
	}
	
}
