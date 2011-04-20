<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Cadastro de Curr&iacute;culo</title>
		<link href="<c:url value='/css/style.css'/>" rel="stylesheet" type="text/css" />
		<link href="<c:url value='/css/layout.css'/>" rel="stylesheet" type="text/css" />
		<link href="<c:url value='/css/menu.css'/>" rel="stylesheet" type="text/css" />
	</head>

	<body>
					
	<center>		
		<div id="principal">
		<div id="menu"><%@ include file="../menu.jsp"%></div>
			<div id="corpo">
				<div id="form" style="width: 445px; margin: 10px auto;">
								
					<form action="<c:url value='/cadastro/solicitarRecomendacao'/>" method="post">
					
						<fieldset>
							<legend><b>Formação Acadêmica</b></legend>
							<h3>Graduação</h3><br />
							
							<div class="row">
								<span class="label">Nome</span>
								<span class="formw"><input type="text" name="cartaDeRecomendacao.nome" maxlength=100 /></span><br/>
							</div>
							
							<div class="row">
								<span class="label">Email</span>
								<span class="formw"><input type="text" name="cartaDeRecomendacao.email"/></span><br/>
							</div>
							
							<input type="submit" value="Adicionar">
						</fieldset>
						
					</form>
				</div>
			</div>
			<div id="menu"><%@ include file="../rodape.jsp"%></div>
		</div>
	</center>
	</body>
</html>