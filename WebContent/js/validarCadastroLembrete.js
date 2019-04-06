function validar_cadastro_lembrete(){
	
	var codUsoMed = document.formlembrete.codUsoMed.value;
	var qtdLembrete = document.formlembrete.qtdLembrete.value;
	var alarme = document.formlembrete.alarme.value;	
	
	
	

	//Validando campos obrigatórios
	if (codUsoMed == ""){
		alert("- Preencha o campo codigo");
		document.formlembrete.codUsoMed.focus();
		return false;
	}
	if (qtdLembrete == ""){
		alert("- Preencha o campo Quantidade Lembrete");
		document.formlembrete.apelido.focus();
		return false;
	}
	if (alarme == ""){
		alert("- Preencha o campo quantidade");
		document.formlembrete.quantidade.focus();
		return false;
	}		
	

	//Validando tamanhos minimos e máximos
	if (codUsoMed.length > 4 ){
		alert("- Codigo deve conter entre 1 e 4 caracteres");
		document.formlembrete.codUsoMed.focus();
		return false;
	}	
	if (qtdLembrete.length >  2) {
		alert("- Quantidade deve estar entre 1 e 99 caracteres");
		document.formlembrete.apelido.focus();
		return false;
	}
	if (alarme.length >  12 || alarme.length < 8 ){
		alert("- Alarme invalido");
		document.formlembrete.alarme.focus();
		return false;
	}
	
}