//SCRIPT PARA DIGITAR SOMENTE NUMEROS
function somenteNumeros(e){		
	key = e.keyCode || e.which;
	teclado = String.fromCharCode(key);
	numeros = "0123456789";
	especial = "8-37-38-46"; // array 
	teclado_especial = false;

	for (var i in especial ) {
		if ( key == especial[i] ) {
			teclado_especial = true;
		}
	}
	if ( numeros.indexOf(teclado) == -1 && !teclado_especial ) {
		return false;
	}
}
function validar_cadastro_paciente(){
	
	var codigo = document.formusuario.codigo.value;
	var nome = document.formusuario.nome.value;	
	var username = document.formusuario.username.value;
	var senha = document.formusuario.senha.value;
	var datanascimento = document.formusuario.datanascimento.value;		
	var resposta = document.formusuario.resposta.value;
	
	

	//Validando campos obrigatórios
	if (codigo == ""){
		alert("- Preencha o campo codigo");
		document.formusuario.codigo.focus();
		return false;
	}
	
	if (nome == ""){
		alert("- Preencha o campo nome");
		document.formusuario.nome.focus();
		return false;
	}
	if (username == ""){
		alert("- Preencha o campo username");
		document.formusuario.username.focus();
		return false;
	}
	if (senha == ""){
		alert("- Preencha o campo senha");
		document.formusuario.senha.focus();
		return false;
	}		
	if (datanascimento == ""){
		alert("- Preencha o campo data de nasciemnto");
		document.formusuario.datanascimento.focus();
		return false;
	}
	if (resposta == ""){
		alert("- Preencha o campo resposta");
		document.formusuario.resposta.focus();
		return false;
	}

	

	//Validando tamanhos minimos e máximos
	if (codigo.length > 9999 || codigo.length < 1){
		alert("- Codigo deve conter entre 4 e 1 caracteres");
		document.formusuario.nome.focus();
		return false;
	}
	
	if (nome.length > 30 || nome.length < 3){
		alert("- Nome deve conter entre 3 e 30 caracteres");
		document.formusuario.nome.focus();
		return false;
	}
	
	if (username.length >  20 || username.length < 3 ){
		alert("- Username deve conter entre 3 e 20 caracteres");
		document.formusuario.username.focus();
		return false;
	}
	if (senha.length >  30 || senha.length < 2 ){
		alert("- Senha deve conter entre 5 e 30 caracteres");
		document.formusuario.senha.focus();
		return false;
	}
	if (datanascimento.length >  11 || datanascimento.length < 8 ){
		alert("- Preencha o campo data corretamente");
		document.formusuario.datanascimento.focus();
		return false;
	}
	if (resposta.length > 29){
		alert("- Preencha o campo data corretamente");
		document.formusuario.datanascimento.focus();
		return false;
	}
}
