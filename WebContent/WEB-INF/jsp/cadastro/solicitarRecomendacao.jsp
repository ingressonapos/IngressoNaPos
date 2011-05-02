
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fn' uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ include file="../cabecalho.jsp"%>

<script type="text/javascript" src="<c:url value='/'/>/js/jquery.js"> </script>
<script type="text/javascript" src="<c:url value='/'/>/js/jquery.maskedinput.js"> </script>
<script type="text/javascript">
jQuery(function($){
	$("td.data").mask("99/99/9999",{placeholder:""});  	
});
</script>


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
jQuery(function($){
	$("input.data").mask("99/99/9999",{placeholder:""});
  	$("input[name$='cpf']").mask("999.999.999-99",{placeholder:""});
  	$("input[name$='codTelefone']").mask("+99 (99) 9999-9999",{placeholder:""});
  	$("input[name$='telefone']").mask("+99 (99) 9999-9999",{placeholder:""});
  	$("input[name$='cep']").mask("99999-999",{placeholder:""});
});

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


<center>
	<h1> <fmt:message key="cadastro_recomendacao_titulo" /> </h1>
</center>

<div id="form_recomendacao">

	<form action="<c:url value='/cadastro/solicitarRecomendacao'/>" method="post">
	
		<fieldset>
			<legend><b><fmt:message key="cadastro_recomendacao_professor" /></b></legend>

			<div class="row">
				<div class="label"> <fmt:message key="cadastro_recomendacao_nome" />
					<font color = "red">*</font> </div>
				<span class="formw">
					<input type="text" style="width: 250px" name="cartaDeRecomendacao.nome" 
						maxlength=100 />
				</span>
			</div>			
			
			<div class="row">
				<div class="label"> <fmt:message key="cadastro_recomendacao_email" />
					<font color = "red">*</font> </div>
				<span class="formw">
					<input type="text" style="width: 250px" name="cartaDeRecomendacao.email" 
						maxlength=100 />
				</span>
			</div>
			
			<br/>
			<div>
				<input type="submit" value="<fmt:message key="cadastro_recomendacao_lnk_solicitar" />">
				<a class=button href="<c:url value='/'/>"><button type="button"><fmt:message key="voltar"/></button> </a>
			</div>		
		</fieldset>
				
		<div class="column" style="height: 300px;  width: 100%" >
			<div class="portlet">
				<div class="portlet-header"> 
					<fmt:message key="cadastro_recomendacao_titulo_cartas_enviadas">
					      <fmt:param value="${fn:length(cartasDeRecomendacao)}"/>					      
					</fmt:message>					  
				</div>
				
				<div class="tabelaDiv">
					<table class="tabela" cellpadding="5px" cellspacing="0">
						<tr> 
							<th> <b><fmt:message key="cadastro_recomendacao_tabela_titulo_nome" /></b> </th>
							<th> <b><fmt:message key="cadastro_recomendacao_tabela_titulo_email" /></b>  </th>
							<th> <b><fmt:message key="cadastro_recomendacao_tabela_titulo_data_envio" /></b> </th>
						</tr>
						
						<c:forEach  var="carta" items="${cartasDeRecomendacao}" varStatus="rowCounter">
							<!-- Uma linha de cada cor -->
							<c:choose>
								<c:when test="${rowCounter.count % 2 == 0}">
									<c:set var="rowStyle" scope="page" value="odd"/>
								</c:when>
								<c:otherwise>
									<c:set var="rowStyle" scope="page" value="even"/>
								</c:otherwise>
					        </c:choose>
						 	<tr class="${rowStyle}"> 
								<td>${carta.nome}</td>
								<td>${carta.email}</td>
								<td> <fmt:formatDate value="${carta.dataDeEnvio}" pattern="dd/MM/yyyy - HH:mm"/> </td>
								<td> 
									<p>	
										<a href="<c:url value='/cadastro/reenviarRecomendacao/${carta.cartaDeRecomendacaoID}'/>"> 
											<fmt:message key="cadastro_recomendacao_lnk_reenviar" /> 
										</a>
									</p>
								<td>
							</tr>			
						</c:forEach>					
					</table>
				</div>
			</div>
		</div>	
		
		
	</form>
	
</div>

<%@ include file="../rodape.jsp"%>
		