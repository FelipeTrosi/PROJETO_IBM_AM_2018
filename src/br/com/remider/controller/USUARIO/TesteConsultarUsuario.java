package br.com.remider.controller.USUARIO;

import br.com.remider.DAO.UsuarioDAO;
import br.com.remider.beans.Usuario;
import br.com.remider.excecao.Excecao;
import br.com.reminder.view.Magica;

public class TesteConsultarUsuario {

	public static void main(String[] args) {
		
		try {
			Usuario usu = new Usuario();
			UsuarioDAO dao = new UsuarioDAO();
			usu = dao.consultarPorCodigo(Magica.inteiro("Codigo usuario"));
			System.out.println(usu.getAll());
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}


	}

}
