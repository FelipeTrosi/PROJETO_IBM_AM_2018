package br.com.remider.controller.LEMBRETE;

import br.com.remider.BO.LembreteBO;
import br.com.remider.excecao.Excecao;
import br.com.reminder.view.Magica;

public class TesteApagarLembrete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			new LembreteBO();
			int codigo = Magica.inteiro("Digite o codigo a ser apagado");
			
			System.out.println(LembreteBO.apagarLembrete(codigo));
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}
	}

}
