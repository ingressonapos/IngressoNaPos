<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../cabecalho.jsp"%>

<script type="text/javascript">
jQuery(function($){
	$("input.data").mask("99/99/9999",{placeholder:""});
  	$("input[name$='cpf']").mask("999.999.999-99",{placeholder:""});
  	$("input[name$='codTelefone']").mask("(99) 9999-9999",{placeholder:""});
  	$("input[name$='telefone']").mask("(99) 9999-9999",{placeholder:""});
  	$("input[name$='cep']").mask("99999-999",{placeholder:""});
});

function copiaEndereco(){
	$("#enderecoCorrespondenciaLogradouro").val($("#enderecoPermanenteLogradouro").val());
	$("#enderecoCorrespondenciaNumero").val($("#enderecoPermanenteNumero").val());
	$("#enderecoCorrespondenciaComplemento").val($("#enderecoPermanenteComplemento").val());
	$("#enderecoCorrespondenciaCep").val($("#enderecoPermanenteCep").val());
	$("#enderecoCorrespondenciaCidade").val($("#enderecoPermanenteCidade").val());
	$("#enderecoCorrespondenciaEstado").val($("#enderecoPermanenteEstado").val());
	$("#enderecoCorrespondenciaPais").val($("#enderecoPermanentePais").val());
	$("#enderecoCorrespondenciaTelefone").val($("#enderecoPermanenteTelefone").val());
}
</script>

<center><h1> <fmt:message key="cadastro_dados_pessoais_titulo_cadastro" />  </h1></center>

<div id="form" class="form_cadastro">

	<form action="<c:url value='/cadastro/dadosPessoais'/>" method="post">
	
		<br>
		<div align="right">
			<font color = "red"><fmt:message key="cadastro_dados_pessoais_asterisco_obrigatorio" /></font>
		</div>
	
		<fieldset>
			<legend><b> <fmt:message key="cadastro_dados_pessoais_titulo_dados_pessoais" /> </b></legend>
			
			<div class="row">
				<div class="label"> <fmt:message key="cadastro_dados_pessoais_nome_completo" />
					<font color = "red">*</font> </div>
				<span class="formw"><input type="text" name="dadosPessoais.nomeCompleto" 
					value="${dadosPessoais.nomeCompleto}"  maxlength=50 style="width: 98%" />
				</span>
			</div>
			
			<div class="row">
				<div class="label"> <fmt:message key="cadastro_dados_pessoais_data_de_nascimento" />
					<font color = "red">*</font> </div>
				<span class="formw">
					<input class="data" type="text" style="width: 85px" name="dadosPessoais.dataDeNascimento" 
						value="<fmt:formatDate value='${dadosPessoais.dataDeNascimento}' type='date' />" />
				</span>
			</div>
			<div class="row">
				<div class="label"> <fmt:message key="cadastro_dados_pessoais_estado_civil" />
					<font color = "red">*</font> </div>
				<span class="formw">
					<select name="dadosPessoais.estadoCivil" id="selectMultiple">
						<c:forEach var="tipo" items="${tiposEstadoCivil}"  >						
							<c:choose> 
								<c:when test="${tipo == dadosPessoais.estadoCivil}" > 
							    	<option value="${tipo}" selected="${tipo}" >  <fmt:message key="cadastro_dados_pessoais_${tipo.msgKey}" />  </option>
							  	</c:when> 
							  	<c:otherwise> 
							    	<option value="${tipo}"  >  <fmt:message key="cadastro_dados_pessoais_${tipo.msgKey}" />  </option> 
							  	</c:otherwise> 
							</c:choose>											
						</c:forEach>
					</select>
				</span>
			</div>
			
			<div class="row">
				<div class="label"> <fmt:message key="cadastro_dados_pessoais_documento" />
					<font color = "red">*</font> </div>
				<span class="formw"> 
					<select name="dadosPessoais.cedulaDeIdentidade.tipo" id="selectMultiple">
						<c:forEach var="tipo" items="${tiposCedulaIdentidade}"  >
							<c:choose> 
								<c:when test="${tipo == dadosPessoais.cedulaDeIdentidade.tipo}" > 
							    	<option value="${tipo}" selected="${tipo}" >  <fmt:message key="cadastro_dados_pessoais_${tipo.msgKey}" />  </option>
							  	</c:when> 
							  	<c:otherwise> 
							    	<option value="${tipo}" >  <fmt:message key="cadastro_dados_pessoais_${tipo.msgKey}" />  </option> 
							  	</c:otherwise> 
							</c:choose>							
						</c:forEach>
					</select> 
				</span>
			</div>
			
			<div class="row">
				<div class="label"> <fmt:message key="cadastro_dados_pessoais_numero" />
					<font color = "red">*</font> </div>
				<span class="formw">
					<input type="text" class="numero_com_digito" style="width: 100px" name="dadosPessoais.cedulaDeIdentidade.numero" 
						value="${dadosPessoais.cedulaDeIdentidade.numero}" />
					<input type="text" class="digito" style="width: 40px" name="dadosPessoais.cedulaDeIdentidade.digito" 
						value="${dadosPessoais.cedulaDeIdentidade.digito}" />
				</span>
			</div>
			
			<div class="row">
				<div class="label"> <fmt:message key="cadastro_dados_pessoais_cpf" /> </div>
				<span class="formw"><input type="text" style="width: 120px" name="dadosPessoais.cpf" value="${dadosPessoais.cpf}" /></span>
			</div>

			<div class="row">
				<div class="label"> <fmt:message key="cadastro_dados_pessoais_pais_origem" />
					<font color = "red">*</font> </div>
				<span class="formw">
					<select name="dadosPessoais.nacionalidade" id="selectMultiple">
						<c:forEach var="tipo" items="${tiposPais}"  >						
							<c:choose> 
								<c:when test="${tipo == dadosPessoais.nacionalidade}" > 
							    	<option value="${tipo}" selected="${tipo}" >  <fmt:message key="${tipo.msgKey}" />  </option>
							  	</c:when> 
							  	<c:otherwise> 
							    	<option value="${tipo}"  >  <fmt:message key="${tipo.msgKey}" />  </option> 
							  	</c:otherwise> 
							</c:choose>											
						</c:forEach>
					</select>
				</span>
			</div>		
				
		</fieldset>
		<br>
				
		<fieldset>
			<legend><b> <fmt:message key="cadastro_dados_pessoais_titulo_enderecos" /> </b></legend>							
			<h3> <fmt:message key="cadastro_dados_pessoais_titulo_endereco_permanente" /> </h3>
			
			<div class="row">
				<div class="label"> <fmt:message key="cadastro_dados_pessoais_logradouro" />
					<font color = "red">*</font> </div>
				<span class="formw"><input type="text" id="enderecoPermanenteLogradouro" name="dadosPessoais.enderecoPermanente.logradouro" 
					value="${dadosPessoais.enderecoPermanente.logradouro}" style="width: 98%" />
				</span>
			</div>
			
			<div class="row">
				<div class="label"> <fmt:message key="cadastro_dados_pessoais_endereco_numero" />
					<font color = "red">*</font> </div>
				<span class="formw"><input type="text" id="enderecoPermanenteNumero" name="dadosPessoais.enderecoPermanente.numero" 
					value="${dadosPessoais.enderecoPermanente.numero}" style="width: 100px" />
				</span>
			</div>
			
			<div class="row">
				<div class="label">  <fmt:message key="cadastro_dados_pessoais_complemento" /> </div>
				<span class="formw"><input type="text" id="enderecoPermanenteComplemento" name="dadosPessoais.enderecoPermanente.complemento" 
					value="${dadosPessoais.enderecoPermanente.complemento}" style="width: 200px" />
				</span>
			</div>
			
			<div class="row">
				<div class="label"> <fmt:message key="cadastro_dados_pessoais_cep" />
					<font color = "red">*</font> </div>
				<span class="formw"><input type="text" id="enderecoPermanenteCep" name="dadosPessoais.enderecoPermanente.cep.cep" 
					value="${dadosPessoais.enderecoPermanente.cep.cep}" style="width: 100px" />
				</span>
			</div>
			
			<div class="row">
				<div class="label"> <fmt:message key="cidade" />
					<font color = "red">*</font> </div>
				<span class="formw"><input type="text" id="enderecoPermanenteCidade" name="dadosPessoais.enderecoPermanente.cidade"
					value="${dadosPessoais.enderecoPermanente.cidade}" style="width: 50%" />
				</span>
			</div>
			
			<div class="row">
				<div class="label"> <fmt:message key="cadastro_dados_pessoais_estado" />
					<font color = "red">*</font> </div>
				<span class="formw"><input type="text" id="enderecoPermanenteEstado" name="dadosPessoais.enderecoPermanente.estado"
					value="${dadosPessoais.enderecoPermanente.estado}" style="width: 50%" />
				</span>
			</div>	
					
			<div class="row">
				<div class="label"> <fmt:message key="cadastro_dados_pessoais_pais" />
					<font color = "red">*</font> </div>
				<span class="formw">
					<select name="dadosPessoais.enderecoPermanente.pais" id="enderecoPermanentePais">
						<c:forEach var="tipo" items="${tiposPais}"  >						
							<c:choose> 
								<c:when test="${tipo == dadosPessoais.enderecoPermanente.pais}" > 
							    	<option value="${tipo}" selected="${tipo}" >  <fmt:message key="${tipo.msgKey}" />  </option>
							  	</c:when> 
							  	<c:otherwise> 
							    	<option value="${tipo}"  >  <fmt:message key="${tipo.msgKey}" />  </option> 
							  	</c:otherwise> 
							</c:choose>											
						</c:forEach>
					</select>
				</span>
			</div>		
				
			<div class="row">
				<div class="label"> <fmt:message key="cadastro_dados_pessoais_telefone_contato" />
					<font color = "red">*</font> </div>
				<span class="formw"><input type="text" id="enderecoPermanenteTelefone" name="dadosPessoais.enderecoPermanente.telefone.codTelefone"
					value="${dadosPessoais.enderecoPermanente.telefone.numeroCompleto}" style="width: 200px" />
				</span>
			</div>
			
			<h3> <fmt:message key="titulo_endereco_correspondencia" /> </h3>
			<br />
			
			<div class="row">
				<span class="formw"><input type="button" value = "<fmt:message key="cadastro_dados_pessoais_usar_enderecos_iguais" />" onclick = "copiaEndereco()"/>
				</span>
			</div>
			
			<div class="row">
				<div class="label"> <fmt:message key="logradouro" /> </div>
				<span class="formw"><input type="text" id="enderecoCorrespondenciaLogradouro" name="dadosPessoais.enderecoCorrespondencia.logradouro" 
					value="${dadosPessoais.enderecoCorrespondencia.logradouro}" style="width: 98%"/>
				</span>
			</div>
			
			<div class="row">
				<div class="label"> <fmt:message key="endereco_numero" /> </div>
				<span class="formw"><input type="text" id="enderecoCorrespondenciaNumero" name="dadosPessoais.enderecoCorrespondencia.numero" 
					value="${dadosPessoais.enderecoCorrespondencia.numero}" style="width: 100px"/>
				</span>
			</div>
			
			<div class="row">
				<div class="label"> <fmt:message key="complemento" /> </div>
				<span class="formw"><input type="text" id="enderecoCorrespondenciaComplemento" name="dadosPessoais.enderecoCorrespondencia.complemento" 
					value="${dadosPessoais.enderecoCorrespondencia.complemento}" style="width: 200px"/>
				</span>
			</div>
			
			<div class="row">
				<div class="label"> <fmt:message key="cep" /> </div>
				<span class="formw"><input type="text" id="enderecoCorrespondenciaCep" name="dadosPessoais.enderecoCorrespondencia.cep.cep" 
					value="${dadosPessoais.enderecoCorrespondencia.cep.cep}" style="width: 100px"/>
				</span>
			</div>
			
			<div class="row">
				<div class="label"> <fmt:message key="cidade" /> </div>
				<span class="formw"><input type="text" id="enderecoCorrespondenciaCidade" name="dadosPessoais.enderecoCorrespondencia.cidade"
					value="${dadosPessoais.enderecoCorrespondencia.cidade}" style="width: 50%"/>
				</span>
			</div>
			
			<div class="row">
				<div class="label"> <fmt:message key="estado" /> </div>
				<span class="formw"><input type="text" id="enderecoCorrespondenciaEstado" name="dadosPessoais.enderecoCorrespondencia.estado"
					value="${dadosPessoais.enderecoCorrespondencia.estado}" style="width: 50%"/>
				</span>
			</div>
			
			<div class="row">
				<div class="label"> <fmt:message key="cadastro_dados_pessoais_pais" /> </div>
				<span class="formw">
					<select name="dadosPessoais.enderecoCorrespondencia.pais" id="enderecoCorrespondenciaPais">
						<c:forEach var="tipo" items="${tiposPais}"  >						
							<c:choose> 
								<c:when test="${tipo == dadosPessoais.enderecoCorrespondencia.pais}" > 
							    	<option value="${tipo}" selected="${tipo}" >  <fmt:message key="${tipo.msgKey}" />  </option>
							  	</c:when> 
							  	<c:otherwise> 
							    	<option value="${tipo}"  >  <fmt:message key="${tipo.msgKey}" />  </option> 
							  	</c:otherwise> 
							</c:choose>											
						</c:forEach>
					</select>
				</span>
			</div>
			
			<div class="row">
				<div class="label"> <fmt:message key="cadastro_dados_pessoais_telefone" /> </div>
				<span class="formw"><input type="text" id="enderecoCorrespondenciaTelefone" name="dadosPessoais.enderecoCorrespondencia.telefone.codTelefone"
					value="${dadosPessoais.enderecoCorrespondencia.telefone.numeroCompleto}" style="width: 200px"/>
				</span>
			</div>						
									
		</fieldset>
		
		<div>
			<input type="submit" value="<fmt:message key='enviar'/>" />
			<a class=button href="<c:url value='/'/>"><button type="button"><fmt:message key="voltar"/></button> </a>	
		</div>
	
	</form>
</div>

<%@ include file="../rodape.jsp"%>

