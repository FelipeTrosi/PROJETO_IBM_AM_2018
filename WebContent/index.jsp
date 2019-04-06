<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, user-scalable=no">
	<title>Página principal</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
	<link rel="stylesheet" href="css/estilo.css">
</head>

<body>
	<!-- HEADER
		MENU DO SITE-->
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
								<a class="nav-link" href="#"><i class="fas fa-home"></i> Home <span class="sr-only">(current)</span></a>
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

	<!-- CONTAINER
		MAIN DO SITE-->
	<main>
		<div class="conteudo-principal">
			<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
				</ol>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<div class="container">
							<div class="content">
								<div class="content-right mt-3">
									<img class="img-fluid" src="img/idos.png" alt="pc">
								</div>
								<div class="content-left">
									<h2 class="text-center text-uppercase">Idoso na era virtual.</h2>
									<p class="text-justify text-cinza">O número de idosos no Brasil cresceu 50% em uma década, afirma
									o site do Instituto Brasileiro de Geografia e Estatística (IBGE). Com o passar dos anos e com avanço da tecnologia
								que está presente no nosso dia a dia, essa população que está em grande quantidade, passou a ser vista com um detalhe
							muito maior. Atualmente grandes empresas têm desenvolvido sistemas simples e modernos com uma usabilidade melhor voltados
						 para essa população.</p>
								</div>
							</div>
						</div>
					</div>
					<div class="carousel-item">
						<div class="container">
							<div class="content">
								<div class="content-right">
									<!--<img class="img-fluid" src="https://p2.trrsf.com/image/fget/cf/940/0/images.terra.com/2017/09/04/426b805a-e034-4495-927e-2412e100ab6d.jpg" alt="pc">-->
									<canvas id="myChart" width="400" height="400"></canvas>
								</div>
								<div class="content-left">
									<div id="accordion">
										<div class="card" id="primeiro-card">
											<div class="card-header" id="headingOne">
												<h5 class="mb-0">
								        <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
								          Detalhes do Envelhecimento da população 2027
								        </button>
								      </h5>
											</div>
											<div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordion">
												<div class="card-body">Quando chegar no ano de 2027 o número de pessoas com 60 ou mais no Brasil alcançará aproximadamente 37,9 milhões.
												</div>
											</div>
										</div>
										<div class="card" id="segundo-card">
											<div class="card-header" id="headingTwo">
												<h5 class="mb-0">
								        <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
								          Detalhes do Envelhecimento da população 2017
								        </button>
								      </h5>
											</div>
											<div id="collapseTwo" class="collapse" aria-labelledby="headingtwo" data-parent="#accordion">
												<div class="card-body">No ano de 2017, o número de pessoas com 60 anos ou mais no Brasil foi de aproximadamente 26 milhões.
												</div>
											</div>
										</div>
										<div class="card" id="terceiro-card">
											<div class="card-header" id="headingThree">
												<h5 class="mb-0">
								        <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseThree" aria-expanded="true" aria-controls="collapseThree">
								          Detalhes do Envelhecimento da população 2007
								        </button>
								      </h5>
											</div>
											<div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordion">
												<div class="card-body"> No ano de 2007, o número de pessoas com 60 anos ou mais no Brasil foi de 17,4 milhões.
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="carousel-item">
						<div class="container">
							<div class="content">
								<div class="content-right">
									<img src="https://www.ibm.com/cloud-computing/bluemix/sites/default/files/assets/page/feature-cognitive_0_0.png" alt="watson services">
								</div>
								<div class="content-left">
									<p class="text-justify text-white">As vantagens do nosso sistema, é que você usuário terá uma experiência muito mais
									agradável. Uma melhor usabilidade, interface simples e dinâmica pensada e desenhada especialmente para você. Experimente essa novidade,
								é gratuito e sem propagandas.</p>
								</div>
							</div>
						</div>
					</div>
				</div>
				<a class="carousel-control-prev text-dark" href="#carouselExampleControls" role="button" data-slide="prev">
			    <span class="carousel-control-prev-icon text-dark" aria-hidden="true"></span>
			    <span class="sr-only">Previous</span>
			  </a>
				<a class="carousel-control-next text-dark" href="#carouselExampleControls" role="button" data-slide="next">
			    <span class="carousel-control-next-icon text-dark" aria-hidden="true"></span>
			    <span class="sr-only">Next</span>
			  </a>
			</div>


			<div class="sistema-info" id="sistemaInfo" style="height: auto; padding: 20px;">
				<div class=" segcontent">
					<div class="segcontent-left segcontent">
						<div class="segcontent-left">
							<div class="card-group">
							
							<img src="img/medi.png" class="img-responsive text-center img-home" alt="CADASTRAR MEDICAMENTO" >
							<!--	<i class="fas fa-capsules"></i>-->
								<!--  <p class="text-center">Cadastrar Medicamento</p>-->


							</div>
							<div class="card-group">
								<img src="img/confic.png" class="img-responsive text-center img-home2"alt="CONFIGURAÇÕES" >
								<!--<i class="fas fa-cogs"></i-->
								<!-- <p class="text-center">Configurações</p> -->

							</div>
						</div>
						<div class="segcontent-left">
							<div class="card-group">
								<img src="img/ibm.png" class="img-responsive text-center img-home3"alt="INTERAGIR COM O CHATBOT" >
								<!--<i class="fas fa-heartbeat"></i>-->
								<!-- <p class="text-center">Interagir com o Watson</p> -->

							</div>
							<div class="card-group">
								<img src="img/noti.png" class="img-responsive text-center img-home3" alt="NOTIFICAÇÕES" >
								<!--<i class="far fa-clipboard"></i>-->
								<!-- <p class="text-center">Notificações</p>-->

							</div>
						</div>
						<div class="segcontent-left">
						<div class="card-group">
							<img src="img/tarjas.png" class="img-responsive text-center img-home4" alt="HISTÓRICO MEDICAMENTO" >
							<!--<i class="far fa-clock"></i>-->
							<!-- <p class="text-center">Histórico do Medicamento</p>-->

						</div>
						<div class="card-group">
							<img src="img/interface.png" class="img-responsive text-center img-home3" alt="FUTURAS REDES SOCIAIS">
							<!--<i class="fas fa-desktop"></i>-->
							<!-- <p class="text-center">Interface Simples</p>-->

						</div>
					</div>
					<!--<div class="content-left content"-->


					</div>
				</div>
			</div>

			<!--
MODAIS
-->

			<!-- Modal -->
			<div class="modal fade" id="cadrastraRemedio" tabindex="-1" role="dialog" aria-labelledby="cadrastraRemedio" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLongTitle">Cadastrar Remedio</h5>
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						</div>
						<div class="modal-body text-justify">
							<img src="img\Novo-medicamento.png" alt="" class="modal-imagem"> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
							laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim
							id est laborum. Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
							Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
						</div>

					</div>
				</div>
			</div>



			<!---primerio MODAL--->
			<div class="sobreNos" id="sobreNos">
				<div class="jumbotron">
					<h2 class="text-center">Sobre Nós</h2>
					<p class="text-black">Olá, como vai? Somos o Developer Guys, um grupo formado por estudantes em que estudam
					Análise e Desenvolvimento de Sistemas na Faculdade de Informática e Administração Paulista (FIAP) em São Paulo.
					Por meio de um simples desafio proposto pela nossa faculdade em parceria com a IBM, uma das maiores empresas no
				  ramo da tecnologia, criamos o Reminder. Uma idéia que poderia revolucionar com um sistema de fácil interação, voltado
				  especialmente para o público idoso. Nossa proposta é que você nunca mais precisará se preocupar em lembrar de tomar medicamentos,
				  nosso sistema fará isso para você, tudo de uma maneira muito simples, sem complicação e gratuitamente. </p>
				</div>
			</div>










		</div>
	</main>
	<!-- RODAOÉ DO SITE
	CONTATO-->
	<footer>
		<div class="footer">
			<nav class="navbar fixed-bottom navbar-light">
				<a class="navbar-brand" href="#"><i class="fas fa-user-md ml-3 icon-navbar"></i></a>
			</nav>
		</div>
	</footer>


	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.bundle.js"></script>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

	<script>
		$('.carousel').carousel({
			interval: 0
		})

		var ctx = document.getElementById("myChart").getContext('2d');
		console.log(ctx)
		var myChart = new Chart(ctx, {
			type: 'pie',
			data: {
				labels: [2007, 2017, 2027],
				datasets: [{
					data: [17400000, 26000000, 37900000],
					borderColor: "#fff",
					backgroundColor: ['#6891FA', '#F8237D', '#E86464'],
					fill: false
				}]
			},
			options: {
				title: {
					display: true,
					text: 'Envelhecimento de Idosos no Brasil',
					fontSize: 25,
					fontColor: '#fff'
				},
				legend: {
					labels: {
						fontColor: 'white'
					}
				},
			}
		});
	</script>

</body>

</html>
    