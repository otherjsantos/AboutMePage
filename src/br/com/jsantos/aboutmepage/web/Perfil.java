package br.com.jsantos.aboutmepage.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.jsantos.aboutmepage.model.Usuario;

@WebServlet(urlPatterns="/perfil")
public class Perfil extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
		HttpSession session = req.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		
		
		
	}
}
