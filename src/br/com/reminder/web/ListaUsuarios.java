package br.com.reminder.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.remider.BO.MedicamentoBO;
import br.com.remider.BO.UsuarioBO;
import br.com.remider.excecao.Excecao;

@WebServlet("/ListaUsuarios")
public class ListaUsuarios extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {	


			HttpSession session = req.getSession();

			if(session.getAttribute("nivelPermissao") == null || session.getAttribute("usuarioLogado") == null){

				resp.sendRedirect("login.jsp");
			}else {
				if(!(session.getAttribute("nivelPermissao").equals("ADMINISTRADOR"))) {
					resp.sendRedirect("login.jsp");
				}else {
					List listaDeUsuarios = UsuarioBO.listarUsuarios();

					req.setAttribute("sessaoListaUsuario", listaDeUsuarios);

					RequestDispatcher rd = req.getRequestDispatcher("telaConfiguracoesPerfil.jsp");
					rd.forward(req, resp);
				}
			}




		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}
	}

}