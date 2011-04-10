<%@ include file="cabecalho.jsp"%>
<c:if test="${usuarioSessao.usuarioAutenticado}">
	<fmt:message key="menu_msg_bem_vindo" />
	<b>${usuarioSessao.nome}</b>
</c:if>

<c:if test="${not empty errors}">
	<div id="errors">
	<ul>
		<c:forEach items="${errors}" var="error">
			<li> 
				<fmt:message key="${error.category}" /> - ${error.message}				
			</li>
		</c:forEach>
	</ul>
	</div>
</c:if>