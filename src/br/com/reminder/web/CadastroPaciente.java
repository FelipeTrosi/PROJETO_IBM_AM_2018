package br.com.reminder.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.remider.BO.UsuarioBO;
import br.com.remider.beans.Usuario;
import br.com.remider.excecao.Excecao;

@WebServlet("/CadastroPaciente")
public class CadastroPaciente extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			
			String nome = req.getParameter("nome").toUpperCase();			
			String username = req.getParameter("username").toUpperCase();
			String senha = req.getParameter("senha").toUpperCase();
			String dataNascimento = req.getParameter("datanascimento").toUpperCase();
			String pergunta = req.getParameter("pergunta").toUpperCase();
			String resposta = req.getParameter("resposta").toUpperCase();
			String sexo = req.getParameter("gridRadios").toUpperCase();
		
			
			
			
			 UsuarioBO.novoUsuario(new Usuario(UsuarioBO.adicioarUltimoId(),nome, dataNascimento,  sexo,  username, senha,
			 "USUARIO",  pergunta,  resposta));		

				
		
			resp.sendRedirect("cadastro.jsp");
		
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}	
		
	}

}
