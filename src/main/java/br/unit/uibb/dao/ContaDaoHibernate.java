package br.unit.uibb.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.unit.uibb.entidades.Conta;

public class ContaDaoHibernate {

	public void save(Conta conta) {
		Transaction transaction = null;

		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(conta);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<Conta> getAll() {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			return session.createQuery("SELECT c FROM Conta", Conta.class).list();
		}catch(Exception e) {
		}
		
		return null;
	}
}
