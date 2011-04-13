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
	</head>

	<body>
					
	<center>		
		<div id="principal">
		<div id="menu"><%@ include file="../menu.jsp"%></div>
			<div id="corpo">
				<center><h1>Cadastro</h1></center>
				<div id="form" style="width: 445px; margin: 10px auto;">
								
					<form action="<c:url value='/cadastro/dadosCurriculo'/>" method="post">
					
						<fieldset>
							<legend><b>Formação Acadêmica</b></legend>
							<h3>Graduação</h3><br />
							
							<div class="row">
								<span class="label">Instituição</span>
								<span class="formw"><input type="text" name="dadosPessoais.nomeCompleto" maxlength=100 /></span><br/>
							</div>
							
							<div class="row">
								<span class="label">Data de In&iacute;cio</span>
								<span class="formw"><input type="text" name="dadosPessoais.dataDeNascimento"/></span><br/>
							</div>
							
							<div class="row">
								<span class="label">Data de T&eacute;rmino</span>
								<span class="formw"><input type="text" name="dadosPessoais.dataDeNascimento"/></span><br/>
							</div>
							
							<div class="row">
								<span class="label">T&iacute;tulo Obtido</span>
								<span class="formw"><input type="text" name="dadosPessoais.dataDeNascimento"/></span><br/>
							</div>
							
						<h3>P&oacute;s-Graduação</h3><br />
						<div class="row">
								<span class="label">Instituição</span>
								<span class="formw"><input type="text" name="dadosPessoais.nomeCompleto" maxlength=100 /></span><br/>
							</div>
							
							<div class="row">
								<span class="label">Data de In&iacute;cio</span>
								<span class="formw"><input type="text" name="dadosPessoais.dataDeNascimento"/></span><br/>
							</div>
							
							<div class="row">
								<span class="label">Data de T&eacute;rmino</span>
								<span class="formw"><input type="text" name="dadosPessoais.dataDeNascimento"/></span><br/>
							</div>
							
							<div class="row">
								<span class="label">T&iacute;tulo Obtido</span>
								<span class="formw"><input type="text" name="dadosPessoais.dataDeNascimento"/></span><br/>
							</div>
							
							<div class="row">
								<span class="label">T&iacute;tulo da Dissertação</span>
								<span class="formw"><input type="text" name="dadosPessoais.dataDeNascimento"/></span><br/>
							</div>
							
							<div class="row">
								<span class="label">Nome do Orientador</span>
								<span class="formw"><input type="text" name="dadosPessoais.dataDeNascimento"/></span><br/>
							</div>
								
						</fieldset>
						
						<br>
	   				
						<fieldset>
							<legend><b>Iniciação Científica</b></legend>							
							
							<div class="row">
								<span class="label">Realizou Iniciação Cient&iacute;fica? <br />Sim</span>
								<span class="formw"><input type="radio" name="dadosPessoais.enderecoPermanente.logradouro"/></span>
								Não<span class="formw"><input type="radio" name="dadosPessoais.enderecoPermanente.logradouro"/></span><br />
							</div>
							
							<div class="row">
								<span class="label">Instituição</span>
								<span class="formw"><input type="text" name="dadosPessoais.enderecoPermanente.logradouro" maxlength=100/></span><br />
							</div>
							
							<div class="row">
								<span class="label">Tema do Projeto</span>
								<span class="formw"><input type="text" name="dadosPessoais.enderecoPermanente.numero" maxlength=100/></span><br />
							</div>
							
							<div class="row">
								<span class="label">Nome do Orientador</span>
								<span class="formw"><input type="text" name="dadosPessoais.enderecoPermanente.complemento" maxlength=50/></span><br />
							</div>
													
						</fieldset>
						
						<fieldset>
							<legend><b>Outras Atividades Acadêmicas</b></legend>
							
							<div class="row">
								<span class="label">Descrição</span>
								<span class="formw"><input type="text" name="dadosPessoais.enderecoPermanente.logradouro"/></span><br />
							</div>
							
							<div class="row">
								<span class="label">Instituição</span>
								<span class="formw"><input type="text" name="dadosPessoais.enderecoPermanente.logradouro" maxlength=100/></span><br />
							</div>
							
							<div class="row">
								<span class="label">Data de In&iacute;cio</span>
								<span class="formw"><input type="text" name="dadosPessoais.enderecoPermanente.numero" maxlength=100/></span><br />
							</div>
							
							<div class="row">
								<span class="label">Data de T&eacute;rmino</span>
								<span class="formw"><input type="text" name="dadosPessoais.enderecoPermanente.complemento" maxlength=50/></span><br />
							</div>
							
							<div class="row">
								<span class="label">T&iacute;tulo Obtido</span>
								<span class="formw"><input type="text" name="dadosPessoais.enderecoPermanente.complemento" maxlength=50/></span><br />
							</div>
							
						</fieldset>
						
						<fieldset>
							<legend><b>POSCOMP</b></legend>							
							
							<div class="row">
								<span class="label">Realizou POSCOMP? <br />Sim</span>
								<span class="formw"><input type="radio" name="dadosPessoais.enderecoPermanente.logradouro"/></span>
								Não<span class="formw"><input type="radio" name="dadosPessoais.enderecoPermanente.logradouro"/></span><br />
							</div>
							
							<div class="row">
								<span class="label">Ano</span>
								<span class="formw"><input type="text" name="dadosPessoais.enderecoPermanente.logradouro" maxlength=4/></span><br />
							</div>
							
							<div class="row">
								<span class="label">Acertos em L&oacute;gica</span>
								<span class="formw"><input type="text" name="dadosPessoais.enderecoPermanente.logradouro" maxlength=2/></span><br />
							</div>
							
							<div class="row">
								<span class="label">Acertos em Matem&aacute;tica</span>
								<span class="formw"><input type="text" name="dadosPessoais.enderecoPermanente.logradouro" maxlength=2/></span><br />
							</div>
							
							<div class="row">
								<span class="label">Acertos em Tecnologia</span>
								<span class="formw"><input type="text" name="dadosPessoais.enderecoPermanente.logradouro" maxlength=2/></span><br />
							</div>
							
							<div class="row">
								<span class="label">Comprovante</span>
								<span class="formw"><input type="text" name="dadosPessoais.enderecoPermanente.logradouro" maxlength=2/></span><br />
							</div>
													
						</fieldset>
						
						<fieldset>
							<legend><b>Cartas de Recomendação</b></legend>							
							
							<div class="row">
								<span class="label">Nome do Professor</span>
								<span class="formw"><input type="text" name="dadosPessoais.enderecoPermanente.logradouro" maxlength=50/></span><br />
							</div>
							
							<div class="row">
								<span class="label">Instituição</span>
								<span class="formw"><input type="text" name="dadosPessoais.enderecoPermanente.logradouro" maxlength=100/></span><br />
							</div>
													
						</fieldset>
						
						<fieldset>
							<legend><b>Aluno Especial</b></legend>							
							
							<div class="row">
								<span class="label">Foi aluno especial no IME? <br />Sim</span>
								<span class="formw"><input type="radio" name="dadosPessoais.enderecoPermanente.logradouro"/></span>
								Não<span class="formw"><input type="radio" name="dadosPessoais.enderecoPermanente.logradouro"/></span><br />
							</div>
							
							<div class="row">
								<span class="label">Disciplina</span>
								<span class="formw"><input type="text" name="dadosPessoais.enderecoPermanente.logradouro" maxlength=50/></span><br />
							</div>
							
							<div class="row">
								<span class="label">Ano</span>
								<span class="formw"><input type="text" name="dadosPessoais.enderecoPermanente.logradouro" maxlength=4/></span><br />
							</div>
							
							<div class="row">
								<span class="label">Conceito Obtido</span>
								<span class="formw"><input type="text" name="dadosPessoais.enderecoPermanente.logradouro" maxlength=2/></span><br />
							</div>
													
						</fieldset>
						
						<div>
							<input type="submit" value="Enviar">
						</div>
					
					</form>
				</div>
			</div>
			<div id="menu"><%@ include file="../rodape.jsp"%></div>
		</div>
	</center>
	</body>
</html>