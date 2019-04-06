package br.com.reminder.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.remider.BO.UsoMedicamentoBO;
import br.com.remider.beans.Medicamento;
import br.com.remider.beans.UsoMedicamento;
import br.com.remider.beans.Usuario;
import br.com.remider.excecao.Excecao;

@WebServlet("/AtualizarUsoMedicamento")
public class AtualizarUsoMedicamento extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			int codUsoMed = Integer.parseInt(req.getParameter("codUsoMed"));
			int codMed = Integer.parseInt(req.getParameter("codMed"));
			int codUsuario = Integer.parseInt(req.getParameter("codUsuario"));		
			String dataInicio = req.getParameter("dataInicio");
			String dataTermino = req.getParameter("dataTermino");
			
			UsoMedicamentoBO.alterarUsoMedicamento(new UsoMedicamento(codUsoMed,
									new Usuario(codUsuario),new Medicamento(codMed),dataInicio,dataTermino));
			
			
			
				resp.sendRedirect("ListaUsoMedicamento");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}
		
	}

}
