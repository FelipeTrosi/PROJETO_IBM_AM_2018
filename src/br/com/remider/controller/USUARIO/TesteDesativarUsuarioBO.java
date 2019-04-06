package br.com.remider.controller.USUARIO;

import br.com.remider.BO.UsuarioBO;
import br.com.remider.excecao.Excecao;
import br.com.reminder.view.Magica;

public class TesteDesativarUsuarioBO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			int numero = Magica.inteiro("Digite o codigo do usuario:");
			System.out.println(new UsuarioBO().desativarUsuario(numero));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}
	}

}
