package loja.dw;

public class Usuario {
	private String nome;
	private String cpf;
	private String rg;
	private String login;
	private String senha;
	
	public Usuario (String nome, String cpf, String rg, String login, String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.login = login;
		this.senha = senha;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
