<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript" src="<c:url value='/'/>/js/jquery.js"></script>
<script type="text/javascript" src="<c:url value='/'/>/js/jquery.maskedinput.js"></script>
<script type="text/javascript">
jQuery(function($){
	$("input.data").mask("99/99/9999",{placeholder:""});
  		$("input[name$='cep']").mask("99999-999",{placeholder:""});
  		$("input[name$='cpf']").mask("999.999.999-99",{placeholder:""});
});
</script>


<%@ include file="../cabecalho.jsp"%>

<center><h1>Cadastro</h1></center>

<div id="form" style="width: 445px; margin: 10px auto;">
				
	<form action="<c:url value='/cadastro/dadosUsuario'/>" method="post">
	
		<fieldset>
			<legend><b>Dados Pessoais</b></legend>
			
			<div class="row">
				<div class="label">Nome Completo</div>
				<span class="formw"><input type="text" name="dadosPessoais.nomeCompleto" maxlength=50 /></span>
			</div>
			
			<div class="row">
				<div class="label">Data de Nascimento</div>
				<span class="formw"><input class=data type="text" name="dadosPessoais.dataDeNascimento"/></span>
			</div>
			<div class="row">
				<div class="label"> Estado Civil</div>
				<span class="formw">
					<select name="dadosPessoais.estadoCivil" id="selectMultiple">
						<c:forEach var="tipo" items="${tiposEstadoCivil}"  >
							<option value="${tipo}" >  <fmt:message key="${tipo.msgKey}" />  </option>
						</c:forEach>										
					</select>
				</span>
			</div>
			
			<div class="row">
				<div class="label"> Documento</div>
				<span class="formw"> 
					<select name="dadosPessoais.cedulaDeIdentidade.tipo" id="selectMultiple">
						<c:forEach var="tipo" items="${tiposCedulaIdentidade}"  >
							<option value="${tipo}" >  <fmt:message key="${tipo.msgKey}" />  </option>
						</c:forEach>
					</select> 
				</span>
			</div>
			
			<div class="row">
				<div class="label">N&uacute;mero</div>
				<span class="formw">
					<input type="text" class="numero_com_digito" name="dadosPessoais.cedulaDeIdentidade.numero" />
					<input type="text" class="digito" name="dadosPessoais.cedulaDeIdentidade.digito"/>
				</span>
			</div>
			
			<div class="row">
				<div class="label">CPF</div>
				<span class="formw"><input type="text" name="dadosPessoais.cpf" /></span>
			</div>
			<div class="row">
				<div class="label">Nacionalidade</div>
				<span class="formw"><input type="text" name="dadosPessoais.nacionalidade" /></span>
			</div>
				
		</fieldset>
		<br>
				
		<fieldset>
			<legend><b>Endereços</b></legend>							
			<h3>Endereço Permanente</h3>
			
			<div class="row">
				<div class="label">Logradouro</div>
				<span class="formw"><input type="text" name="dadosPessoais.enderecoPermanente.logradouro"/></span>
			</div>
			
			<div class="row">
				<div class="label">N&uacute;mero</div>
				<span class="formw"><input type="text" name="dadosPessoais.enderecoPermanente.numero"/></span>
			</div>
			
			<div class="row">
				<div class="label">Complemento</div>
				<span class="formw"><input type="text" name="dadosPessoais.enderecoPermanente.complemento"/></span>
			</div>
			
			<div class="row">
				<div class="label">CEP:</div>
				<span class="formw"><input type="text" name="dadosPessoais.enderecoPermanente.cep.cep"/></span>
			</div>
			
			<div class="row">
				<div class="label">Cidade</div>
				<span class="formw"><input type="text" name="dadosPessoais.enderecoPermanente.cidade"/></span>
			</div>
			
			<div class="row">
				<div class="label">Estado</div>
				<span class="formw"><input type="text" name="dadosPessoais.enderecoPermanente.estado"/></span>
			</div>
			
			<div class="row">
				<div class="label">Telefone Residencial:</div>
				<span class="formw"><input type="text" name="dadosPessoais.enderecoPermanente.telefone.residencial.codTelefone" /></span>
			</div>
			
			<h3>Endereço para Correspondência</h3>
			<br />
			<div class="row">
				<div class="label">Logradouro</div>
				<span class="formw"><input type="text" name="dadosPessoais.enderecoCorrespondencia.logradouro"/></span>
			</div>
			
			<div class="row">
				<div class="label">N&uacute;mero</div>
				<span class="formw"><input type="text" name="dadosPessoais.enderecoCorrespondencia.numero" /></span>
			</div>
			
			<div class="row">
				<div class="label">Complemento</div>
				<span class="formw"><input type="text" name="dadosPessoais.enderecoCorrespondencia.complemento"/></span>
			</div>
			
			<div class="row">
				<div class="label">CEP:</div>
				<span class="formw"><input type="text" name="dadosPessoais.enderecoCorrespondencia.cep.cep"/></span>
			</div>
			
			<div class="row">
				<div class="label">Cidade</div>
				<span class="formw"><input type="text" name="dadosPessoais.enderecoCorrespondencia.cidade"/></span>
			</div>
			
			<div class="row">
				<div class="label">Estado</div>
				<span class="formw"><input type="text" name="dadosPessoais.enderecoCorrespondencia.estado"/></span>
			</div>
			
			<div class="row">
				<div class="label">Telefone:</div>
				<span class="formw"><input type="text" name="dadosPessoais.enderecoCorrespondencia.residencial.telefone"/></span>
			</div>						
									
		</fieldset>
		
		<div>
			<input type="submit" value="<fmt:message key='enviar'/>">
			<a href="<c:url value='/'/>"><button><fmt:message key="voltar"/></button></a>
		</div>
	
	</form>
</div>

<%@ include file="../rodape.jsp"%>

