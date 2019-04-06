package br.com.remider.controller.USUARIO;

import br.com.remider.BO.UsuarioBO;
import br.com.remider.beans.Usuario;
import br.com.remider.excecao.Excecao;
import br.com.reminder.view.Magica;

public class TesteGravarUsuario {

	public static void main(String[] args) {
		try {
			new UsuarioBO();
			System.out.println(UsuarioBO.novoUsuario(new Usuario(Magica.inteiro("Codigo Usuario"), 
																   Magica.texto("Nome Usuario"), 
																   Magica.texto("Data nascimento"), 
																   Magica.texto("Sexo"), 
																   Magica.texto("Username"),
																   Magica.texto("Senha"),
																   Magica.texto("Nivel permissão"), 
																   Magica.texto("Pergunta"), 
																   Magica.texto("Resposta")
																   
					)));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}

	}

}
