package br.com.jsantos.aboutmepage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.jsantos.aboutmepage.model.Usuario;

public class UsuariosDAO {

	private Connection con;

	public UsuariosDAO(Connection con) {
		this.con = con;
	}

	public Boolean cadastrar(Usuario usuario) throws SQLException {

		String sql = "INSERT INTO usuario(nome, sobrenome, login, password) values(?, ?, ?, ?)";

		Boolean isCadastrado = false;
		
		try (PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, usuario.getNome());
			statement.setString(2, usuario.getSobrenome());
			statement.setString(3, usuario.getLogin());
			statement.setString(4, usuario.getPassword());
			statement.execute();

			try (ResultSet resultSet = statement.getGeneratedKeys()) {
				isCadastrado = resultSet.next();
				if (isCadastrado) {
					usuario.setId(resultSet.getInt("id"));
				}
			}
		}
		return isCadastrado;
	}
	
	public List<Usuario> listar() throws SQLException{
		
		String sql = "SELECT * FROM usuario";
		List<Usuario> usuarios = new ArrayList<>();
		
		try(PreparedStatement statement = con.prepareStatement(sql)){

			statement.execute();
			
			try(ResultSet rs = statement.getResultSet()){
			
				while(rs.next()) {
					int id = rs.getInt("id");
					String nome = rs.getString("nome");
					String sobrenome = rs.getString("sobrenome");
					String login = rs.getString("login");
					String password = rs.getString("password");					
					Usuario usuario = new Usuario(nome, sobrenome, login, password);
					usuario.setId(id);
					
					usuarios.add(usuario);
				}
			}
		}
		return usuarios;
	}
}
