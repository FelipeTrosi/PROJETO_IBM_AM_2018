package br.com.reminder.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.remider.BO.LembreteBO;
import br.com.remider.beans.Lembrete;
import br.com.remider.beans.Medicamento;
import br.com.remider.beans.UsoMedicamento;
import br.com.remider.beans.Usuario;
import br.com.remider.excecao.Excecao;

@WebServlet("/CadastroLembrete")
public class CadastroLembrete extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			try {
				
				int qtdLembrete = Integer.parseInt(req.getParameter("qtdLembrete"));
				String alarme = req.getParameter("alarme");
				int codUsoMed = Integer.parseInt(req.getParameter("codUsoMed"));
				
				
				
				LembreteBO.gravarLembrete(new Lembrete(LembreteBO.adicioarUltimoId(), qtdLembrete, alarme, 
						new UsoMedicamento(codUsoMed)		
						));	
				
				
					resp.sendRedirect("cadastroLembrete.jsp");
				
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(Excecao.tratarExcecao(e));
			}
		

	}
	

}
