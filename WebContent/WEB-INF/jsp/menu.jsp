<%@ include file="cabecalho.jsp"%>
<c:if test="${usuarioSessao.usuario != null}">
					Olá <b>${usuarioSessao.usuario.nome}</b>
</c:if>