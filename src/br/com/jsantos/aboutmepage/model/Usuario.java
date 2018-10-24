package br.com.jsantos.aboutmepage.model;

public class Usuario {

	private Integer id;
	private String login;
	private String password;
	
	public Usuario(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Usuario:" + login;
	}
}
