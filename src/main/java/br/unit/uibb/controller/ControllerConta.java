package br.unit.uibb.controller;

import java.util.List;

import br.unit.uibb.dao.ContaDaoHibernate;
import br.unit.uibb.entidades.Conta;

public class ControllerConta {
	
	private ControllerCliente controllerCliente;
	private ContaDaoHibernate contaDaoHibernate;
	
	public ControllerConta() {
		contaDaoHibernate = new ContaDaoHibernate();
		controllerCliente = new ControllerCliente();
	}
	
	public void save(Conta conta) {
		controllerCliente.save(conta.getCliente());
		contaDaoHibernate.save(conta);
	}

	public List<Conta> getAll() {
		return contaDaoHibernate.getAll();
	}
	
}
