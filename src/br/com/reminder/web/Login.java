package br.com.reminder.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.remider.BO.UsuarioBO;
import br.com.remider.beans.Usuario;
import br.com.remider.excecao.Excecao;

@WebServlet("/Usuario")
public class Login extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String username = req.getParameter("username").toUpperCase();
			String senha = req.getParameter("senha");
			HttpSession session = req.getSession();
			
			
			Usuario usuario = UsuarioBO.autenticarProLogin(username, senha);	

			if(usuario.getUsername() != null && usuario.getNivelPermissao().equals("USUARIO")) {
				
				//Nivel permissão
				session.setAttribute("nivelPermissao", usuario.getNivelPermissao());
				
				//NOME
				session.setAttribute("username", username);
				
				//SEXO
				session.setAttribute("sexo", usuario.getSexo());
				
				session.setAttribute("usuarioLogado", usuario);
				
				req.getRequestDispatcher("tela.jsp").forward(req, resp);
				
			}else if(usuario.getUsername() != null && usuario.getNivelPermissao().equals("ADMINISTRADOR")){
				
				//SEXO
				session.setAttribute("sexo", usuario.getSexo());
				
				//Nivel permissão
				session.setAttribute("nivelPermissao", usuario.getNivelPermissao());
				
				//OBJ 
				session.setAttribute("usuarioLogado", usuario);
				
				//NOME
				session.setAttribute("username", username);											
				req.getRequestDispatcher("telaAdm.jsp").forward(req, resp);
				
				
			}else {
				
				resp.sendRedirect("login.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}
		
		

		
	}
}
