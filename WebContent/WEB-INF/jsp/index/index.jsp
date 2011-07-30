<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> <fmt:message key="system_title" />  </title>
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
<script type="text/javascript">

$.ajaxSetup ({
    cache: false
});

</script>
</head>
<body>

<center>
<div id="principal">
<div id="menu"><%@ include file="../menu.jsp"%></div>
<div id="corpo" align="left">
<div style="height: 768px; width: 100%">
Index
</div>
</div>

<div><%@ include file="../rodape.jsp"%></div>
</div>



</center>

</body>