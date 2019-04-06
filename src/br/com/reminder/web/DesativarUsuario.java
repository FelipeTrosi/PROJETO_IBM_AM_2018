package br.com.reminder.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.remider.BO.UsuarioBO;
import br.com.remider.excecao.Excecao;

@WebServlet("/DesativarUsuario")
public class DesativarUsuario extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			
			if(!(session.getAttribute("nivelPermissao").equals("ADMINISTRADOR"))){
				
				 resp.sendRedirect("login.jsp");
			 }
			
			int codigo = Integer.parseInt(req.getParameter("codigo"));
			
			
			if(UsuarioBO.procurarPorCodigo(codigo).getCodigo() == 0) {
				resp.sendRedirect("ListaUsuarios");
			}else {
			UsuarioBO.desativarUsuario(codigo);			
			resp.sendRedirect("ListaUsuarios");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}
	}

}
