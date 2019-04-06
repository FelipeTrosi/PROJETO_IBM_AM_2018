<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no">
    <title>Página principal</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
    <link rel="stylesheet" href="css/estilo.css">
	<script type="text/javascript" src="js/validarCadastroUsuario.js"></script>

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
                  <a class="nav-link" href="#sobreNos"><i class="fas fa-heartbeat"></i> Sobre nós</a>
                </li>
                <li class="nav-item dropdown active">
                  <a class="nav-link dropdown-toggle" href="#" id="dropDown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <i class="fas fa-pills"></i>

                    Entrar
                  </a>
                  <div class="dropdown-menu" aria-labelledby="dropDown" style="margin-left: -150px;">
                    <a class="dropdown-item" href="login.jsp"><i class="fas fa-user-md">&nbsp;&nbsp;</i>Fazer login</a>
                    <a class="dropdown-item" href="cadastro.jsp"><i class="fas fa-notes-medical"></i>&nbsp;&nbsp;Cadastrarse</a>
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
            <div class="content-left">
              <img src="img/cuidador.png" alt="" class="imagem_login">
            </div>
            <div class="container col-md-5 mt-5">
              
              
              <form name="formusuario" method="POST" action="CadastroPaciente" >
                
                <div class="form-group row" style="margin-bottom:5px;">
                  <label for="inputEmail3" class="col-sm-3 col-form-label">Nome</label>
                  <div class="col-sm-9">
                    <input type="text" name="nome" class="form-control" id="inputEmail3" placeholder="Nome completo">
                  </div>
                </div>
				
			    <div class="form-group row" style="margin-bottom:5px;">
                  <label for="inputEmail3" class="col-sm-3 col-form-label">Username</label>
                  <div class="col-sm-9">
                    <input type="text" name="username" class="form-control" id="inputEmail3" placeholder="Username">
                  </div>
                </div>


                <div class="form-group row" style="margin-bottom:5px;">
                  <label for="inputPassword3" class="col-sm-3 col-form-label">Senha</label>
                  <div class="col-sm-9">
                    <input type="password" name="senha" class="form-control" id="inputPassword3" placeholder="Senha">
                  </div>
                </div>






                <div class="form-group row" style="margin-bottom:5px;">
                  <label for="inputPassword3" class="col-sm-3 col-form-label">Data de nascimento</label>
                  <div class="col-sm-9">
                  <input type="date" name="datanascimento" class="form-control" id="inputPassword3" placeholder="Data do nascimento" onkeypress="return somenteNumeros(event)" onpaste="return false">
                  </div>
                </div>



                <div class="form-group row" style="margin-bottom:5px;">
                  <label for="inputPassword3" class="col-sm-3 col-form-label">Pergunta</label>
                  <div class="col-sm-9">
                    <select id="inputState" class="form-control" name="pergunta">
                      <option selected value="Escolha uma pergunta" >Escolha uma pergunta</option>
                      <option value="QUAL O ANIMAL DE ESTIMAÇÃO " >QUAL O ANIMAL DE ESTIMAÇÃO ?</option>
                      <option value="ONDE VOCÊ NASCEU ?">ONDE VOCÊ NASCEU ?</option>
                      <option value="QUANTOS FILHOS VOCÊ TEM ?">QUANTOS FILHOS VOCÊ TEM ?</option>
                      <option value="COR FAVORITA ?">COR FAVORITA ?</option>
                      
                    </select>
                  </div>
                </div>

                <div class="form-group row" style="margin-bottom:5px;">
                  <label for="inputPassword3" class="col-sm-3 col-form-label">Resposta</label>
                  <div class="col-sm-9">
                  <input type="text" name="resposta" class="form-control" id="inputPassword3" placeholder="Resposta da pergunta">
                  </div>
                </div>

                <fieldset class="form-group">
                  <div class="row">
                    <legend class="col-form-label col-sm-3 pt-0">Genero</legend>
                    
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
                    <input onclick="return validar_cadastro_paciente()" type="submit" value="Cadastrar" class="btn btn-info btn-block"  />
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
    