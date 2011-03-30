<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<link href="<c:url value='/'/>/css/layout.css" rel="stylesheet"
	type="text/css" />
<link href="<c:url value='/'/>/css/jquery-ui.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="<c:url value='/'/>/js/jquery.js"></script>
<script type="text/javascript" src="<c:url value='/'/>/js/gdl.js"></script>
<script language="javascript" type="text/javascript"
	src="<c:url value='/'/>/js/interface.js"></script>
<script language="javascript" type="text/javascript"
	src="<c:url value='/'/>/js/jquery-ui.js"></script>
<script language="javascript" type="text/javascript"
	src="<c:url value='/'/>/js/dateFormat.js"></script>

</head>
<body>

<center>
<div id="principal">
<div id="menu"><%@ include file="../menu.jsp"%></div>
<div id="corpo" align="left">
<ul>
	<li><a href="<c:url value='/'/>arquivos/Formulario_ADA_LIGHT.doc">Formulário - ADA LIGHT</a></li>
	<li><a href="<c:url value='/'/>arquivos/Formulario_REDEIP_FRAMERELAY_VPNIP.doc">Formulário - REDE IP / FRAME RELAY / VPN IP</a></li>
	<li><a href="<c:url value='/'/>arquivos/Formulario_SPEEDY_E_TERMINAL.xls">Formulário - SPEEDY E TERMINAL</a></li>
	<li><a href="<c:url value='/'/>arquivos/Formulario_x25.doc">Formulário - x25</a></li>
	<li><a href="<c:url value='/'/>arquivos/Formulario_DDR -.xls">Formulário - DDR</a></li>
	<li><a href="<c:url value='/'/>arquivos/Formulario_PDTI.doc">Formulário - PDTI</a></li>
	<li><a href="<c:url value='/'/>arquivos/MODELOS_DE_PROPOSTAS.zip">Modelos de Propostas (diversos)</a></li>
</ul>
</div>

<div><%@ include file="../rodape.jsp"%></div>
</div>

</center>

</body>