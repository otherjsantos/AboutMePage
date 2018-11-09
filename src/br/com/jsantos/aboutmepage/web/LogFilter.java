package br.com.jsantos.aboutmepage.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import br.com.jsantos.aboutmepage.model.Usuario;

@WebFilter(urlPatterns="/*")
public class LogFilter implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		String usuarioLogin = "Usuário deslogado";
		
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioLogado");
		if(usuario != null)
			usuarioLogin = usuario.getLogin();
		
		System.out.println(usuarioLogin+" acessando a URI: " + req.getRequestURI());
		
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
