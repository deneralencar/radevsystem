package com.radev.purchase.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.json.JSONException;

/**
 * Servlet implementation class UserService
 */
public class PedidoCompraServiceList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PedidoCompraServiceList() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DTOPedidoCompra pedidoCompra = new DTOPedidoCompra();
		
		PrintWriter out = response.getWriter();
		try {
			out.print(pedidoCompra.getpedidos());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		out.close();
		
	}
	
}
