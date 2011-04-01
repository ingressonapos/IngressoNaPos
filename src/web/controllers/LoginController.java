package web.controllers;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;


import DAO.*;
import modelo.*;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Resource
public class LoginController {

	private Result result;
	private UsuarioSessao usuarioSessao;

	public LoginController(Result result, UsuarioSessao usuarioSessao) {
		this.result = result;
		this.usuarioSessao = usuarioSessao;
	}

	@Get
	@Path("/login")
	public void login() {
	}

	@Post
	@Path("/login")
	public void login(modelo.Usuario usuario) {
		Session s = new HibernateUtil().getSession();		
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO(s);
			List<Usuario> usuarios = usuarioDAO.Login(usuario.getLogin(), usuario.getSenha());
			s.close();
			if(!usuarios.isEmpty()){
				usuarioSessao.setUsuario(usuarios.get(0));
				result.redirectTo(IndexController.class).index();
			}else{
				result.use(Results.logic()).redirectTo(getClass()).login();
			}
		} catch (Exception e) {
			s.close();
			e.printStackTrace();
			result.use(Results.logic()).redirectTo(getClass()).login();
		}
	}
		

	@Get
	@Path("/logout")
	public void logout() {
		usuarioSessao.setUsuario(null);
		result.redirectTo(getClass()).login();
	}

}
