package br.com.jsantos.aboutmepage.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.jsantos.aboutmepage.dao.ConnectionPool;
import br.com.jsantos.aboutmepage.dao.UsuariosDAO;
import br.com.jsantos.aboutmepage.model.Usuario;

@WebServlet(urlPatterns = "/acess")
public class Acess extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String login = req.getParameter("login");
		String password = req.getParameter("password");
		
		try(Connection con = new ConnectionPool().getConnection()){
			UsuariosDAO usuarioDAO = new UsuariosDAO(con);
			Usuario usuario = usuarioDAO.validar(login, password);
			
			HttpSession session = req.getSession();
			session.setAttribute("usuarioLogado", usuario);
			session.setAttribute("triedAcess", true);
			session.setMaxInactiveInterval(5*60);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
			dispatcher.forward(req, resp);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
