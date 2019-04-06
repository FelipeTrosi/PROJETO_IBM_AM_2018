<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
								<a class="dropdown-item" href="cadastro.jsp"><i class="fas fa-notes-medical">&nbsp;&nbsp;</i>Cadastrarse</a>
							</div>
						</li>
					</ul>
				</div>
			</nav>
		</div>
	</div>
</header>

<div class="">

<aside>

	<div class="container mt-5">
		<div class="content">
				<div class="content-left">
					<img src="img/idosos.png" alt="" class="imagem_login">
				</div>
				<div class="content-right">
					
					<form name="formlogin" action="Usuario" method="POST">
						<div class="form-group row">
							<label for="inputEmail3" class="col-sm-3 col-form-label">Username</label>
							<div class="col-sm-9">
								<input name="username" type="text" class="form-control" id="inputEmail3" placeholder="Username">
							</div>
						</div>


						<div class="form-group row">
							<label   for="inputPassword3" class="col-sm-3 col-form-label">Senha</label>
							<div class="col-sm-9">
								<input name="senha" type="password" class="form-control" id="inputPassword3" placeholder="Senha">
							</div>
						</div>

						<a href="redefinir.jsp"	>Esqueci minha senha.</a>

						<div class="form-group row mt-5">
							<div class="col-sm-12">
								<input type="submit" class="btn btn-info btn-block" value="Entrar" onclick="return validar_login()"/>
							</div>
						</div>
					</form>
				</div>
		</div>
	</div>

</aside>
<script type="text/javascript" src="js/validarLogin.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

  </body>
</html>
    