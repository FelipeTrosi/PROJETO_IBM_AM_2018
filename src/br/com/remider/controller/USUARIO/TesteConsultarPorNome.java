package br.com.remider.controller.USUARIO;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.remider.DAO.UsuarioDAO;
import br.com.remider.beans.Usuario;
import br.com.remider.excecao.Excecao;
import br.com.reminder.view.Magica;

public class TesteConsultarPorNome {

	public static void main(String[] args) {
		try {
			List<Usuario> usuarios = new ArrayList<>();
			UsuarioDAO dao = new UsuarioDAO();
			
			do {
				usuarios = dao.consultarPorNome(Magica.texto("Digite o Nome"));
				for(Usuario usu: usuarios) {
					System.out.println(usu.getAll());
				}
				
			}while(JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Pergunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)== 0);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}

	}

}
