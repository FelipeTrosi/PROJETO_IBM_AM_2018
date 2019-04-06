package br.com.reminder.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.remider.BO.UsoMedicamentoBO;
import br.com.remider.excecao.Excecao;

@WebServlet("/ExcluirUsoMedicamento")
public class ExcluirUsoMedicamento extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			
			int codigo = Integer.parseInt(req.getParameter("codUsoMed"));
			
			UsoMedicamentoBO.apagarUsoMedicamento(codigo);
			
			resp.sendRedirect("ListaUsoMedicamento");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}
	}

}
