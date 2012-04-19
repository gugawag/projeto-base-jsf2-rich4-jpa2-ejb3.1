package com.gugawag.projeto.repositorio;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.gugawag.projeto.modelo.Usuario;

@Stateless
public class UsuarioRepositorio {
	
	@PersistenceContext
	private EntityManager em;
	
	public void cadastrarUsuario(Usuario usuario){
		em.persist(usuario);
	}
	
	public List<Usuario> getUsuarios(){
		return em.createQuery("from Usuario").getResultList();
	}
	
	public Usuario getUsuarioPorLogin(String login){
		List<Usuario> usuarios = em.createQuery("from Usuario u where u.login=:login").setParameter("login", login).getResultList();
		if (usuarios != null && usuarios.size()>0){
			return usuarios.get(0);
		}
		return null;
	}

}
