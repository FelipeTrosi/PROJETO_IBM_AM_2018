package br.com.reminder.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.remider.BO.LembreteBO;
import br.com.remider.excecao.Excecao;

@WebServlet("/ExcluirLembrete")
public class ExcluirLembrete extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		
		int codLembrete = Integer.parseInt(req.getParameter("codLembrete"));
		
		LembreteBO.apagarLembrete(codLembrete);
		
		resp.sendRedirect("ListaLembretes");
		
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println(Excecao.tratarExcecao(e));
	}
			
	}
	
}
