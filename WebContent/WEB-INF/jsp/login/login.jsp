
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../cabecalho.jsp"%>

	<div> 
		<h1 align="center"> <fmt:message key="login_mensagem_bem_vindo" />  </h1>
	</div>
	
	<div id="login">
		<form action="<c:url value='/login'/>" method="post">
			<fieldset>
				<legend><b> <fmt:message key="login_autenticacao" /> </b></legend>							
				<table>
					<tr>
						<td><fmt:message key="login_email" /></td>
						<td>
							<input id="loginUsuario"  name="usuario.email" value="${usuario.email}" type="text"/>							
						</td>
					</tr>
					<tr>
						<td><fmt:message key="login_senha" /></td>
						<td>
							<input id="loginSenha" name="usuario.senha" type="password"  maxlength="10"/>
						</td>							  
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

<%@ include file="../rodape.jsp"%>	
	
