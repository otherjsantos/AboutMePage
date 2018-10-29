package br.com.jsantos.aboutmepage.model;

public class Usuario {

	private Integer id;
	private String nome;
	private String sobrenome;
	private String login;
	private String password;
	
	public Usuario(String nome, String sobrenome, String login, String password) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.login = login;
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Usuário "+this.id+" - "+this.login+" adicionado!";
	}
}
