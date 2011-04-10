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
			<div id="menu">
				<%@ include file="../menu.jsp"%>
			</div>
			
			<div id="corpo">	
				
				<div id="login" style="width: 800px; margin: 0 auto; text-align: center;">
					<h1><fmt:message key="login_mensagem_bem_vindo" />  </h1>
					
					<c:if test="${not empty messages}">
						<div id="messages">
							<ul>
								<c:forEach items="${messages}" var="message">
									<li> 
										<fmt:message key="${message}" />		
									</li>
								</c:forEach>
							</ul>
						</div>
					</c:if>
				</div>
				
				<div id="login" style="width: 250px; margin: 0 auto;">
					<form action="<c:url value='/login'/>" method="post">
						<fieldset>
							<legend><b> <fmt:message key="login_autenticacao" /> </b></legend>							
							<table>
								<tr>
									<td><fmt:message key="login_email" /></td>
									<td><input id="login" name="usuario.email" type="text"
										style="width: 150px" /></td>
								</tr>
								<tr>
									<td><fmt:message key="login_senha" /></td>
									<td><input id="senha" name="usuario.senha" type="password"
										maxlength="10" style="width: 150px" /></td>
								</tr>
								<tr>
									<td></td>
									<td><input id="submit" name="submit" type="submit" value="<fmt:message key='login_acessar' />" /></td>
								</tr>
								<tr>
									<td></td>
									<td><fmt:message key="login_esqueci_minha_senha" /></td>
								</tr>
							</table>
						</fieldset>
					</form>
					<br />
					<p><b><fmt:message key="login_novo_usuario" /></b> <a href="<c:url value='/registro'/>"><fmt:message key="login_registro" /></a></p>					
				</div>
			</div>
			
			<div id="rodape">
				<%@ include file="../rodape.jsp"%>
			</div>
		</div>	
	</center>
</body>
