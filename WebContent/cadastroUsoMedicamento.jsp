<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  
 <% 
	 if(session.getAttribute("username") == null){
		 
		 response.sendRedirect("Logout");
	 }
%>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no">
    <title>Página principal</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
    <link rel="stylesheet" href="css/estilo.css">
    <script type="text/javascript" src="js/validarCadastroUsoMedicamento.js"></script>
	

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
                  <a class="nav-link" href="tela.jsp"><i class="fas fa-heartbeat"></i> Página inicial</a>
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
            <div class="content-left" >
              <img class="img-home1337"src="img/tarjas.png" >
            </div>
            <div class="container col-md-5 mt-5" >
              
              
              
              
              <form method="POST" action="CadastroUsoMedicamento" name="formusomedicamento">
              
              

                <div class="form-group row" style="margin-bottom:5px;">
                  <label for="inputEmail3" class="col-sm-3 col-form-label"style="font-size:14px; padding:0;">Código do medicamento :</label>
                  <div class="col-sm-9">
                    <input type="number" class="form-control" id="inputEmail3" placeholder="Código do Medicamento" name="codMed">
                  </div>
                </div>

                <div class="form-group row" style="margin-bottom:5px;">
                  <label for="inputEmail3" class="col-sm-3 col-form-label"style="font-size:14px; padding:0;">Codigo do Usuario:</label>
                  <div class="col-sm-9">
                    <input type="number" class="form-control" id="inputEmail3" placeholder="Código do usuário" name="codUsuario">
                  </div>
                </div>              
                
                <div class="form-group row" style="margin-bottom:4px;">
                  <label for="inputPassword3" class="col-sm-3 col-form-label"style="font-size:14px; padding:0;">Data inicio:</label>
                  <div class="col-sm-9">
                  <input type="date" class="form-control" id="inputPassword3"  name="dataInicio">
                  </div>
                </div>
                
                 <div class="form-group row" style="margin-bottom:4px;">
                  <label for="inputPassword3" class="col-sm-3 col-form-label"style="font-size:14px; padding:0;">Data termino:</label>
                  <div class="col-sm-9">
                  <input type="date" class="form-control" id="inputPassword3"  name="dataTermino">
                  </div>
                </div>

                <div class="form-group row mt-5" style="margin-bottom:4px;">
                  <div class="col-sm-12">
                    <input onclick="return validar_cadastro_usomedicamento()"type="submit" class="btn btn-outline-info btn-block" value="Cadastrar" />
                  </div>
                </div>
                
                
              </form>
              </div>
            
        </div>
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