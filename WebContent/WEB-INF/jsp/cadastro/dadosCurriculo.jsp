<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript" src="<c:url value='/'/>/js/jquery.js"></script>
<script type="text/javascript" src="<c:url value='/'/>/js/jquery.maskedinput.js"></script>
<script type="text/javascript">
jQuery(function($){
	$("input.data").mask("99/9999",{placeholder:""});
});
</script>


<%@ include file="../cabecalho.jsp"%>


<center><h1><fmt:message key="cadastro_curriculo_titulo_cadastro"/></h1></center>

<div id="form" style="width: 445px; margin: 10px auto;">
				
	<form action="<c:url value='/cadastro/dadosCurriculo'/>" method="post">
	
		<fieldset>
			<legend><b><fmt:message key="cadastro_curriculo_titulo_formacao"/></b></legend>
			<h3><fmt:message key="cadastro_curriculo_graduacao"/></h3>
	
			<div class="row">
				<div class="label"><fmt:message key="cadastro_curriculo_instituicao"/></div>
				<span class="formw"><input type="text" name="curriculo.formacaoAcademica.Instituicao" maxlength=100 /></span>
			</div>
			
			<div class="row">
				<div class="label"><fmt:message key="cadastro_curriculo_data_inicio"/></div>
				<span class="formw"><input class=data type="text" name="curriculo.formacaoAcademica.ingressoData"/></span>
			</div>
			
			<div class="row">
				<div class="label"><fmt:message key="cadastro_curriculo_data_termino"/></div>
				<span class="formw"><input class=data type="text" name="curriculo.formacaoAcademica.terminoData"/></span>
			</div>
			
			<div class="row">
				<div class="label"><fmt:message key="cadastro_curriculo_titulo_obtido"/></div>
				<span class="formw"><input type="text" name="curriculo.formacaoAcademica.Titulo"/></span>
			</div>
			
		<h3><fmt:message key="cadastro_curriculo_titulo_posgraduacao"/></h3>
		<div class="row">
				<div class="label"><fmt:message key="cadastro_curriculo_instituicao"/></div>
				<span class="formw"><input type="text" name="curriculo.formacaoAcademica.Instituicao" maxlength=100 /></span>
			</div>
			
			<div class="row">
				<div class="label"><fmt:message key="cadastro_curriculo_data_inicio"/></div>
				<span class="formw"><input type="text" class=data name="curriculo.formacaoAcademica.ingressoData"/></span>
			</div>
			
			<div class="row">
				<div class="label"><fmt:message key="cadastro_curriculo_data_termino"/></div>
				<span class="formw"><input type="text" class=data name="curriculo.formacaoAcademica.terminoData"/></span>
			</div>
			
			<div class="row">
				<div class="label"><fmt:message key="cadastro_curriculo_titulo_obtido"/></div>
				<span class="formw"><input type="text" name="curriculo.formacaoAcademica.Titulo"/></span>
			</div>
			
			<div class="row">
				<div class="label"><fmt:message key="cadastro_curriculo_titulo_dissertacao"/></div>
				<span class="formw"><input type="text" name="curriculo.formacaoAcademica.tituloDissert"/></span>
			</div>
			
			<div class="row">
				<div class="label"><fmt:message key="cadastro_curriculo_nome_orientador"/></div>
				<span class="formw"><input type="text" name="curriculo.formacaoAcademica.nomeOrientador"/></span>
			</div>
				
		</fieldset>
		

				
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
				<span class="formw"><input type="text" name=""/></span>
			</div>
			
			<div class="row">
				<div class="label"><fmt:message key="cadastro_curriculo_instituicao"/></div>
				<span class="formw"><input type="text" name="" maxlength=100/></span>
			</div>
			
			<div class="row">
				<div class="label"><fmt:message key="cadastro_curriculo_data_inicio"/></div>
				<span class="formw"><input type="text" class="data" name="curriculo.enderecoPermanente.numero" maxlength=100/></span>
				
			</div>
			
			<div class="row">
				<div class="label"><fmt:message key="cadastro_curriculo_data_termino"/></div>
				<span class="formw"><input type="text" class=data name="curriculo.enderecoPermanente.complemento" maxlength=50/></span>
			</div>
			
			<div class="row">
				<div class="label"><fmt:message key="cadastro_curriculo_titulo_obtido"/></div>
				<span class="formw"><input type="text" name="curriculo.enderecoPermanente.complemento" maxlength=50/></span>
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
			<a class=button href="<c:url value='/'/>"><button><fmt:message key="voltar"/></button></a>			
		</div>	
	</form>
</div>

<%@ include file="../rodape.jsp"%>



