<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<% 
	 if(session.getAttribute("username") == null){
		 
		 response.sendRedirect("login.jsp");
	 }else if(!(session.getAttribute("nivelPermissao").equals("ADMINISTRADOR"))){
		 
		 response.sendRedirect("login.jsp");
	 }
%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8" content="text/html;" http-equiv="Content-Type" >
    <meta name="viewport" content="width=device-width, user-scalable=no">
    <title>Página principal</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
    <link rel="stylesheet" href="css/estilo.css">
    <script type="text/javascript" src="js/validarCadastroUsuario2.js"></script>


  </head>
  <body>
    <header>
      <div class="menu">
        <div class="">
          <nav class="navbar navbar-expand-sm navbar-dark sticky-top">
            <a class="navbar-brand" href="index.jsp"><i class="fas fa-user-md mr-3 icon-navbar"></i>Reminder</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
              <ul class="navbar-nav">
                <li class="nav-item active">
                  <a class="nav-link" href="index.jsp"><i class="fas fa-home"></i> Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item active">
                  <a class="nav-link" href="telaAdm.jsp"><i class="fas fa-heartbeat"></i> Página Inicial</a>
                </li>
                <li class="nav-item dropdown active">
                  <a class="nav-link dropdown-toggle" href="#" id="dropDown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <i class="fas fa-pills"></i>

                    Opções
                  </a>
                  	<div class="dropdown-menu" aria-labelledby="dropDown" style="margin-left: -150px;">
    								<a class="dropdown-item" href="cadastro.jsp">Cadastrar novo Usuario</a>
    								<a class="dropdown-item" href="cadastroMedicamento.jsp">Cadastrar medicamento</a>
    								<a class="dropdown-item" href="ListaMedicamentos">Alterar medicamento</a>
    								<a class="dropdown-item" href="cadastroUsoMedicamento.jsp">Cadastrar o uso medicamento</a>
    								<a class="dropdown-item" href="ListaUsoMedicamento">Alterar uso medicamento</a>
    								<a class="dropdown-item" href="cadastroLembrete.jsp">Cadastrar lembrete</a>
    								<a class="dropdown-item" href="ListaLembretes">Alterar lembrete</a>
    								
    								<a class="dropdown-item" href="Logout">Sair</a>
    								
    							</div>
                </li>
              </ul>
            </div>
          </nav>
        </div>
      </div>
    </header>
    <main>
      <div class="container mt-5">
        <div class="content">
            
            <div  style="width:60%; padding-right:20px;">
              
              <form class="tabelaPaciente" >
					<div style="overflow-x:auto; height:400px;">
						<table id="table">
							<tr >
								
								<th>Cod:</th>
								<th>Nome:</th>
								<th>Data de nasciemnto:</th>
								<th>Sexo:</th>
								<th>Username:</th>
								<th>Senha:</th>
								<th>Nivel de permissão:</th>
								<th>Pergunta:</th>
								<th>Resposta:</th>							
							</tr>
							
							<c:forEach var="registroUsuarios" items="${sessaoListaUsuario}">
							<tr class="usuario">
								
								
								
								
								<td class="info-cod">${registroUsuarios['codigo']}</td>
								<td class="info-nome">${registroUsuarios['nome']}</td>
								<td class="info-data">${registroUsuarios['dataNascimento']}</td>
								<td class="info-sexo">${registroUsuarios['sexo']}</td>
								<td class="info-username">${registroUsuarios['username']}</td>
								<td class="info-senha">${registroUsuarios['senha']}</td>
								<td class="info-nivel">${registroUsuarios['nivelPermissao']}</td>
								<td class="info-pergunta">${registroUsuarios['pergunta']}</td>
								<td class="info-resgistro">${registroUsuarios['resposta']}</td>
		
							</tr>	
							</c:forEach>
						</table>
					</div>
				</form>      
            </div>
            
            
            <div style="margin-top:100px;">
            <!--  div class="container col-md-5 mt-5"  -->
              
               <form name="formusuario" method="POST" name="formusuario" >
                
                 <div class="form-group row" style="margin-bottom:5px;">
                  <label for="inputEmail3" class="col-sm-3 col-form-label"style="font-size:14px; padding:0;">Código:</label>
                  <div class="col-sm-9">
                    <input type="number" class="form-control" id="inputEmail3" placeholder="Código do paciente" name="codigo">
                  </div>
                </div>
                
                
                <div class="form-group row" style="margin-bottom:5px;">
                  <label for="inputEmail3" class="col-sm-3 col-form-label"style="font-size:14px; padding:0;">Nome</label>
                  <div class="col-sm-9">
                    <input type="text" name="nome" class="form-control" id="inputEmail3" placeholder="Nome completo">
                  </div>
                </div>
				
			    <div class="form-group row" style="margin-bottom:5px;">
                  <label for="inputEmail3" class="col-sm-3 col-form-label"style="font-size:14px; padding:0;">Username</label>
                  <div class="col-sm-9">
                    <input type="text" name="username" class="form-control" id="inputEmail3" placeholder="Username">
                  </div>
                </div>


                <div class="form-group row" style="margin-bottom:5px;">
                  <label for="inputPassword3" class="col-sm-3 col-form-label"style="font-size:14px; padding:0;">Senha</label>
                  <div class="col-sm-9">
                    <input type="password" name="senha" class="form-control" id="inputPassword3" placeholder="Senha">
                  </div>
                </div>






                <div class="form-group row">
                  <label for="inputPassword3" class="col-sm-3 col-form-label"style="font-size:14px; padding:0;">Data de nascimento</label>
                  <div class="col-sm-9">
                  <input type="date" name="datanascimento" class="form-control" id="inputPassword3" placeholder="Data do nascimento" onkeypress="return somenteNumeros(event)" onpaste="return false">
                  </div>
                </div>



                <div class="form-group row">
                  <label for="inputPassword3" class="col-sm-3 col-form-label"style="font-size:14px; padding:0;">Pergunta</label>
                  <div class="col-sm-9">
                    <select id="inputState" class="form-control" name="pergunta">
                      <option selected value="Escolha uma pergunta" style="font-size:14px; padding:0;">Escolha uma pergunta</option>
                      <option value="QUAL O ANIMAL DE ESTIMAÇÃO " style="font-size:14px; padding:0;">QUAL O ANIMAL DE ESTIMAÇÃO ?</option>
                      <option value="ONDE VOCÊ NASCEU ?"style="font-size:14px; padding:0;">ONDE VOCÊ NASCEU ?</option>
                      <option value="QUANTOS FILHOS VOCÊ TEM ?"style="font-size:14px; padding:0;">QUANTOS FILHOS VOCÊ TEM ?</option>
                      <option value="COR FAVORITA ?"style="font-size:14px; padding:0;">COR FAVORITA ?</option>
                      
                    </select>
                  </div>
                </div>

                <div class="form-group row">
                  <label for="inputPassword3" class="col-sm-3 col-form-label"style="font-size:14px; padding:0;">Resposta</label>
                  <div class="col-sm-9">
                  <input type="text" name="resposta" class="form-control" id="inputPassword3" placeholder="Resposta da pergunta">
                  </div>
                </div>

                <fieldset class="form-group">
                  <div class="row">
                    <legend class="col-form-label col-sm-3 pt-0"style="font-size:14px; padding:0;">Genero</legend>
                    
                    <div class="col-sm-9 row">
                      <div class="form-check ml-4">
                        <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios1" value="F" checked="checked">
                        <label class="form-check-label" for="gridRadios1">
                          <i class="fas fa-female" style="font-size: 47px;"></i>
                        </label>
                      </div>
                      <div class="form-check ml-4">
                        <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios2" value="M">
                        <label class="form-check-label" for="gridRadios2">
                          <i class="fas fa-male" style="font-size: 47px;"></i>
                        </label>
                      </div>
                    </div>
                  </div>
                </fieldset>

                <div class="form-group row mt-5">
                  <div class="col-sm-12">
                    <input type="submit" class="btn btn-warning btn-block" value="Atualizar" formaction="AtualizarUsuario" onclick="return validar_cadastro_paciente()" />
                  	<input type="submit" class="btn btn-warning btn-block" value="Deletar" formaction="DesativarUsuario" style="background-color:#ff3333; color:white;" />
                  </div>
                </div>
              </form>
              
              
            </div>
        
        </div>
        
        
        
        <!--  </div> -->
      </div>

    </main>
    <footer>
  		<div class="footer">
  			<nav class="navbar fixed-bottom navbar-light">
  			  <a class="navbar-brand" href="#"><i class="fas fa-user-md ml-3 icon-navbar"></i></a>
  			</nav>
  		</div>
  	</footer>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

  </body>
</html>

