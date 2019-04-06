<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.remider.beans.*" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">

<% 
	 if(((Usuario) session.getAttribute("usuarioLogado")) == null){
		 
		 response.sendRedirect("login.jsp");
	 }
%>

<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, user-scalable=no">
	<title>Página principal</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
	<link rel="stylesheet" href="css/estilo.css">
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

<div class="container" >
  <div class="col-md-12 mt-5">
    <div class="row text-center">
      <div class="col-md-5 mr-5">
        <a href="#" class="link-home">
          <div class="card">
            <img src="img/Novo-medicamento.png" alt="" width="100%">
            <div class="card-body">
              <a href="cadastroMedicamento.jsp" class="btn btn-primary btn-block">Cadastrar medicamento</a>
            </div>
          </div>
        </a>
      </div>



      <div class="col-md-6 ml-4">
        <a href="#" class="link-home">
          <div class="card">
            <img src="img/ibm.png" alt="" width="70%">
            <div class="card-body">
              <a href="chatbot.jsp" class="btn btn-primary btn-block">Interagir com o chatbot</a>
            </div>
          </div>
        </a>
      </div>
    </div>
  </div>
</div>


</main>
<footer>
  <div class="footer" style="padding-top:20%;">
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
    