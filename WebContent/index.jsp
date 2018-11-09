<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<% %>
<html>
	<head>
		<title>Biografia - Jo�o da Silva</title>
		<meta charset="utf-8">
		<link rel="icon" href="img/favicon.png">
		<link rel="stylesheet" href="css/reset.css">
		<link rel="stylesheet" href="css/site.css">
		<link rel="stylesheet" href="css/bio.css">
		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Crimson+Text:400,400italic,600">
		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans+Condensed:700">
	</head>
	<body>
		<main>
			<h1 class="titulo-principal">Sobre mim</h1>

			<div class="container">
				<p>Moro em S�o Paulo mas atendo clientes do mundo todo. Sou conhecido por fazer produtos de <em>qualidade</em>, <em>durabilidade</em> e que <em>agregam valor</em> para meus clientes.</p>

				<p>Trabalho usando a web como plataforma, ou seja, respiro HTML5, CSS3 e JavaScript (ou melhor: ECMASCript). Crio sites para todos, seguindo as principais diretivas de acessibilidade, responsividade e web semântica, sem descuidar da qualidade de código.</p>

				<h2 class="subtitulo-texto">Como trabalho</h2>

				<blockquote class="citacao-bio fiat">
					<p>João é o melhor desenvolvedor front-end com quem já trabalhei. Muito eficiente e muito capaz. Recomendo sem dúvidas!</p>
					<cite>José Souza, Fiat</cite>
				</blockquote>

				<p>Satisfazer meus clientes é prioridade. Para isso, garanto um processo de desenvolvimento altamente interativo, baseado em feedback contínuo. <strong>Não trabalho com escopo fechado</strong>: o cliente é que decide quando o produto está pronto.</p>

				<p>Também não trabalho com prazos fechados: <strong>qualidade é importante demais para ser sacrificada</strong>.</p>

				<h2 class="subtitulo-texto">Experiência</h2>

				<blockquote class="citacao-bio petrobras">
					<p>João domina as tecnologias como ninguém. Eu apresentava um problema, ele tinha na ponta da língua a solução mais adequada com as tecnologias mais recentes.</p>
					<cite>Manoel Santos, Petrobrás</cite>
				</blockquote>

				<p>Já desenvolvi projetos para grandes empresas como <a href="http://www.bmw.com">BMW</a>, <a href="http://www.uol.com.br">UOL</a> e <a href="http://www.ibm.com.br">IBM</a>. Neles, o foco principal era entregar uma experiência imersiva e impactante para o usuário final sem descuidar do desempenho e da acessibilidade da página.</p>

				<p>Também já fui contratado para transformar grandes portais, como <a href="http://www.terra.com.br">Terra</a> e <a href="http://www.g1.globo.com">G1</a>, em páginas responsivas. Fui responsável por renovar o layout, reorganizar o conteúdo e re-escrever o código de forma mais reaproveitável.</p>

				<h2 class="subtitulo-texto">Comunidade</h2>

				<p>Procuro repassar meu conhecimento para a comunidade. Para isso, já dei <a href="portfolio.html">diversas palestras</a> e mantenho um <a href="blog.html">blog</a>.</p>
			</div>
		</main>
		<img src="img/eu.jpg" alt="Foto de João da Silva" class="minha-foto">
		<aside class="navegacao-site">
			<h1>Jo�o da Silva</h1>
			<nav>
				<ul>
					<li><a href="index.jsp">Home</a></li>
					<li><a href="portfolio.html">Portfolio</a></li>
					<li><a href="blog.html">Blog</a></li>
				</ul>
			</nav>
			<ul class="icones-redes-sociais">
				<li>
					<a class="github" href="https://github.com/joaodasilva">
						Github
					</a>
				</li>
				<li>
					<a class="twitter" href="https://twitter.com/joaodasilva">
						Twitter
					</a>
				</li>
				<li>
					<a class="linkedin" href="https://br.linkedin.com/pub/joão-da-silva/32/4/508">
						LinkedIn
					</a>
				</li>
			</ul>
			
			<c:choose>
				<c:when test="${triedAcess != true}">
					<c:import url="/WEB-INF/paginas/FormLogin.html"/>
					<a href="register.html"> <input type="button" value="Register"/> </a>
				</c:when>
				<c:otherwise>
					<c:if test="${usuarioLogado != null}">
						<p>${usuarioLogado.getLogin()}</p>
						<form action="logout" method="post">
							<input type="submit" value="Logout"/>
						</form>
					</c:if>
					<c:if test="${usuarioLogado == null}">
						<c:import url="/WEB-INF/paginas/FormLogin.html"/>
						<a href="register.html"> <input type="button" value="Register"/> </a>
						<p>Usu�rio invalido!</p>
						<%session.invalidate();%>				
					</c:if>
				</c:otherwise>
			</c:choose>
			
		</aside>
		<footer class="rodape-pagina">
			&copy; João da Silva 2014
		</footer>
	</body>
</html>