package com.radev.purchase.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.json.JSONException;

/**
 * Servlet implementation class UserService
 */
public class PedidoCompraServiceGetPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PedidoCompraServiceGetPedido() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("json");
		int id = Integer.parseInt(request.getParameter("id"));
		
		DTOPedidoCompra pedidoCompra = new DTOPedidoCompra();		
		PrintWriter out = response.getWriter();
		try {
			out.print(pedidoCompra.getpedido(id));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		out.close();
		
	}
	
}
