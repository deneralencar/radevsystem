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
public class PedidoCompraServiceDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PedidoCompraServiceDelete() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("json");
		String id = request.getParameter("id");
		
		DTOPedidoCompra pedidoCompra = new DTOPedidoCompra();
		
		PrintWriter out = response.getWriter();
		out.print(pedidoCompra.delete(Integer.parseInt(id)));
		out.close();
		
	}
	
}
