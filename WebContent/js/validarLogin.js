function validar_login(){
	var username = document.formlogin.username.value;
	var senha   = document.formlogin.senha.value;
	
	//Campos vazios
	if(username == ""){
		alert(" - Usuario invalido")
		document.formlogin.username.focus();
		return false;
	}
	if(senha == ""){
		alert(" - Senha invalida")
		document.formlogin.senha.focus();
		return false;
	}
	

	//Tamanho dos campos

	if (username.length >  20 || username.length < 2 ){
		alert("- Usuario invalido");
		document.formlogin.username.focus();
		return false;
	}
	if (senha.length >  20 || senha.length < 2 ){
		alert("- Senha invalida");
		document.formlogin.senha.focus();
		return false;
	}


}