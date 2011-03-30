package DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.Perfil;
import modelo.Usuario;

import org.hibernate.Query;
import org.hibernate.Session;

public class UsuarioDAO {
	private Session session;
	public UsuarioDAO (Session s) {
		session = s;
	}
	public void salva (Usuario p) {
		session.save(p);
		session.beginTransaction().commit();
	}
	public void remove (Usuario p) {
		session.delete(p);
		session.beginTransaction().commit();
	}
	public Usuario procura(Long id) {
		return (Usuario) session.load(Usuario.class, id);
	}
	
	public List<Usuario> procura(String login, String senha) {
		Query query = this.session.createQuery("from Usuario where login = :login and senha=:senha"); 
		query.setString("login", login);
		query.setString("senha", senha);
		return query.list();
	}	
	
	public List<Usuario> procuraPorPerfil(Perfil perfil) {
		Query query = this.session.createQuery("from Usuario where perfil = :perfil"); 
		query.setEntity("perfil", perfil);
		return query.list();
	}
	
	public void atualiza (Usuario p) {
		session.saveOrUpdate(p);
		session.beginTransaction().commit();
	}
	@SuppressWarnings("unchecked")
	public List<Usuario> listaTudo() {
		return this.session.createCriteria(Usuario.class).list();
	}
}
