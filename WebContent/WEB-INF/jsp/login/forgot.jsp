
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../cabecalho.jsp"%>

<div id="forgot">
	<table>
		<tr>
			<td><fmt:message key="login_esqueci_minha_senha_instrucao" />
			</td>
		</tr>
	</table>

	<form action="<c:url value='/login/forgot'/>" method="post">
		<fieldset>
			<table>
				<tr>
					<td><fmt:message key="login_email" /></td>
					<td><input id="forgotEmail" name="email" value="${email}"
						type="text"/>
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input id="submit" name="submit" type="submit"
						value="<fmt:message key='enviar' />" /></td>
				</tr>
			</table>
		</fieldset>
	</form>
	<p>
		<b><a href="<c:url value='/login'/>"><fmt:message
			key="senha_voltar_tela_inicial" /> </a></b>
	</p>
</div>

<%@ include file="../rodape.jsp"%>

