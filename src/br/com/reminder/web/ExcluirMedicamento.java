package br.com.reminder.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.remider.BO.MedicamentoBO;
import br.com.remider.excecao.Excecao;


@WebServlet("/ExcluirMedicamento")
public class ExcluirMedicamento extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			
			int codigo = Integer.parseInt(req.getParameter("codigo"));
			
			if(MedicamentoBO.procurarPorCodigo(codigo).getCodigo() == 0) {
				resp.sendRedirect("ListaMedicamentos");
			}else {			
			MedicamentoBO.apagarMedicamento(codigo);
			resp.sendRedirect("ListaMedicamentos");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}
	
	
	
	
	}	
}
