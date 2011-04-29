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

			<div class="row">
				<span class="label">  <fmt:message key="cpf"/>  </span>
				<span class="formw">
					<input type="text" class=reduzido maxlength=50 name="registroNovoUsuario.cpf" value="${registroNovoUsuario.cpf}"  />
				</span><br/>
			</div>
			<div class="row">
				<span class="label"> <fmt:message key="login_email"/> </span>
				<span class="formw">
					<input type="text" class=reduzido maxlength=50 name="registroNovoUsuario.email" value="${registroNovoUsuario.email}"/>
				</span><br/>
			</div>
			<div class="row">
				<span class="label"> <fmt:message key="login_senha"/>  </span>
				<span class="formw"><input id="senha" type="password" name="registroNovoUsuario.senha"/> </span><br/>
			</div>
			
			<div class="row">
				<span class="label"> <fmt:message key="login_confirmacao_senha"/> </span>
				<span class="formw"> <input id="senha" type="password" name="registroNovoUsuario.confirmacaoSenha"/> </span><br/>
			</div>
			<br/>
			<br/>
			<div class="row">
				<input type="submit" value="<fmt:message key='registro_confirmar'/>" />
				<a href="<c:url value='/login'/>"><button><fmt:message key="voltar"/></button></a>						 
			</div>
		</fieldset>
	</form>
</div>
		
<%@ include file="../rodape.jsp"%>
