package com.radev.foundation.controller;

import java.util.List;

import com.radev.foundation.entity.Cliente;
import com.radev.foundation.entity.Pedido;
import com.radev.foundation.entity.Usuario;

public interface ClienteController {
	public Cliente findByLogin(String login);
	public void persist(Cliente cliente) throws Exception;
	public List<Cliente> listAll();
	public boolean excluir(int i);
	public Cliente findById(int id);
}
