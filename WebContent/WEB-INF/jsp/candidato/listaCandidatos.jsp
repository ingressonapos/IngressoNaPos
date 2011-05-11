
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../cabecalho.jsp"%>
<div class="tabelaDiv">
	<table>
		<tr>
			<th><b><fmt:message key="cadastro_recomendacao_tabela_titulo_nome" /></b></th>
			<th><b><fmt:message key="cadastro_recomendacao_tabela_titulo_email" /></b></th>
		</tr>
		<c:forEach items="${listaDeCandidatos}" var="usuario">
			<c:choose>
				<c:when test="${rowCounter.count % 2 == 0}">
					<c:set var="rowStyle" scope="page" value="odd" />
				</c:when>
				<c:otherwise>
					<c:set var="rowStyle" scope="page" value="even" />
				</c:otherwise>
			</c:choose>
			<tr class="${rowStyle}">
				<td>${usuario.dadosPessoais.nomeCompleto}</td>
				<td>${usuario.email}</td>
			</tr>
		</c:forEach>
	</table>
</div>
<%@ include file="../rodape.jsp"%>