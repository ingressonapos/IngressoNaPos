<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../cabecalho.jsp"%>

<center>
	<h1> <fmt:message key="registro_solicitacao_inscricao" /> </h1>
</center>

<div id="form" style="width: 445px; margin: 10px auto;">
	<form action="<c:url value='/registro'/>" method="post">
		
		<fieldset>
			<legend><b> <fmt:message key="registro_nova_inscricao" /> </b></legend>

			<table>
				<tr>
				<td><span class="label">  <fmt:message key="cpf"/>  </span></td>
				<td><span class="formw">
					<input type="text" class=reduzido maxlength=50 name="registroNovoUsuario.cpf" value="${registroNovoUsuario.cpf}"  />
				</span>
				</td>
			<tr>
				<td><span class="label"> <fmt:message key="login_email"/> </span></td>
				<td><span class="formw">
					<input type="text" class=reduzido maxlength=50 name="registroNovoUsuario.email" value="${registroNovoUsuario.email}"/>
				</span>
				</td>
			<tr>
				<td><span class="label"> <fmt:message key="login_senha"/>  </span></td>
				<td><span class="formw"><input id="senha" type="password" name="registroNovoUsuario.senha"/> </span></td>
			</tr>
			
			<tr>
				<td><span class="label"> <fmt:message key="login_confirmacao_senha"/> </span></td>
				<td><span class="formw"> <input id="senha" type="password" name="registroNovoUsuario.confirmacaoSenha"/> </span></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="<fmt:message key='registro_confirmar'/>" />
					<a class=button href="<c:url value='/login'/>"><button type="button"><fmt:message key="voltar"/></button> </a>
				</td>						 
			</tr>
			</table>
		</fieldset>
	</form>
</div>
		
<%@ include file="../rodape.jsp"%>
