package br.unit.uibb.dao;


import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import br.unit.uibb.entidades.Cliente;
import br.unit.uibb.entidades.Conta;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			
			try {
				Configuration configuration = new Configuration();
				
				Properties settings = new Properties();
				
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver"); //mudar
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/UIBB?useSSL=false");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "123");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				
				settings.put(Environment.HBM2DDL_AUTO, "update");
				configuration.setProperties(settings);
				
				configuration.addAnnotatedClass(Cliente.class);
				configuration.addAnnotatedClass(Conta.class);
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return sessionFactory;
	}

}
