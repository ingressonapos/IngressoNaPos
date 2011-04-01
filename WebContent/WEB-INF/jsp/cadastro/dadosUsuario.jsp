<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Cadastro de Usu&aacute;rio</title>
		<link href="css/layout.css" rel="stylesheet" type="text/css" />
		<link href="css/menu.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<center>
			<div id="principal">
				<div id="menu"><%@ include file="../menu.jsp"%></div>
				<div id="corpo"> 
					<h1>Cadastro</h1>
					<form action="<c:url value='/dadosusuario'/>" method="post" class="texto">
						<h2>1.Dados Pessoais</h2><br />
						Nome Completo: <input type="text" name="cadastroUsuario.nomeCompleto" /><br />
						Data de Nascimento: <input type="date" name="cadastroUsuario.dataNascimento" /><br />
						Estado Civil: <input type="radio" name="cadastroUsuario.estadoCivil" value="S"/>Solteiro
									  <input type="radio" name="cadastroUsuario.estadoCivil" value="C"/>Casado
									  <input type="radio" name="cadastroUsuario.estadoCivil" value="D"/>Divorciado
									  <input type="radio" name="cadastroUsuario.estadoCivil" value="V"/>Vi&uacute;vo<br />
						<input type="radio" name="cadastroUsuario.tipoID" value="RG" />RG ou 
						<input type="radio" name="cadastroUsuario.tipoID" value="RNE" />RNE
						<input type="text" name="cadastroUsuario.numeroID"> 
						CPF: <input type="text" name="cadastroUsuario.cpf" /><br />
						Nacionalidade: <input type="text" name="cadastroUsuario.nacionalidade" /><br />
						<br />
						<h2>2. Endereços</h2>
						<h3>Endereço Permanente</h3><br />
						Logradouro: <input type="text" name="cadastroUsuario.endereco.logradouro" />
						N&uacute;mero: <input type="text" name="cadastroUsuario.endereco.numero" /><br />
						Complemento: <input type="text" name="cadastroUsuario.endereco.complemento" /><br />
						CEP: <input type="text" name="cadastroUsuario.cep.regiao" size=5 />
							 <input type="text" name="cadastroUsuario.cep.sufixo" size=3 /><br />
						Cidade: <input type="text" name="cadastroUsuario.endereco.cidade" />
						Estado: <input type="text" name="cadastroUsuario.endereco.estado" /><br />
						Telefone: <input type="text" name="cadastroUsuario.endereco.telefone" /><br />
						<h3>Endereço para Correspondência</h3><br />
						Logradouro: <input type="text" name="cadastroUsuario.endereco2.logradouro" />
						N&uacute;mero: <input type="text" name="cadastroUsuario.endereco2.numero" /><br />
						Complemento: <input type="text" name="cadastroUsuario.endereco2.complemento" /><br />
						CEP: <input type="text" name="cadastroUsuario.cep.regiao" size=5 />
							 <input type="text" name="cadastroUsuario.cep.sufixo" size=3 /><br />
						Cidade: <input type="text" name="cadastroUsuario.endereco2.cidade" />
						Estado: <input type="text" name="cadastroUsuario.endereco2.estado" /><br />
						Telefone: <input type="text" name="cadastroUsuario.endereco2.telefone" /><br />
						<input type="submit" value="Acessar" />
					</form>
				</div>
				<div id="menu"><%@ include file="../rodape.jsp"%></div>
			</div>
	
		</center>
	</body>
</html>