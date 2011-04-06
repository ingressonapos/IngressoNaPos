<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Cadastro de Curr&iacute;culo</title>
		<link href="css/layout.css" rel="stylesheet" type="text/css" />
		<link href="css/menu.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<center>
			<div id="principal">
				<div id="menu"><%@ include file="../menu.jsp"%></div>
				<div id="corpo"> 
					<h1>Curr&iacute;culo</h1>
					<form action="<c:url value='/dadosusuario'/>" method="post" class="texto">
						<h2>1. Formação Acadêmica</h2><br />
						<h3>Formação Superior (Graduação)</h3><br />
						Instituição: <input type="text" name="cadastroUsuario.nomeCompleto" /><br />
						Curso: <input type="text" name="cadastroUsuario.nomeCompleto" /><br />
						Data de in&iacute;cio: <input type="date" name="cadastroUsuario.dataNascimento" /><br />
						Data de t&eacute;rmino: <input type="radio" name="cadastroUsuario.estadoCivil" />
						T&iacute;tulo obtido: <input type="radio" name="cadastroUsuario.tipoID" value="RNE" />RNE:
						<h2>2. Endereços</h2>
						<h3>Endereço Permanente</h3><br />
						<input type="submit" value="Acessar" />
					</form>
				</div>
				<div id="menu"><%@ include file="../rodape.jsp"%></div>
			</div>
	
		</center>
	</body>
</html>