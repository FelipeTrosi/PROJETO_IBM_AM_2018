package br.com.reminder.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.remider.BO.UsoMedicamentoBO;
import br.com.remider.excecao.Excecao;

@WebServlet("/ListaUsoMedicamento")
public class ListaUsoMedicamento extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			List listaDeUsoMedicamentos = UsoMedicamentoBO.listarUsoMedicamentos();
			
			req.setAttribute("sessaoListaUsoMedicamento", listaDeUsoMedicamentos);
			
			RequestDispatcher rd = req.getRequestDispatcher("telaUsoMedicamento.jsp");
			rd.forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}
		
		
	}

}
