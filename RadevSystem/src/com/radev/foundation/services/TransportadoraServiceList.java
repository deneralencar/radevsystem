package com.radev.foundation.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.json.JSONException;

public class TransportadoraServiceList extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public TransportadoraServiceList() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		DTOTransportadora transportadora = new DTOTransportadora();
		
		PrintWriter out = response.getWriter();
		try {
			out.print(transportadora.getTransportadoras());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		out.close();
		
	}
	
}
