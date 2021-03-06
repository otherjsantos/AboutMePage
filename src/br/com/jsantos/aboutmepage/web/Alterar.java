package br.com.jsantos.aboutmepage.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.jsantos.aboutmepage.dao.ConnectionPool;
import br.com.jsantos.aboutmepage.dao.UsuariosDAO;
import br.com.jsantos.aboutmepage.model.Usuario;

@WebServlet(urlPatterns = "/alterar")
public class Alterar extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");

		if (usuario.getPassword().equals(req.getParameter("passwordAtual"))) {
			try (Connection c = new ConnectionPool().getConnection()) {

				UsuariosDAO usuarioDAO = new UsuariosDAO(c);

				String nome = req.getParameter("nome");
				String sobrenome = req.getParameter("sobrenome");
				String login = req.getParameter("login");
				String password = req.getParameter("password");
				Usuario novoUsuario = new Usuario(nome, sobrenome, login, password);

				Usuario usuarioLogado = usuarioDAO.alterar(usuario.getLogin(), novoUsuario);
				session.setAttribute("editON", false);
				session.setAttribute("usuarioLogado", usuarioLogado);

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			session.setAttribute("editON", true);
			session.setAttribute("validacaoFalha", true);
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("register.jsp");
		dispatcher.forward(req, resp);
	}
}
