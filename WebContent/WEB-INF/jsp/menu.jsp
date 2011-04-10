<%@ include file="cabecalho.jsp"%>
<c:if test="${usuarioSessao.usuarioAutenticado}">
	<fmt:message key="menu_msg_bem_vindo" />
	<b>${usuarioSessao.nome}</b>
</c:if>