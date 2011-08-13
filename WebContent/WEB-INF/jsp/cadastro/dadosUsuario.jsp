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
				<div id="form" style="width: 445px; margin: 10px auto;">
								
					<form action="<c:url value='/cadastro/dadosUsuario'/>" method="post">
					
						<fieldset>
							<legend><b>Dados Pessoais</b></legend>
							
							<div class="row">
								<span class="label">Nome Completo</span>
								<span class="formw"><input type="text" name="dadosPessoais.nomeCompleto" maxlength=50 /></span><br/>
							</div>
							
							<div class="row">
								<span class="label">Data de Nascimento</span>
								<span class="formw"><input type="text" name="dadosPessoais.dataDeNascimento"/></span><br/>
							</div>
							<div class="row">
								<span class = "label"> Estado Civil</span>
								<span class = "formw">
									<select name="dadosPessoais.estadoCivil" id="selectMultiple">
										<c:forEach var="tipo" items="${tiposEstadoCivil}"  >
											<option value="${tipo}" >  <fmt:message key="${tipo.msgKey}" />  </option>
										</c:forEach>										
									</select>
									<br /> 
								</span>
							</div>
							
							<div class="row">
								<span class = "label"> Documento</span>
								<span class = "formw"> 
									<select name="dadosPessoais.cedulaDeIdentidade.tipo" id="selectMultiple">
										<c:forEach var="tipo" items="${tiposCedulaIdentidade}"  >
											<option value="${tipo}" >  <fmt:message key="${tipo.msgKey}" />  </option>
										</c:forEach>
									</select>
									<br /> 
								</span>
							</div>
							
							<div class="row">
								<span class="label">N&uacute;mero</span>
								<span class="formw">
									<input type="text" name="dadosPessoais.cedulaDeIdentidade.numero" />
									<input type="text" name="dadosPessoais.cedulaDeIdentidade.digito" size=1 maxlength=1/>
								</span>
								<br/>
							</div>
							
							<div class="row">
								<span class="label">CPF</span>
								<span class="formw"><input type="text" name="dadosPessoais.cpf" maxlength=50 /></span><br/>
							</div>
							<div class="row">
								<span class="label">Nacionalidade</span>
								<span class="formw"><input type="text" name="dadosPessoais.nacionalidade" maxlength=100 /></span><br/>
							</div>
								
						</fieldset>
						<br>
	   				
						<fieldset>
							<legend><b>Endereços</b></legend>							
							<h3>Endereço Permanente</h3><br />
							
							<div class="row">
								<span class="label">Logradouro</span>
								<span class="formw"><input type="text" name="dadosPessoais.enderecoPermanente.logradouro" maxlength=50/></span><br />
							</div>
							
							<div class="row">
								<span class="label">N&uacute;mero</span>
								<span class="formw"><input type="text" name="dadosPessoais.enderecoPermanente.numero" maxlength=50/></span><br />
							</div>
							
							<div class="row">
								<span class="label">Complemento</span>
								<span class="formw"><input type="text" name="dadosPessoais.enderecoPermanente.complemento" maxlength=50/></span><br />
							</div>
							
							<div class="row">
								<span class="label">CEP:</span>
								<span class="formw"><input type="text" name="dadosPessoais.enderecoPermanente.cep.regiao" size=5 maxlength=5/>
								 <input type="text" name="dadosPessoais.cep.sufixo" size=3 maxlength=3 /></span><br />
							</div>
							
							<div class="row">
								<span class="label">Cidade</span>
								<span class="formw"><input type="text" name="dadosPessoais.enderecoPermanente.cidade" maxlength=100 /></span><br />
							</div>
							
							<div class="row">
								<span class="label">Estado</span>
								<span class="formw"><input type="text" name="dadosPessoais.enderecoPermanente.estado" maxlength=100/></span><br />
							</div>
							
							<div class="row">
								<span class="label">Telefone Residencial:</span>
								<span class="formw"><input type="text" name="dadosPessoais.enderecoPermanente.telefone.residencial.codTelefone" maxlength=100 /></span><br />
							</div>
							<br />
							
							<h3>Endereço para Correspondência</h3>
							<br />
							<div class="row">
								<span class="label">Logradouro</span>
								<span class="formw"><input type="text" name="dadosPessoais.enderecoCorrespondencia.logradouro" maxlength=100 /></span><br />
							</div>
							
							<div class="row">
								<span class="label">N&uacute;mero</span>
								<span class="formw"><input type="text" name="dadosPessoais.enderecoCorrespondencia.numero" maxlength=50 /></span><br />
							</div>
							
							<div class="row">
								<span class="label">Complemento</span>
								<span class="formw"><input type="text" name="dadosPessoais.enderecoCorrespondencia.complemento" maxlength=50/></span><br />
							</div>
							
							<div class="row">
								<span class="label">CEP:</span>
								<span class="formw"><input type="text" name="dadosPessoais.enderecoCorrespondencia.cep.regiao" size=5 maxlength=5 />
								 <input type="text" name="dadosPessoais.cep.sufixo" size=3 maxlength=3 /></span><br />
							</div>
							
							<div class="row">
								<span class="label">Cidade</span>
								<span class="formw"><input type="text" name="dadosPessoais.enderecoCorrespondencia.cidade"  maxlength=15 /></span><br />
							</div>
							
							<div class="row">
								<span class="label">Estado</span>
								<span class="formw"><input type="text" name="dadosPessoais.enderecoCorrespondencia.estado" size=2 maxlength=2 /></span><br />
							</div>
							
							<div class="row">
								<span class="label">Telefone:</span>
								<span class="formw"><input type="text" name="dadosPessoais.enderecoCorrespondencia.residencial.telefone"  maxlength=20 /></span><br />
							</div>						
													
						</fieldset>
						
						<div>
							<input type="submit" value="Enviar">
							<a href="<c:url value='/'/>"><button><fmt:message key="voltar"/></button></a>
						</div>
					
					</form>
				</div>
			</div>
			<div id="menu"><%@ include file="../rodape.jsp"%></div>
		</div>
	</center>
	</body>
</html>