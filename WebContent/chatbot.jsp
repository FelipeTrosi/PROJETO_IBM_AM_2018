<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="br.com.remider.beans.*" %>
<%
	Usuario user = (Usuario) session.getAttribute("usuarioLogado");

	if(user == null){
		 
		 response.sendRedirect("login.jsp");
	}
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Reminder</title>
<link rel="stylesheet" type="text/css" href="css/index.css" />
</head>
<body>
	<div class="center">
		<h2>Reminder</h2>
		<div id="textchat" class="pulse"></div>
		
		
		
		<form method="post">
			<input type="text" id="question" name="question" class="field"
				placeholder="Type your question" />
			<input type="text" name="sexo" id="sexo" style="display:none;">
			<button id="sendQuestion">Enviar</button>
		</form>
			<a href="tela.jsp" class="btn_sair"><button >Sair</button></a>
		
    		
		 
	</div>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/main.js"></script>
	<% 
		if(user != null){
	%>
	<script>
		enviarSexo("<%= user.getSexo()%>");
	</script>	
	<%
		}
	%>
</body>
</html>