
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../cabecalho.jsp"%>

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
<%@ include file="../rodape.jsp"%>
		