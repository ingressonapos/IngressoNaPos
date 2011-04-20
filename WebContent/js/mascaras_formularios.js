jQuery(function($){
	   $("input[name$='cep']").mask("99999-999",{placeholder:""});
	   $("input[name$='cpf']").mask("999.999.999-99",{placeholder:""});
	   $("input[name$='rg']").mask("99.999.999-9",{placeholder:""});
});