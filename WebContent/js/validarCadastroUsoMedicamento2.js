function validar_cadastro_usomedicamento(){
	
	var	codUsoMed = document.formusomedicamento.codUsoMed.value;
	var codMed= document.formusomedicamento.codMed.value;
	var codUsuario = document.formusomedicamento.codUsuario.value;	
	var dataInicio = document.formusomedicamento.dataInicio.value;
	var dataTermino = document.formusomedicamento.dataTermino.value;	

	
	

	//Validando campos obrigatórios
	if (codUsoMed == ""){
		alert("- Preencha o campo codigo");
		document.formusomedicamento.codUsoMed.focus();
		return false;
	}
	if (codMed == ""){
		alert("- Preencha o campo codigo");
		document.formusomedicamento.codMed.focus();
		return false;
	}
	if (codUsuario == ""){
		alert("- Preencha o campo codigo");
		document.formusomedicamento.codUsuario.focus();
		return false;
	}
	if (dataInicio == ""){
		alert("- Preencha o campo Data Inicio");
		document.formusomedicamento.dataInicio.focus();
		return false;
	}
	if (dataTermino == ""){
		alert("- Preencha o campo Data Termino");
		document.formusomedicamento.dataTermino.focus();
		return false;
	}		
	

	

	//Validando tamanhos minimos e máximos
	if (codUsoMed.length > 4 ){
		alert("- Código inválido");
		document.formusomedicamento.codUsoMed.focus();
		return false;
	}
	if (codMed.length > 4 ){
		alert("- Código inválido");
		document.formusomedicamento.codMed.focus();
		return false;
	}
	
	if (codUsuario.lenght > 4){
		alert("- Código inválido");
		document.formusomedicamento.codUsuario.focus();
		return false;
	}
	
	if (dataInicio.length >  12 || dataInicico.length < 8 ){
		alert("- Data inválida");
		document.formusomedicamento.dataInicio.focus();
		return false;
	}
	if (dataTermino.length >  12 || dataTermino.length < 8 ){
		alert("- Data inválida");
		document.formusomedicamento.dataTermino.focus();
		return false;
	}	
	
}