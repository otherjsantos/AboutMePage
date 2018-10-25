package br.com.jsantos.aboutmepage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.jsantos.aboutmepage.model.Usuario;

public class UsuariosDAO {

	private Connection con;

	public UsuariosDAO(Connection con) {
		this.con = con;
	}

	public void cadastrar(String login, String password) throws SQLException {

		String sql = "INSERT INTO usuario(login, password) values(?, ?)";
		
		try(PreparedStatement stm = con.prepareStatement(sql)){
			stm.setString(1, login);
			stm.setString(2, password);
			stm.execute();
		}
	}

	public Usuario busca(String login, String password) throws SQLException {

		Usuario usuario = null;
		String sql = "SELECT * FROM usuario WHERE login = ? AND password = ?";
		try (PreparedStatement pStm = con.prepareStatement(sql)) {
			pStm.setString(1, login);
			pStm.setString(2, password);
			pStm.execute();
			try (ResultSet rs = pStm.getResultSet()) {
				while (rs.next()) {
					int id = rs.getInt("id");
					String nome = rs.getString("login");
					String senha = rs.getString("password");

					usuario = new Usuario(nome, senha);
					usuario.setId(id);
				}
			}
		}
		return usuario;
	}

}
