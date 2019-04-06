package br.com.reminder.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.remider.BO.MedicamentoBO;
import br.com.remider.beans.Medicamento;
import br.com.remider.excecao.Excecao;

@WebServlet("/AtualizarMedicamento")
public class AtualizarMedicamento extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			int codigo = Integer.parseInt(req.getParameter("codigo"));
			String nome = req.getParameter("nome");
			String apelido = req.getParameter("apelido");
			int quantidade = Integer.parseInt(req.getParameter("quantidade"));
		    String foto = req.getParameter("foto");
			String dataCadastro = req.getParameter("dataCadastro");
			String descricao = req.getParameter("descricao");
									
		
			MedicamentoBO.atualizarMedicamento(new Medicamento(codigo,  nome, apelido, quantidade,
					descricao, dataCadastro, foto));
		
			
			resp.sendRedirect("ListaMedicamentos");

		
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println(Excecao.tratarExcecao(e));
	}
		
		
		
	}	

}
