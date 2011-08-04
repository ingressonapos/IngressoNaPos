<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="system_title" /></title>
<link href="<c:url value='/css/layout.css'/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value='/css/menu.css'/>" rel="stylesheet"
	type="text/css" />
</head>

<body>
<center>
<div id="principal">
<div id="menu"><%@ include file="../menu.jsp"%></div>
<div id="corpo">

<div id="login" style="width: 400px; margin: 0 auto;">


<h1>Bem-Vindo ao Sistema de Inscrição na Pós-Graduação do IME/USP</h1>

<form action="<c:url value='/login'/>" method="post">

<table>
	<tr>
		<td><b>Login:</b><br />
		<br />
		</td>
	</tr>
	<tr>
		<td><fmt:message key="login_user" /></td>
		<td><input id="login" name="usuario.login" type="text"
			style="width: 100px" /></td>
	</tr>
	<tr>
		<td><fmt:message key="login_password" /></td>
		<td><input id="senha" name="usuario.senha" type="password"
			maxlength="10" style="width: 100px" /></td>
	</tr>
	<tr>
		<td></td>
		<td><input id="submit" name="submit" type="submit" value="Entrar" /></td>
	</tr>
	<tr>
		<td></td>
		<td>Esqueci minha senha</td>
	</tr>
</table>
</form>
<br />
<p><b>Novo usuário?</b> <a href="#">Cadastrar-se</a></p>


</div>



</div>
<div id="menu"><%@ include file="../rodape.jsp"%></div>
</div>

</center>

</body>