<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	</head>
	<body>
		<c:choose>
			<c:when test="${usuarioLogado != null && editON != true}">
				<form action="editar" method="post">
					Nome: ${usuarioLogado.getNome()}<br />
					Sobrenome: ${usuarioLogado.getSobrenome()}<br />
					Login: ${usuarioLogado.getLogin()}<br />
					Password: ${usuarioLogado.getPassword()}<br />
					<input type="submit" value="Editar" />
					<a href="index.jsp"><input type="button" value="Voltar" /></a>
				</form>
			</c:when>
			<c:when test="${usuarioLogado != null && editON == true}">
				<form action="alterar" method="post">
					Nome: <input type="text" value="${usuarioLogado.getNome()}" name="nome" /><br />
					Sobrenome: <input type="text" value="${usuarioLogado.getSobrenome()}" name="sobrenome" /><br />
					Login: <input type="text" value="${usuarioLogado.getLogin()}" name="login" /><br />
					Password: <input type="password" value="${usuarioLogado.getPassword()}" name="password" /><br />
					Senha atual: <input type="password" name="passwordAtual" /><br />
					<input type="submit" value="Salvar" />
					<a href="index.jsp"><input type="button" value="Voltar" /></a><br />
					<c:if test="${validacaoFalha == true}">
						Senha incorreta!
					</c:if>
				</form>
			</c:when>
			<c:otherwise>
				<h1>Bem vindo ao cadastro de usuário, vamos começar:</h1>
				<form action="register" method="post">
					Nome: <input type="text" name="nome" /><br />
					Sobrenome: <input type="text" name="sobrenome" /><br />
					Login: <input type="text" name="login" /><br />
					Password: <input type="password" name="password" /><br />
					<input type="submit" value="Register" /><br />
					<a href="index.jsp"><input type="button" value="Voltar" /></a>
				</form>
			</c:otherwise>
		</c:choose>
	</body>
</html>