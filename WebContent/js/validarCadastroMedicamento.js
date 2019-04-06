function validar_cadastro_medicamento(){
	
	var nome = document.formmedicamento.nome.value;	
	var apelido = document.formmedicamento.apelido.value;
	var quantidade = document.formmedicamento.quantidade.value;	
	var foto = document.formmedicamento.foto.value;
	var dataCadastro = document.formmedicamento.dataCadastro.value;
	var descricao = document.formmedicamento.descricao.value;
	
	

	//Validando campos obrigatórios
	if (nome == ""){
		alert("- Preencha o campo nome");
		document.formmedicamento.nome.focus();
		return false;
	}
	if (apelido == ""){
		alert("- Preencha o campo apelido");
		document.formmedicamento.apelido.focus();
		return false;
	}
	if (quantidade == ""){
		alert("- Preencha o campo quantidade");
		document.formmedicamento.quantidade.focus();
		return false;
	}		
	if (foto == ""){
		alert("- Preencha o campo foto");
		document.formmedicamento.foto.focus();
		return false;
	}
	if (dataCadastro == ""){
		alert("- Preencha o campo Data");
		document.formmedicamento.dataCadastro.focus();
		return false;
	}
	if (descricao == ""){
		alert("- Preencha o campo descricao");
		document.formmedicamento.descricao.focus();
		return false;
	}

	

	//Validando tamanhos minimos e máximos
	if (nome.length > 40 || nome.length < 2){
		alert("- Nome deve conter entre 2 e 40 caracteres");
		document.formmedicamento.nome.focus();
		return false;
	}
	
	if (apelido.length >  20 || apelido.length < 3 ){
		alert("- Apelido deve conter entre 3 e 20 caracteres");
		document.formmedicamento.apelido.focus();
		return false;
	}
	if (quantidade.length >  999 || quantidade.length < 1 ){
		alert("- Quantidade inválida");
		document.formmedicamento.quantidade.focus();
		return false;
	}

	if (dataCadastro.length > 11){
		alert("- Preencha o campo data corretamente");
		document.formmedicamento.datanascimento.focus();
		return false;
	}
	if (descricao.length > 50 || descricao.length <5){
		alert("- Preencha o campo descricao");
		document.formmedicamento.descricao.focus();
		return false;
	}
}