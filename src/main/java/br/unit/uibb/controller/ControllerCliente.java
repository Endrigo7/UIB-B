package br.unit.uibb.controller;

import java.util.List;

import br.unit.uibb.dao.ClienteDaoHibernate;
import br.unit.uibb.entidades.Cliente;

public class ControllerCliente {
	
	private ClienteDaoHibernate clienteDaoHibernate;
	
	public ControllerCliente() {
		clienteDaoHibernate = new ClienteDaoHibernate();
	}
	
	public void save(Cliente cliente) {
		clienteDaoHibernate.save(cliente);
	}
	
	public List<Cliente> getAll() {
		return clienteDaoHibernate.getAll();
	}
	
}
