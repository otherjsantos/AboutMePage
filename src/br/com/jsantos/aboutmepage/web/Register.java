package br.com.jsantos.aboutmepage.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jsantos.aboutmepage.dao.ConnectionPool;
import br.com.jsantos.aboutmepage.dao.UsuariosDAO;
import br.com.jsantos.aboutmepage.model.Usuario;

@WebServlet(urlPatterns = "/register")
public class Register extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try (Connection connection = new ConnectionPool().getConnection()) {

			String nome = req.getParameter("nome");
			String sobrenome = req.getParameter("sobrenome");
			String login = req.getParameter("login");
			String password = req.getParameter("password");
			Usuario usuario = new Usuario(nome, sobrenome, login, password);

			UsuariosDAO usuarioDAO = new UsuariosDAO(connection);
			
			List<Usuario> usuarios = usuarioDAO.listar();
			
			for(Usuario usuarioLista : usuarios) {
				System.out.println(usuarioLista);
			}
			
			req.setAttribute("usuario", usuario);
			
			if(usuarioDAO.cadastrar(usuario)) {
				RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/registerComSucesso.jsp");
				dispatcher.forward(req, resp);
			}
			else {
				RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/registerComErro.jsp");
				dispatcher.forward(req, resp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
