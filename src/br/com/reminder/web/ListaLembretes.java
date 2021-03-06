package br.com.reminder.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.remider.BO.LembreteBO;
import br.com.remider.excecao.Excecao;

@WebServlet("/ListaLembretes")
public class ListaLembretes extends HttpServlet{
 @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		
		
		List listaDeLembretes = LembreteBO.listarLembrete();
		
		req.setAttribute("sessaoListaLembrete", listaDeLembretes);
		
		RequestDispatcher rd = req.getRequestDispatcher("telaLembrete.jsp");
		rd.forward(req, resp);
		
		
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println(Excecao.tratarExcecao(e));
	}
	
}
		
}
