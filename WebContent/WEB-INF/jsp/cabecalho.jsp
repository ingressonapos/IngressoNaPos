<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="system_title" />
</title>
<link href="<c:url value='/css/style.css'/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value='/css/layout.css'/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value='/css/menu.css'/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value='/css/erros.css'/>" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="<c:url value='/'/>/js/jquery.js"></script>
<!-- <script type="text/javascript" src="<c:url value='/'/>/js/erros.js"></script>  -->
</head>

<%
	response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0
	response.setDateHeader("Expires", -1); //evita o caching no servidor proxy
%>

<body>
	<center>
		<!-- Este div sera fechado em rodape.jsp -->
		
		<div id="principal">
			<!-- Este div sera fechado em rodape.jsp -->

			<c:if test="${not empty errors}">
			<div id=mascara></div>
				<div id="errors">
					<c:forEach items="${errors}" var="error">
						<div><fmt:message key="${error.category}" /> - ${error.message}</div>
			</c:forEach>
					<div class=ok><button>OK</button></div>
				</div>
			</c:if>

			<c:if test="${not empty messages}">
				<div id="messages">
					<c:forEach items="${messages}" var="message">
						<div><fmt:message key="${message}" /></div>
					</c:forEach>
					<div class=ok><button>OK</button></div>
				</div>
			</c:if>

			<div class="fundo_topo"></div>
			<div align="center">
				<a href="http://www.ime.usp.br/pos"> <img
					src="<c:url value='/images/pos_topo.gif'/>" width="700" border="0"
					height="80"> </a>
			</div>
			<table width="100%" align="center" border="0" cellspacing="0">
				<tbody>
					<tr>
						<td bgcolor="#b31b1b" height="1px"></td>
					</tr>
					<tr>
						<td bgcolor="#ebebeb" height="1px"></td>
					</tr>
				</tbody>
			</table>
			<c:if test="${usuarioSessao.usuarioAutenticado}">
				<fmt:message key="menu_msg_bem_vindo" />
				<b>${usuarioSessao.nome}</b>
			</c:if>


			<div id="corpo">
				<!-- Este div sera fechado em rodape.jsp -->

				<div id="menu">
					<%@ include file="menu.jsp"%>
				</div>
				<!-- Corpo para qualquer pagina -->