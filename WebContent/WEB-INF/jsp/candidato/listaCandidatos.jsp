
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../cabecalho.jsp"%>
<table>
	<tr>
		<td>Nome</td>
		<td>E-mail</td>
	</tr>
	<c:forEach items="${listaDeCandidatos}" var="usuario">
	<tr>
		<td>${usuario.dadosPessoais.nomeCompleto}</td>
		<td>${usuario.email}</td>
	</tr>
	</c:forEach>
</table>
<%@ include file="../rodape.jsp"%>