package DAO;

import modelo.Perfil;
import modelo.Usuario;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
	private static SessionFactory factory;
	static {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Usuario.class);
		cfg.addAnnotatedClass(Perfil.class);
		
		factory = cfg.buildSessionFactory();
	}
	public Session getSession() {
		return factory.openSession();
	}
}
