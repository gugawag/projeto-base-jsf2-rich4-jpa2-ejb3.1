package com.gugawag.projeto.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.gugawag.projeto.modelo.Usuario;
import com.gugawag.projeto.service.CadastroUsuarioService;
import com.gugawag.projeto.service.UsuarioJahCadatradoException;

@ManagedBean
@SessionScoped
public class UsuarioBean{
	
	private Usuario usuario;
	
	public UsuarioBean(){
		usuario = new Usuario();
	}
	
	@EJB
	private CadastroUsuarioService usuarioService;
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Usuario> getUsuarios(){
		return usuarioService.getUsuarios();
	}

	public String cadastrar(){
		try {
			usuarioService.cadastrarUsuario(usuario);
			Util.acrescentaMensagem("usuario.cadastrosucesso", new String[]{usuario.getLogin()});
		} catch (UsuarioJahCadatradoException e) {
			Util.acrescentaMensagem("usuario.usuariojahcadastrado", new String[]{usuario.getLogin()});
		}
		return null;
	}

}
