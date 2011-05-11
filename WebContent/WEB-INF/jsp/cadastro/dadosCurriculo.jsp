<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../cabecalho.jsp"%>
<script type="text/javascript">
jQuery(function($){
	$("input.data").mask("99/99/9999",{placeholder:""});
});
</script>



<center><h1><fmt:message key="cadastro_curriculo_titulo_cadastro"/></h1></center>

<div id="form" class="form_cadastro">
				
	<form action="<c:url value='/cadastro/adicionaFormacaoAcademica'/>" method="post">
		
		<input type="hidden" name="formacaoAcademica.formacaoAcademicaId" 
			value="${formacaoAcademica.formacaoAcademicaId}" maxlength=100 />
		
		<fieldset>
			<legend><b><fmt:message key="cadastro_curriculo_titulo_formacao"/></b></legend>
			<div class="row">
				<div class="label"><fmt:message key="cadastro_curriculo_tipo_formacao"/></div>
				
				<select name="formacaoAcademica.tipoDeFormacao" id="selectMultiple">
					<option  value="${null}"> 
						<fmt:message key="selecione"/> 
					</option>
					<c:forEach var="tipoDeFormacao" items="${tiposDeFormacao}">
						<c:choose> 
							<c:when test="${tipoDeFormacao == formacaoAcademica.tipoDeFormacao}" > 
								<option value="${tipoDeFormacao}" selected="${tipoDeFormacao}" > 
									<fmt:message key="cadastro_curriculo_tipo_formacao_${tipoDeFormacao.msgKey}" /> 
								</option>
							</c:when>
							<c:otherwise>  
								<option value="${tipoDeFormacao}">
									<fmt:message key="cadastro_curriculo_tipo_formacao_${tipoDeFormacao.msgKey}"/>
								</option>
							</c:otherwise>
						</c:choose>  
					</c:forEach>
				</select>
			</div>
			<div class="row">
				<div class="label"><fmt:message key="cadastro_curriculo_instituicao"/></div>
				<span class="formw"><input type="text" name="formacaoAcademica.instituicao" value="${formacaoAcademica.instituicao}" maxlength=100 /></span>
			</div>
			
			<div class="row">
				<div class="label"><fmt:message key="cadastro_curriculo_data_inicio"/></div>
				<span class="formw"><input class=data type="text" name="formacaoAcademica.ingressoData"
					value="<fmt:formatDate value="${formacaoAcademica.ingressoData}" type='date' pattern="dd/MM/yyyy"/>"/></span>
			</div>
			
			<div class="row">
				<div class="label"><fmt:message key="cadastro_curriculo_data_termino"/></div>
				<span class="formw">
					<input class=data type="text" name="formacaoAcademica.terminoData"
						value="<fmt:formatDate value="${formacaoAcademica.terminoData}" type='date' pattern="dd/MM/yyyy"/>"/></span>			
			</div>
			
			<div class="row">
				<div class="label"><fmt:message key="cadastro_curriculo_titulo_obtido"/></div>
				<span class="formw"><input type="text" name="formacaoAcademica.titulo" value="${formacaoAcademica.titulo}"/></span>
			</div>
			<div class="row">
				<button type="submit" value="<fmt:message key='enviar'/>"> <fmt:message key='cadastro_curriculo_adicionar_formacao_academica'/> </button>
			</div>		
		</fieldset>
	</form>	

				
		<fieldset>
			<legend><b><fmt:message key="cadastro_curriculo_titulo_iniciacao_cientifica"/></b></legend>							
			
			<div class="row">
				<div class="label"><fmt:message key="cadastro_curriculo_realizou_iniciacao"/></div>
				<span class="formw"><fmt:message key="sim"/><input type="radio" name="curriculo.iniciacaoCientifica"/></span>
				<span class="formw"><fmt:message key="nao"/><input type="radio" name="curriculo.iniciacaoCientifica"/></span>
			</div>
			
			<div class="row">
				<div class="label"><fmt:message key="cadastro_curriculo_instituicao"/></div>
				<span class="formw"><input type="text" name="curriculo.iniciacaoCientifica.nomeInstituicao" maxlength=100/></span>
			</div>
			
			<div class="row">
				<div class="label"><fmt:message key="cadastro_curriculo_tema_projeto"/></div>
				<span class="formw"><input type="text" name="curriculo.iniciacaoCientifica.temaProjeto" maxlength=100/></span>
			</div>
			
			<div class="row">
				<div class="label"><fmt:message key="cadastro_curriculo_nome_orientador"/></div>
				<span class="formw"><input type="text" name="curriculo.iniciacaoCientifica.nomeOrientador" maxlength=50/></span>
			</div>
									
		</fieldset>
		
		<fieldset>
			<legend><b><fmt:message key="cadastro_curriculo_titulo_outras_atividades"/></b></legend>
			
			<div class="row">
				<div class="label"><fmt:message key="cadastro_curriculo_descricao"/></div>
				<span class="formw"><input type="text" name="curriculo.formacaoAcademica.tipoBolsa"/></span>
			</div>
			
			<div class="row">
				<div class="label"><fmt:message key="cadastro_curriculo_instituicao"/></div>
				<span class="formw"><input type="text" name="curriculo.formacaoAcademica.nomeInstituicao" maxlength=100/></span>
			</div>
			
			<div class="row">
				<div class="label"><fmt:message key="cadastro_curriculo_data_inicio"/></div>
				<span class="formw"><input type="text" class="data" name="curriculo.bolsas.ingressoData" maxlength=100/></span>
				
			</div>
			
			<div class="row">
				<div class="label"><fmt:message key="cadastro_curriculo_data_termino"/></div>
				<span class="formw"><input type="text" class=data name="curriculo.bolsas.terminoData" maxlength=50/></span>
			</div>
			
			<div class="row">
				<div class="label"><fmt:message key="cadastro_curriculo_titulo_obtido"/></div>
				<span class="formw"><input type="text" name="curriculo.bolsa.complemento" maxlength=50/></span>
			</div>
			
		</fieldset>
		
		<fieldset>
			<legend><b><fmt:message key="cadastro_curriculo_titulo_POSCOMP"/></b></legend>							
			
			<div class="row">
				<div class="label"><fmt:message key="cadastro_curriculo_realizou_poscomp"/></div>
				<fmt:message key="sim"/><span class="formw"><input type="radio" name=""/></span>
				<fmt:message key="nao"/><span class="formw"><input type="radio" name=""/></span>
			</div>
			
			<div class="row">
				<div class="label"><fmt:message key="cadastro_curriculo_ano"/></div>
				<span class="formw"><input type="text" name="curriculo.posComp.ano" maxlength=4/></span>
			</div>
			
			<div class="row">
				<div class="label"><fmt:message key="cadastro_curriculo_acertos_logica"/></div>
				<span class="formw"><input type="text" name="curriculo.posComp.notaLogica" maxlength=2/></span>
			</div>
			
			<div class="row">
				<div class="label"><fmt:message key="cadastro_curriculo_acertos_matematica"/></div>
				<span class="formw"><input type="text" name="curriculo.posComp.notaMatematica" maxlength=2/></span>
			</div>
			
			<div class="row">
				<div class="label"><fmt:message key="cadastro_curriculo_acertos_tecnologia"/></div>
				<span class="formw"><input type="text" name="curriculo.posComp.notaTecnologia" maxlength=2/></span>
			</div>
			
			<div class="row">
				<div class="label"><fmt:message key="cadastro_curriculo_comprovante"/></div>
				<span class="formw"><input type="text" name="curriculo.posComp.arquivoPosComp" maxlength=2/></span>
			</div>
									
		</fieldset>
		
		<fieldset>
			<legend><b><fmt:message key="cadastro_curriculo_titulo_cartas_recomendacao"/></b></legend>							
			
			<div class="row">
				<div class="label"><fmt:message key="cadastro_curriculo_nome_professor"/></div>
				<span class="formw"><input type="text" name="" maxlength=50/></span>
			</div>
			
			<div class="row">
				<div class="label"><fmt:message key="cadastro_curriculo_instituicao"/></div>
				<span class="formw"><input type="text" name="" maxlength=100/></span>
			</div>
									
		</fieldset>
		
		<fieldset>
			<legend><b><fmt:message key="cadastro_curriculo_titulo_aluno_especial"/></b></legend>							
			
			<div class="row">
				<div class="label"><fmt:message key="cadastro_curriculo_aluno_especial"/></div>
				<fmt:message key="sim"/><span class="formw"><input type="radio" name=""/></span>
				<fmt:message key="nao"/><span class="formw"><input type="radio" name=""/></span>
			</div>
			
			<div class="row">
				<div class="label"><fmt:message key="cadastro_curriculo_disciplina"/></div>
				<span class="formw"><input type="text" name="" maxlength=50/></span>
			</div>
			
			<div class="row">
				<div class="label"><fmt:message key="cadastro_curriculo_ano"/></div>
				<span class="formw"><input type="text" name="" maxlength=4/></span>
			</div>
			
			<div class="row">
				<div class="label"><fmt:message key="cadastro_curriculo_conceito_obtido"/></div>
				<span class="formw"><input type="text" name="" maxlength=2/></span>
			</div>
									
		</fieldset>
		
		<div>
			<input type="submit" value="<fmt:message key='enviar'/>">
			<a class=button href="<c:url value='/'/>"><button type="button"><fmt:message key="voltar"/></button> </a>			
		</div>	
	
</div>

<%@ include file="../rodape.jsp"%>



