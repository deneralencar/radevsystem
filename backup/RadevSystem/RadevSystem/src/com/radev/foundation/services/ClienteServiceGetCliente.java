package com.radev.foundation.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.json.JSONException;


public class ClienteServiceGetCliente extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteServiceGetCliente() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("json");
		int id = Integer.parseInt(request.getParameter("id"));
		
		DTOCliente cliente = new DTOCliente();		
		PrintWriter out = response.getWriter();
		try {
			out.print(cliente.getCliente(id));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		out.close();
		
	}
}
