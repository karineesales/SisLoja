package loja.dw;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class GerenciadorDeAutenticacao {
	
	List<Usuario> usuarios;
	private int senhaInterna = 260516;
	
	public GerenciadorDeAutenticacao() {
		this.usuarios = new ArrayList<Usuario> ();
	}
	
	public void cadastrarUsuario (String nome, String cpf, String rg, String login, String senha) throws UsuarioJaCadastrado {
		boolean usuarioExiste = false;
		for(Usuario a : this.usuarios) {
			if(a.getCpf().equals(cpf)) {
				usuarioExiste = true;
			}
		}
		if(usuarioExiste==false) {
			Usuario us = new Usuario (nome, cpf, rg, login, senha);
			this.usuarios.add(us);
		}
		else {
			throw new UsuarioJaCadastrado("Usuário já é cadastrado!");
		}
		
	}
	
	public void removerUsuario(String cpf) throws UsuarioNaoCadastrado {
		boolean usuarioExiste = false;
		Usuario aux = null;
		for(Usuario a : this.usuarios) {
			if(a.getCpf().equals(cpf)) {
				usuarioExiste = true;
				aux = a;
			}
		}
		if(usuarioExiste==true) {
			this.usuarios.remove(aux);
			JOptionPane.showMessageDialog(null,"Usuário Removido!");
		}
		else {
			throw new UsuarioNaoCadastrado("Usuário não foi encontrado");
		}
		
	}
	
	public String autenticar (String login, String senha) throws AutenticacaoIncorreta {
		boolean usuarioLogado = false;
		Usuario us = null;
		for(Usuario u: this.usuarios) {
			if(u.getLogin().equals(login) && u.getSenha().equals(senha)) {
				us = u;
				usuarioLogado = true;
			}
		}
		if(usuarioLogado==false) {
			throw new AutenticacaoIncorreta("Verifique seu login e senha.");
		}
		else {
			return us.getNome();
		}
		 
	}
	
	public boolean acessarSistemaDeUsuario (int senha) {
		boolean acesso = false;
		if(senhaInterna==senha) {
			acesso = true;
		}
		return acesso;
	}
	

}
