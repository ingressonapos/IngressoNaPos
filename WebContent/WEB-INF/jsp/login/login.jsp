<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login</title>
		<link href="css/layout.css" rel="stylesheet" type="text/css" />
		<link href="css/menu.css" rel="stylesheet" type="text/css" />
	</head>
	
<body>
	<center>
		<div id="principal">
			<div id="menu"><%@ include file="../menu.jsp"%></div>
			<div id="corpo">
				<form action="<c:url value='/login'/>" method="post" class="texto">
					Login: <input type="text" name="usuario.login" /><br />
					Senha: <input type="password" name="usuario.senha" />
					<br />
					<br />
					<input type="submit" value="Acessar" />
				</form>
			</div>
			<div id="menu"><%@ include file="../rodape.jsp"%></div>
		</div>
	
	</center>

</body>