<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Cadastro de Usu&aacute;rio</title>
		<link href="<c:url value='/css/style.css'/>" rel="stylesheet" type="text/css" />
		<link href="<c:url value='/css/layout.css'/>" rel="stylesheet" type="text/css" />
		<link href="<c:url value='/css/menu.css'/>" rel="stylesheet" type="text/css" />
	</head>

	<body>
	<center>		
		<div id="principal">
		<div id="menu"><%@ include file="../menu.jsp"%></div>
			<div id="corpo">
				<center><h1>Cadastro</h1></center>
				<div id="form" style="width: 445px; margin: 100px auto;">
				
				<form>
				<fieldset>
				<legend><b>Dados Pessoais</b></legend>
				
				<div class="row">
					<span class="label">Nome Completo</span>
					<span class="formw"><input type="text" name="dadosPessoais.nomeCompleto" /></span><br/>
				</div>
				<div class="row">
					<span class="label">Data de Nascimento</span>
					<span class="formw"><input type="date" name="dadosPessoais.dataNascimento" /></span><br/>
				</div>
				<div class="row">
					<span class = "label"> Estado Civil</span>
					<span class = "formw"> <select name="dadosPessoais.estadoCivil" id="selectMultiple">
						<option>Solteiro(a)</option>
						<option>Casado(a)</option>
						<option>Divorciado(a)</option>
						<option>Vi&uacute;vo(a)</option>
					</select><br /> </span>
				</div>
				<div class="row">
					<span class = "label"> Documento</span>
					<span class = "formw"> <select name="dadosPessoais.tipoID" id="selectMultiple">
						<option>RG</option>
						<option>RNE</option>
					</select><br /> </span>
				</div>
				<div class="row">
					<span class="label">N&uacute;mero</span>
					<span class="formw"><input type="text" name="dadosPessoais.numeroID" /></span><br/>
				</div>
				<div class="row">
					<span class="label">CPF</span>
					<span class="formw"><input type="text" name="dadosPessoais.cpf" /></span><br/>
				</div>
				<div class="row">
					<span class="label">Nacionalidade</span>
					<span class="formw"><input type="text" name="dadosPessoais.nacionalidade" /></span><br/>
				</div>
						
				</fieldset>
				<br>
				
				<fieldset>
				<legend><b>Endereços</b></legend>							
				<b>Endereço Permanente</b><br />
				
				<div class="row">
					<span class="label">Logradouro</span>
					<span class="formw"><input type="text" name="dadosPessoais.endereco.logradouro" /></span><br />
				</div>
				<div class="row">
					<span class="label">N&uacute;mero</span>
					<span class="formw"><input type="text" name="dadosPessoais.endereco.numero" /></span><br />
				</div>
				<div class="row">
					<span class="label">Complemento</span>
					<span class="formw"><input type="text" name="dadosPessoais.endereco.complemento" /></span><br />
				</div>
				<div class="row">
					<span class="label">CEP:</span>
					<span class="formw"><input type="text" name="dadosPessoais.cep.regiao" size=5 />
					 <input type="text" name="dadosPessoais.cep.sufixo" size=3 /></span><br />
				</div>
				<div class="row">
					<span class="label">Cidade</span>
					<span class="formw"><input type="text" name="dadosPessoais.endereco.cidade" /></span><br />
				</div>
				<div class="row">
					<span class="label">Estado</span>
					<span class="formw"><input type="text" name="dadosPessoais.endereco.estado" /></span><br />
				</div>
				<div class="row">
					<span class="label">Telefone:</span>
					<span class="formw"><input type="text" name="dadosPessoais.endereco.telefone" /></span><br />
				</div>
				<br>
				<b>Endereço para Correspondência</b>
				<br />
				<div class="row">
					<span class="label">Logradouro</span>
					<span class="formw"><input type="text" name="dadosPessoais.endereco.logradouro" /></span><br />
				</div>
				<div class="row">
					<span class="label">N&uacute;mero</span>
					<span class="formw"><input type="text" name="dadosPessoais.endereco.numero" /></span><br />
				</div>
				<div class="row">
					<span class="label">Complemento</span>
					<span class="formw"><input type="text" name="dadosPessoais.endereco.complemento" /></span><br />
				</div>
				<div class="row">
					<span class="label">CEP:</span>
					<span class="formw"><input type="text" name="dadosPessoais.cep.regiao" size=5 />
					 <input type="text" name="dadosPessoais.cep.sufixo" size=3 /></span><br />
				</div>
				<div class="row">
					<span class="label">Cidade</span>
					<span class="formw"><input type="text" name="dadosPessoais.endereco.cidade" /></span><br />
				</div>
				<div class="row">
					<span class="label">Estado</span>
					<span class="formw"><input type="text" name="dadosPessoais.endereco.estado" /></span><br />
				</div>
				<div class="row">
					<span class="label">Telefone:</span>
					<span class="formw"><input type="text" name="dadosPessoais.endereco.telefone" /></span><br />
				</div>
				
				</fieldset>
				<div>
					<input type="submit" value="Enviar">
				</div>
				
				</form>
				</div>
			</div>
			<div id="menu"><%@ include file="../rodape.jsp"%></div>
		</div>
	</center>
	</body>
</html>