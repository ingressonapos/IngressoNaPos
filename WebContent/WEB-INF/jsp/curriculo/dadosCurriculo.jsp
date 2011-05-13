<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fn' uri="http://java.sun.com/jsp/jstl/functions" %>

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
jQuery(function($){
	$("input.data").mask("99/99/9999",{placeholder:""});
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
	<h1>
		<fmt:message key="cadastro_curriculo_titulo_cadastro" />
	</h1>
</center>

<div id="form" class="form_cadastro">

	<form action="<c:url value='/curriculo/adicionaFormacaoAcademica'/>"
		method="post">

		<input type="hidden" name="formacaoAcademica.formacaoAcademicaId"
			value="${formacaoAcademica.formacaoAcademicaId}" maxlength=100 />

		<fieldset>
			<legend>
				<b><fmt:message key="cadastro_curriculo_titulo_formacao" />
				</b>
			</legend>
			<div class="row">
				<div class="label">
					<fmt:message key="cadastro_curriculo_tipo_formacao" />
				</div>

				<select name="formacaoAcademica.tipoDeFormacao" id="selectMultiple">
					<option value="${null}">
						<fmt:message key="selecione" />
					</option>
					<c:forEach var="tipoDeFormacao" items="${tiposDeFormacao}">
						<c:choose>
							<c:when
								test="${tipoDeFormacao == formacaoAcademica.tipoDeFormacao}">
								<option value="${tipoDeFormacao}" selected="${tipoDeFormacao}">
									<fmt:message
										key="cadastro_curriculo_tipo_formacao_${tipoDeFormacao.msgKey}" />
								</option>
							</c:when>
							<c:otherwise>
								<option value="${tipoDeFormacao}">
									<fmt:message
										key="cadastro_curriculo_tipo_formacao_${tipoDeFormacao.msgKey}" />
								</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</div>
			
			<div class="row">
				<div class="label">
					<fmt:message key="cadastro_curriculo_titulo_obtido" />
				</div>
				<span class="formw"><input type="text"
					name="formacaoAcademica.titulo" value="${formacaoAcademica.titulo}" />
				</span>
			</div>
			
			<div class="row">
				<div class="label">
					<fmt:message key="cadastro_curriculo_instituicao" />
				</div>
				<span class="formw"><input type="text"
					name="formacaoAcademica.instituicao"
					value="${formacaoAcademica.instituicao}" maxlength=100 />
				</span>
			</div>

			<div class="row">
				<div class="label">
					<fmt:message key="cadastro_curriculo_data_inicio" />
				</div>
				<span class="formw"><input class=data type="text"
					name="formacaoAcademica.ingressoData"				
					value="<fmt:formatDate value="${formacaoAcademica.ingressoData}" type='date' pattern="dd/MM/yyyy"/>" />
				</span>
			</div>

			<div class="row">
				<div class="label">
					<fmt:message key="cadastro_curriculo_data_termino" />
				</div>
				<span class="formw"> <input class=data type="text"
					name="formacaoAcademica.terminoData"
					value="<fmt:formatDate value="${formacaoAcademica.terminoData}" type='date' pattern="dd/MM/yyyy"/>" />
				</span>
			</div>

			<div class="row">
				<button type="submit" value="<fmt:message key='salvar'/>">
					<fmt:message key='salvar' />
				</button>
			</div>
		</fieldset>
		
		<div class="column" style="width: 100%" >
			<div class="portlet" style="height: 300px;  width: 100%">
				<div class="portlet-header"> 
					<fmt:message key="cadastro_curriculo_titulo_formacoes_cadastradas">
					      <fmt:param value="${fn:length(formacoesAcademicas)}"/>					      
					</fmt:message>					  
				</div>
				
				<div class="tabelaDiv">
					<table class="tabela" cellpadding="5px" cellspacing="0">
						<tr>
							<th> <b><fmt:message key="cadastro_curriculo_tabela_titulo_tipo_de_formacao" /></b> </th> 
							<th> <b><fmt:message key="cadastro_curriculo_tabela_titulo_instituicao" /></b> </th>
							<th> <b><fmt:message key="cadastro_curriculo_tabela_titulo_titulacao" /></b> </th>
							<th> <b><fmt:message key="cadastro_curriculo_tabela_titulo_data_ingresso" /></b> </th>
							<th> <b><fmt:message key="cadastro_curriculo_tabela_titulo_data_termino" /></b> </th>							
						</tr>
						
						<c:forEach  var="formacao" items="${formacoesAcademicas}" varStatus="rowCounter">
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
								<td>
									<fmt:message key="cadastro_curriculo_tipo_formacao_${formacao.tipoDeFormacao.msgKey}" />
								</td>
								<td>${formacao.instituicao}</td>
								<td>${formacao.titulo}</td>
								<td> <fmt:formatDate value="${formacao.ingressoData}" pattern="MM/yyyy"/> </td>
								<td> <fmt:formatDate value="${formacao.terminoData}" pattern="MM/yyyy"/> </td>	
								<td> 
									<p>	
										<a href="<c:url value='/curriculo/editarFormacaoAcademica/${formacao.formacaoAcademicaId}'/>"> 
											<fmt:message key="cadastro_curriculo_lnk_editar_formacao" /> 
										</a>
									</p>
								<td>
								<td> 
									<p>	
										<a href="<c:url value='/curriculo/removerFormacaoAcademica/${formacao.formacaoAcademicaId}'/>"> 
											<fmt:message key="cadastro_curriculo_lnk_remover_formacao" /> 
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


	<fieldset>
		<legend>
			<b><fmt:message
					key="cadastro_curriculo_titulo_iniciacao_cientifica" />
			</b>
		</legend>

		<div class="row">
			<div class="label">
				<fmt:message key="cadastro_curriculo_realizou_iniciacao" />
			</div>
			<span class="formw"><fmt:message key="sim" /><input
				type="radio" name="curriculo.iniciacaoCientifica" />
			</span> <span class="formw"><fmt:message key="nao" /><input
				type="radio" name="curriculo.iniciacaoCientifica" />
			</span>
		</div>

		<div class="row">
			<div class="label">
				<fmt:message key="cadastro_curriculo_instituicao" />
			</div>
			<span class="formw"><input type="text"
				name="curriculo.iniciacaoCientifica.nomeInstituicao" maxlength=100 />
			</span>
		</div>

		<div class="row">
			<div class="label">
				<fmt:message key="cadastro_curriculo_tema_projeto" />
			</div>
			<span class="formw"><input type="text"
				name="curriculo.iniciacaoCientifica.temaProjeto" maxlength=100 />
			</span>
		</div>

		<div class="row">
			<div class="label">
				<fmt:message key="cadastro_curriculo_nome_orientador" />
			</div>
			<span class="formw"><input type="text"
				name="curriculo.iniciacaoCientifica.nomeOrientador" maxlength=50 />
			</span>
		</div>

	</fieldset>

	<fieldset>
		<legend>
			<b><fmt:message key="cadastro_curriculo_titulo_outras_atividades" />
			</b>
		</legend>

		<div class="row">
			<div class="label">
				<fmt:message key="cadastro_curriculo_descricao" />
			</div>
			<span class="formw"><input type="text"
				name="curriculo.formacaoAcademica.tipoBolsa" />
			</span>
		</div>

		<div class="row">
			<div class="label">
				<fmt:message key="cadastro_curriculo_instituicao" />
			</div>
			<span class="formw"><input type="text"
				name="curriculo.formacaoAcademica.nomeInstituicao" maxlength=100 />
			</span>
		</div>

		<div class="row">
			<div class="label">
				<fmt:message key="cadastro_curriculo_data_inicio" />
			</div>
			<span class="formw"><input type="text" class="data"
				name="curriculo.bolsas.ingressoData" maxlength=100 />
			</span>

		</div>

		<div class="row">
			<div class="label">
				<fmt:message key="cadastro_curriculo_data_termino" />
			</div>
			<span class="formw"><input type="text" class=data
				name="curriculo.bolsas.terminoData" maxlength=50 />
			</span>
		</div>

		<div class="row">
			<div class="label">
				<fmt:message key="cadastro_curriculo_titulo_obtido" />
			</div>
			<span class="formw"><input type="text"
				name="curriculo.bolsa.complemento" maxlength=50 />
			</span>
		</div>

	</fieldset>

	<fieldset>
		<legend>
			<b><fmt:message key="cadastro_curriculo_titulo_POSCOMP" />
			</b>
		</legend>

		<div class="row">
			<div class="label">
				<fmt:message key="cadastro_curriculo_realizou_poscomp" />
			</div>
			<fmt:message key="sim" />
			<span class="formw"><input type="radio" name="" />
			</span>
			<fmt:message key="nao" />
			<span class="formw"><input type="radio" name="" />
			</span>
		</div>

		<div class="row">
			<div class="label">
				<fmt:message key="cadastro_curriculo_ano" />
			</div>
			<span class="formw"><input type="text"
				name="curriculo.posComp.ano" maxlength=4 />
			</span>
		</div>

		<div class="row">
			<div class="label">
				<fmt:message key="cadastro_curriculo_acertos_logica" />
			</div>
			<span class="formw"><input type="text"
				name="curriculo.posComp.notaLogica" maxlength=2 />
			</span>
		</div>

		<div class="row">
			<div class="label">
				<fmt:message key="cadastro_curriculo_acertos_matematica" />
			</div>
			<span class="formw"><input type="text"
				name="curriculo.posComp.notaMatematica" maxlength=2 />
			</span>
		</div>

		<div class="row">
			<div class="label">
				<fmt:message key="cadastro_curriculo_acertos_tecnologia" />
			</div>
			<span class="formw"><input type="text"
				name="curriculo.posComp.notaTecnologia" maxlength=2 />
			</span>
		</div>

		<div class="row">
			<div class="label">
				<fmt:message key="cadastro_curriculo_comprovante" />
			</div>
			<span class="formw"><input type="text"
				name="curriculo.posComp.arquivoPosComp" maxlength=2 />
			</span>
		</div>

	</fieldset>

	<fieldset>
		<legend>
			<b><fmt:message
					key="cadastro_curriculo_titulo_cartas_recomendacao" />
			</b>
		</legend>

		<div class="row">
			<div class="label">
				<fmt:message key="cadastro_curriculo_nome_professor" />
			</div>
			<span class="formw"><input type="text" name="" maxlength=50 />
			</span>
		</div>

		<div class="row">
			<div class="label">
				<fmt:message key="cadastro_curriculo_instituicao" />
			</div>
			<span class="formw"><input type="text" name="" maxlength=100 />
			</span>
		</div>

	</fieldset>

	<fieldset>
		<legend>
			<b><fmt:message key="cadastro_curriculo_titulo_aluno_especial" />
			</b>
		</legend>

		<div class="row">
			<div class="label">
				<fmt:message key="cadastro_curriculo_aluno_especial" />
			</div>
			<fmt:message key="sim" />
			<span class="formw"><input type="radio" name="" />
			</span>
			<fmt:message key="nao" />
			<span class="formw"><input type="radio" name="" />
			</span>
		</div>

		<div class="row">
			<div class="label">
				<fmt:message key="cadastro_curriculo_disciplina" />
			</div>
			<span class="formw"><input type="text" name="" maxlength=50 />
			</span>
		</div>

		<div class="row">
			<div class="label">
				<fmt:message key="cadastro_curriculo_ano" />
			</div>
			<span class="formw"><input type="text" name="" maxlength=4 />
			</span>
		</div>

		<div class="row">
			<div class="label">
				<fmt:message key="cadastro_curriculo_conceito_obtido" />
			</div>
			<span class="formw"><input type="text" name="" maxlength=2 />
			</span>
		</div>

	</fieldset>

	<div>
		<input type="submit" value="<fmt:message key='enviar'/>"> <a
			class=button href="<c:url value='/'/>"><button type="button">
				<fmt:message key="voltar" />
			</button> </a>
	</div>

</div>

<%@ include file="../rodape.jsp"%>


