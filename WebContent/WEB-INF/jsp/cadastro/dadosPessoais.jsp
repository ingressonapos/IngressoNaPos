<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript" src="<c:url value='/'/>/js/jquery.js"></script>
<script type="text/javascript" src="<c:url value='/'/>/js/jquery.maskedinput.js"></script>
<script type="text/javascript">
jQuery(function($){
	$("input.data").mask("99/99/9999",{placeholder:""});
  	$("input[name$='cep']").mask("99999-999",{placeholder:""});
  	$("input[name$='cpf']").mask("999.999.999-99",{placeholder:""});
  	$("input[name$='codTelefone']").mask("+99 (99) 9999-9999",{placeholder:""});
});
</script>


<%@ include file="../cabecalho.jsp"%>

<center><h1> <fmt:message key="titulo_cadastro" />  </h1></center>

<div id="form" style="width: 445px; margin: 10px auto;">
				
	<form action="<c:url value='/cadastro/dadosPessoais'/>" method="post">
	
		<fieldset>
			<legend><b> <fmt:message key="titulo_dados_pessoais" /> </b></legend>
			
			<div class="row">
				<div class="label"> <fmt:message key="nome_completo" /> </div>
				<span class="formw"><input type="text" name="dadosPessoais.nomeCompleto" 
					value="${dadosPessoais.nomeCompleto}"  maxlength=50 />
				</span>
			</div>
			
			<div class="row">
				<div class="label"> <fmt:message key="data_de_nascimento" /> </div>
				<span class="formw">
					<input class="data" type="text" name="dadosPessoais.dataDeNascimento" 
						value="<fmt:formatDate value='${dadosPessoais.dataDeNascimento}' type='date' />" />
				</span>
			</div>
			<div class="row">
				<div class="label"> <fmt:message key="estado_civil" /> </div>
				<span class="formw">
					<select name="dadosPessoais.estadoCivil" id="selectMultiple">
						<c:forEach var="tipo" items="${tiposEstadoCivil}"  >						
							<c:choose> 
								<c:when test="${tipo == dadosPessoais.estadoCivil}" > 
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
				<div class="label"> <fmt:message key="documento" /> </div>
				<span class="formw"> 
					<select name="dadosPessoais.cedulaDeIdentidade.tipo" id="selectMultiple">
						<c:forEach var="tipo" items="${tiposCedulaIdentidade}"  >
							<c:choose> 
								<c:when test="${tipo == dadosPessoais.cedulaDeIdentidade.tipo}" > 
							    	<option value="${tipo}" selected="${tipo}" >  <fmt:message key="${tipo.msgKey}" />  </option>
							  	</c:when> 
							  	<c:otherwise> 
							    	<option value="${tipo}" >  <fmt:message key="${tipo.msgKey}" />  </option> 
							  	</c:otherwise> 
							</c:choose>							
						</c:forEach>
					</select> 
				</span>
			</div>
			
			<div class="row">
				<div class="label"> <fmt:message key="numero" /> </div>
				<span class="formw">
					<input type="text" class="numero_com_digito" name="dadosPessoais.cedulaDeIdentidade.numero" 
						value="${dadosPessoais.cedulaDeIdentidade.numero}" />
					<input type="text" class="digito" name="dadosPessoais.cedulaDeIdentidade.digito" 
						value="${dadosPessoais.cedulaDeIdentidade.digito}"/>
				</span>
			</div>
			
			<div class="row">
				<div class="label"> <fmt:message key="cpf" /> </div>
				<span class="formw"><input type="text" name="dadosPessoais.cpf" value="${dadosPessoais.cpf}" /></span>
			</div>
			<div class="row">
				<div class="label"> <fmt:message key="nacionalidade" /> </div>
				<span class="formw"><input type="text" name="dadosPessoais.nacionalidade" value="${dadosPessoais.nacionalidade}"/></span>
			</div>
				
		</fieldset>
		<br>
				
		<fieldset>
			<legend><b> <fmt:message key="titulo_enderecos" /> </b></legend>							
			<h3> <fmt:message key="titulo_endereco_permanente" /> </h3>
			
			<div class="row">
				<div class="label"> <fmt:message key="logradouro" /> </div>
				<span class="formw"><input type="text" name="dadosPessoais.enderecoPermanente.logradouro" 
					value="${dadosPessoais.enderecoPermanente.logradouro}" />
				</span>
			</div>
			
			<div class="row">
				<div class="label"> <fmt:message key="endereco_numero" /> </div>
				<span class="formw"><input type="text" name="dadosPessoais.enderecoPermanente.numero" 
					value="${dadosPessoais.enderecoPermanente.numero}" />
				</span>
			</div>
			
			<div class="row">
				<div class="label"> <fmt:message key="complemento" /> </div>
				<span class="formw"><input type="text" name="dadosPessoais.enderecoPermanente.complemento" 
					value="${dadosPessoais.enderecoPermanente.complemento}" />
				</span>
			</div>
			
			<div class="row">
				<div class="label"> <fmt:message key="cep" /> </div>
				<span class="formw"><input type="text" name="dadosPessoais.enderecoPermanente.cep.cep" 
					value="${dadosPessoais.enderecoPermanente.cep.cep}" />
				</span>
			</div>
			
			<div class="row">
				<div class="label"> <fmt:message key="cidade" /> </div>
				<span class="formw"><input type="text" name="dadosPessoais.enderecoPermanente.cidade"
					value="${dadosPessoais.enderecoPermanente.cidade}" />
				</span>
			</div>
			
			<div class="row">
				<div class="label"> <fmt:message key="estado" /> </div>
				<span class="formw"><input type="text" name="dadosPessoais.enderecoPermanente.estado"
					value="${dadosPessoais.enderecoPermanente.estado}" />
				</span>
			</div>	
					
			<div class="row">
				<div class="label"> <fmt:message key="pais" /> </div>
				<span class="formw">
					<select name="dadosPessoais.estadoCivil" id="selectMultiple">
						<c:forEach var="tipo" items="${tiposEstadoCivil}"  >						
							<c:choose> 
								<c:when test="${tipo == dadosPessoais.estadoCivil}" > 
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
				<div class="label"> <fmt:message key="telefone_residencial" /> </div>
				<span class="formw"><input type="text" name="dadosPessoais.enderecoPermanente.telefone.residencial.codTelefone"
					value="${dadosPessoais.enderecoPermanente.telefone.residencial.codTelefone}" />
				</span>
			</div>
			
			<h3> <fmt:message key="titulo_endereco_correspondencia" /> </h3>
			<br />
			<div class="row">
				<div class="label"> <fmt:message key="logradouro" /> </div>
				<span class="formw"><input type="text" name="dadosPessoais.enderecoCorrespondencia.logradouro"/></span>
			</div>
			
			<div class="row">
				<div class="label"> <fmt:message key="endereco_numero" /> </div>
				<span class="formw"><input type="text" name="dadosPessoais.enderecoCorrespondencia.numero" /></span>
			</div>
			
			<div class="row">
				<div class="label"> <fmt:message key="complemento" /> </div>
				<span class="formw"><input type="text" name="dadosPessoais.enderecoCorrespondencia.complemento"/></span>
			</div>
			
			<div class="row">
				<div class="label"> <fmt:message key="cep" /> </div>
				<span class="formw"><input type="text" name="dadosPessoais.enderecoCorrespondencia.cep.cep"/></span>
			</div>
			
			<div class="row">
				<div class="label"> <fmt:message key="cidade" /> </div>
				<span class="formw"><input type="text" name="dadosPessoais.enderecoCorrespondencia.cidade"/></span>
			</div>
			
			<div class="row">
				<div class="label"> <fmt:message key="estado" /> </div>
				<span class="formw"><input type="text" name="dadosPessoais.enderecoCorrespondencia.estado"/></span>
			</div>
			
			<div class="row">
				<div class="label"> <fmt:message key="telefone" /> </div>
				<span class="formw"><input type="text" name="dadosPessoais.enderecoCorrespondencia.residencial.telefone"/></span>
			</div>						
									
		</fieldset>
		
		<div>
			<input type="submit" value="<fmt:message key='enviar'/>" />
			<a href="<c:url value='/'/>"> <fmt:message key="voltar"/> </a>
		</div>
	
	</form>
</div>

<%@ include file="../rodape.jsp"%>

