
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../cabecalho.jsp"%>

<link href="<c:url value='/'/>/css/jquery-ui.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="<c:url value='/'/>/js/gdl.js"></script>
<script language="javascript" type="text/javascript"
	src="<c:url value='/'/>/js/interface.js"></script>
<script language="javascript" type="text/javascript"
	src="<c:url value='/'/>/js/jquery-ui.js"></script>
<script language="javascript" type="text/javascript"
	src="<c:url value='/'/>/js/dateFormat.js"></script>
<script type="text/javascript">

$(function() {
	$(".column").sortable({
		connectWith: '.column',
		handle: $(".portlet-header")
	});

	$(".portlet").addClass("ui-widget ui-widget-content ui-helper-clearfix ui-corner-all")
		.find(".portlet-header")
			.addClass("ui-widget-header ui-corner-all")
			.prepend('<span class="ui-icon ui-icon-minusthick"></span>')
			.end()
		.find(".portlet-content");

	$(".portlet-header .ui-icon").click(function() {
		$(this).toggleClass("ui-icon-minusthick").toggleClass("ui-icon-plusthick");
		$(this).parents(".portlet:first").find(".portlet-content").toggle();
	});

	/*$(".column").disableSelection();*/
	$.datepicker.setDefaults($.datepicker.regional['pt-BR']);
	$("#calendario").datepicker({ maxDate: '+1m', onSelect: exibeAtividades });
});

function exibeAtividades(data){
	
}

$.ajaxSetup ({
    cache: false
});
</script>


<div style="height: 500px; width: 100%">
	<div class="column" style="width: 620px">
		<div class="portlet">
			<div class="portlet-header"> <fmt:message key="index_titulo_tarefas" />  
			</div>
			<div class="portlet-content">
				<div id="tarefasPendentes" style="overflow:auto; height: 150px">
					<p><a href="<c:url value='/cadastro/dadosPessoais'/>"> <fmt:message key="index_lnk_cadastro_dados_pessoais" /> </a></p>
					<p><a href="<c:url value='/cadastro/dadosCurriculo'/>"> <fmt:message key="index_lnk_cadastro_curriculo" /> </a></p>
					<p><a href="<c:url value='/cadastro/solicitarRecomendacao'/>"> <fmt:message key="index_lnk_cadastro_recomendacao" /> </a></p>
				</div>
			</div>
		</div>
	</div>
	<div class="column" style="width: 260px; float: left;">
		<div class="portlet">
			<div class="portlet-header"> <fmt:message key="index_titulo_usuario"/> </div>
			<div class="portlet-content">
				<center>
					<p> ${usuarioSessao.nome} - 
						<a href="<c:url value='/logout'/>"> <fmt:message key="login_logout" /> </a>
					</p>
				</center>
			</div>		
		</div>
		<div class="portlet">
			<div class="portlet-header"> <fmt:message key="index_titulo_calendario"/></div>
			<div class="portlet-content"><div id="calendario"></div></div>
		</div>
	</div>
</div>

<%@ include file="../rodape.jsp"%>

