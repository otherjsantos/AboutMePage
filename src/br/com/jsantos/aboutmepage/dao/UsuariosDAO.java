package br.com.jsantos.aboutmepage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.jsantos.aboutmepage.model.Usuario;

public class UsuariosDAO {

	private Connection con;

	public UsuariosDAO(Connection con) {
		this.con = con;
	}

	public void cadastrar(Usuario usuario) throws SQLException {

		String sql = "INSERT INTO usuario(nome, sobrenome, login, password) values(?, ?, ?, ?)";

		try (PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, usuario.getNome());
			statement.setString(2, usuario.getSobrenome());
			statement.setString(3, usuario.getLogin());
			statement.setString(4, usuario.getPassword());
			statement.execute();

			try (ResultSet resultSet = statement.getGeneratedKeys()) {
				if (resultSet.next()) {
					usuario.setId(resultSet.getInt("id"));
				}
			}

			System.out.println(usuario);
		}
	}
}
