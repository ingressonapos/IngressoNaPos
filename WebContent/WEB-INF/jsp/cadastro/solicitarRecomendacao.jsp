
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../cabecalho.jsp"%>

<center>
	<h1> <fmt:message key="cadastro_recomendacao_titulo" /> </h1>
</center>

<div id="form" style="width: 445px; margin: 10px auto;">

	<form action="<c:url value='/cadastro/solicitarRecomendacao'/>" method="post">
		<fieldset>
			<legend><b><fmt:message key="cadastro_recomendacao_professor" /></b></legend>

			<div class="row">
				<span class="label"><fmt:message key="cadastro_recomendacao_nome" /></span>
				<span class="formw"><input type="text" name="cartaDeRecomendacao.nome" maxlength=100 /></span><br/>
			</div>
			
			<div class="row">
				<span class="label"><fmt:message key="cadastro_recomendacao_email" /></span>
				<span class="formw"><input type="text" name="cartaDeRecomendacao.email"/></span><br/>
			</div>
			
			<input type="submit" value="<fmt:message key="cadastro_recomendacao_lnk_solicitar" />">
		</fieldset>
	</form>
	
	<div id="tabelaCartasRecomendacao">
		<table>
			<c:forEach var="carta" items="${cartasDeRecomendacao}" >
			 	<tr> 
					<td>${carta.email}
					</td>
					<td>
					</td>
					<td>
					</td>
				</tr>
						
			</c:forEach>
		
					
		</table>
	</div>	
</div>
<%@ include file="../rodape.jsp"%>
		