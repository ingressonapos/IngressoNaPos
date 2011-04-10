<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<title>  <fmt:message key="registro_titulo" /> </title>
	<link href="<c:url value='/css/style.css'/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value='/css/layout.css'/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value='/css/menu.css'/>" rel="stylesheet" type="text/css" />
	
</head>

<body>
	
	<center>		
		<div id="principal">
		<div id="menu"><%@ include file="../menu.jsp"%></div>
			<div id="corpo">
				<center><h1> <fmt:message key="registro_solicitacao_inscricao" /> </h1></center>
												
				<div id="form" style="width: 445px; margin: 10px auto;">
					<form action="<c:url value='/registro'/>" method="post">
						
						<fieldset>
							<legend><b> <fmt:message key="registro_nova_inscricao" /> </b></legend>

							<div class="row">
								<span class="label">  <fmt:message key="cadastro_cpf"/>  </span>
								<span class="formw"><input type="text" name="dadosPessoais.cpf" maxlength=50 /></span><br/>
							</div>
							<div class="row">
								<span class="label"> <fmt:message key="login_email"/> </span>
								<span class="formw"><input type="text" name="dadosPessoais.email" maxlength=50 /></span><br/>
							</div>
							<div class="row">
								<span class="label"> <fmt:message key="login_senha"/>  </span>
								<span class="formw"><input type="text" name="dadosPessoais.senha"/></span><br/>
							</div>
							
							<div class="row">
								<span class="label"> <fmt:message key="login_confirmacao_senha"/> </span>
								<span class="formw"> <input type="text" name="confirmacaoSenha"/> </span><br/>
							</div>
							<br/>
							<br/>
							<div class="row">
								<input type="submit" value="<fmt:message key='registro_confirmar'/>" />								 
							</div>
						</fieldset>
						
					</form>
				</div>				
			</div>
		</div>
	
		<div><%@ include file="../rodape.jsp"%></div>
	
	</center>
</body>
</html>

