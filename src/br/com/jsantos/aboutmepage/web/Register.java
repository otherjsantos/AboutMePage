package br.com.jsantos.aboutmepage.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jsantos.aboutmepage.dao.ConnectionPool;
import br.com.jsantos.aboutmepage.dao.UsuariosDAO;

@WebServlet(urlPatterns = "/register")
public class Register extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String login = req.getParameter("login");
		String password = req.getParameter("password");

		try (Connection con = new ConnectionPool().getConnection()) {
			UsuariosDAO usuarioDAO = new UsuariosDAO(con);
			usuarioDAO.cadastrar(login, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
