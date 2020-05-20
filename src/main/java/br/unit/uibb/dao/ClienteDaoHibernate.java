package br.unit.uibb.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.unit.uibb.entidades.Cliente;

public class ClienteDaoHibernate {

	public void save(Cliente cliente) {
		Transaction transaction = null;

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(cliente);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<Cliente> getAll() {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			List<Cliente> clientes = session.createQuery("SELECT c FROM Cliente c", Cliente.class).list();
			return clientes;
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return new ArrayList<Cliente>();
	}
}
