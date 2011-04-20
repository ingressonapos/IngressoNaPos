<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Cadastro de Curr&iacute;culo</title>
		<link href="<c:url value='/css/style.css'/>" rel="stylesheet" type="text/css" />
		<link href="<c:url value='/css/layout.css'/>" rel="stylesheet" type="text/css" />
		<link href="<c:url value='/css/menu.css'/>" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<c:url value='/'/>/js/jquery.js"></script>
		<script type="text/javascript" src="<c:url value='/'/>/js/jquery.maskedinput.js"></script>
	</head>

	<body>
	<script type="text/javascript">
	jQuery(function($){
		   $("input.data").mask("99/9999",{placeholder:""});
	});
	</script>
					
	<center>		
		<div id="principal">
		<div id="menu"><%@ include file="../menu.jsp"%></div>
			<div id="corpo">
				<center><h1>Cadastro</h1></center>
				<div id="form" style="width: 445px; margin: 10px auto;">
								
					<form action="<c:url value='/cadastro/dadosCurriculo'/>" method="post">
					
						<fieldset>
							<legend><b>Formação Acadêmica</b></legend>
							<h3>Graduação</h3>
					
							<div class="row">
								<div class="label">Instituição</div>
								<span class="formw"><input type="text" name="curriculo.formacaoAcademica.Instituicao" maxlength=100 /></span>
							</div>
							
							<div class="row">
								<div class="label">Data de In&iacute;cio(mm/aaaa)</div>
								<span class="formw"><input class=data type="text" name="curriculo.formacaoAcademica.ingressoData"/></span>
							</div>
							
							<div class="row">
								<div class="label">Data de T&eacute;rmino</div>
								<span class="formw"><input class=data type="text" name="curriculo.formacaoAcademica.terminoData"/></span>
							</div>
							
							<div class="row">
								<div class="label">T&iacute;tulo Obtido</div>
								<span class="formw"><input type="text" name="curriculo.formacaoAcademica.Titulo"/></span>
							</div>
							
						<h3>P&oacute;s-Graduação</h3>
						<div class="row">
								<div class="label">Instituição</div>
								<span class="formw"><input type="text" name="curriculo.formacaoAcademica.Instituicao" maxlength=100 /></span>
							</div>
							
							<div class="row">
								<div class="label">Data de In&iacute;cio</div>
								<span class="formw"><input type="text" class=data name="curriculo.formacaoAcademica.ingressoData"/></span>
							</div>
							
							<div class="row">
								<div class="label">Data de T&eacute;rmino</div>
								<span class="formw"><input type="text" class=data name="curriculo.formacaoAcademica.terminoData"/></span>
							</div>
							
							<div class="row">
								<div class="label">T&iacute;tulo Obtido</div>
								<span class="formw"><input type="text" name="curriculo.formacaoAcademica.Titulo"/></span>
							</div>
							
							<div class="row">
								<div class="label">T&iacute;tulo da Dissertação</div>
								<span class="formw"><input type="text" name="curriculo.formacaoAcademica.tituloDissert"/></span>
							</div>
							
							<div class="row">
								<div class="label">Nome do Orientador</div>
								<span class="formw"><input type="text" name="curriculo.formacaoAcademica.nomeOrientador"/></span>
							</div>
								
						</fieldset>
						

	   				
						<fieldset>
							<legend><b>Iniciação Científica</b></legend>							
							
							<div class="row">
								<div class="label">Realizou Iniciação Cient&iacute;fica? </div>
								<span class="formw">Sim<input type="radio" name="curriculo.iniciacaoCientifica"/></span>
								<span class="formw">Não<input type="radio" name="curriculo.iniciacaoCientifica"/></span>
							</div>
							
							<div class="row">
								<div class="label">Instituição</div>
								<span class="formw"><input type="text" name="curriculo.iniciacaoCientifica.nomeInstituicao" maxlength=100/></span>
							</div>
							
							<div class="row">
								<div class="label">Tema do Projeto</div>
								<span class="formw"><input type="text" name="curriculo.iniciacaoCientifica.temaProjeto" maxlength=100/></span>
							</div>
							
							<div class="row">
								<div class="label">Nome do Orientador</div>
								<span class="formw"><input type="text" name="curriculo.iniciacaoCientifica.nomeOrientador" maxlength=50/></span>
							</div>
													
						</fieldset>
						
						<fieldset>
							<legend><b>Outras Atividades Acadêmicas</b></legend>
							
							<div class="row">
								<div class="label">Descrição</div>
								<span class="formw"><input type="text" name=""/></span>
							</div>
							
							<div class="row">
								<div class="label">Instituição</div>
								<span class="formw"><input type="text" name="" maxlength=100/></span>
							</div>
							
							<div class="row">
								<div class="label">Data de In&iacute;cio</div>
								<span class="formw"><input type="text" class="data" name="curriculo.enderecoPermanente.numero" maxlength=100/></span>
								
							</div>
							
							<div class="row">
								<div class="label">Data de T&eacute;rmino</div>
								<span class="formw"><input type="text" class=data name="curriculo.enderecoPermanente.complemento" maxlength=50/></span>
							</div>
							
							<div class="row">
								<div class="label">T&iacute;tulo Obtido</div>
								<span class="formw"><input type="text" name="curriculo.enderecoPermanente.complemento" maxlength=50/></span>
							</div>
							
						</fieldset>
						
						<fieldset>
							<legend><b>POSCOMP</b></legend>							
							
							<div class="row">
								<div class="label">Realizou POSCOMP?</div>
								Sim<span class="formw"><input type="radio" name=""/></span>
								Não<span class="formw"><input type="radio" name=""/></span>
							</div>
							
							<div class="row">
								<div class="label">Ano</div>
								<span class="formw"><input type="text" name="curriculo.posComp.ano" maxlength=4/></span>
							</div>
							
							<div class="row">
								<div class="label">Acertos em L&oacute;gica</div>
								<span class="formw"><input type="text" name="curriculo.posComp.notaLogica" maxlength=2/></span>
							</div>
							
							<div class="row">
								<div class="label">Acertos em Matem&aacute;tica</div>
								<span class="formw"><input type="text" name="curriculo.posComp.notaMatematica" maxlength=2/></span>
							</div>
							
							<div class="row">
								<div class="label">Acertos em Tecnologia</div>
								<span class="formw"><input type="text" name="curriculo.posComp.notaTecnologia" maxlength=2/></span>
							</div>
							
							<div class="row">
								<div class="label">Comprovante</div>
								<span class="formw"><input type="text" name="curriculo.posComp.arquivoPosComp" maxlength=2/></span>
							</div>
													
						</fieldset>
						
						<fieldset>
							<legend><b>Cartas de Recomendação</b></legend>							
							
							<div class="row">
								<div class="label">Nome do Professor</div>
								<span class="formw"><input type="text" name="" maxlength=50/></span>
							</div>
							
							<div class="row">
								<div class="label">Instituição</div>
								<span class="formw"><input type="text" name="" maxlength=100/></span>
							</div>
													
						</fieldset>
						
						<fieldset>
							<legend><b>Aluno Especial</b></legend>							
							
							<div class="row">
								<div class="label">Foi aluno especial no IME?</div>
								Sim<span class="formw"><input type="radio" name=""/></span>
								Não<span class="formw"><input type="radio" name=""/></span>
							</div>
							
							<div class="row">
								<div class="label">Disciplina</div>
								<span class="formw"><input type="text" name="" maxlength=50/></span>
							</div>
							
							<div class="row">
								<div class="label">Ano</div>
								<span class="formw"><input type="text" name="" maxlength=4/></span>
							</div>
							
							<div class="row">
								<div class="label">Conceito Obtido</div>
								<span class="formw"><input type="text" name="" maxlength=2/></span>
							</div>
													
						</fieldset>
						
						<div>
							<input type="submit" value="Enviar">
							<a href="<c:url value='/index'/>"><button><fmt:message key="voltar"/></button></a>
						</div>
					
					</form>
				</div>
			</div>
			<div id="menu"><%@ include file="../rodape.jsp"%></div>
		</div>
	</center>
	</body>
</html>