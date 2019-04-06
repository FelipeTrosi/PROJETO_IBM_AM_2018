package br.com.remider.controller.USOMEDICAMENTO;

import br.com.remider.BO.UsoMedicamentoBO;
import br.com.remider.excecao.Excecao;
import br.com.reminder.view.Magica;

public class TesteApagarUsoMedicamento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		
			new UsoMedicamentoBO();
			int codigo = Magica.inteiro("Digite o codigo a ser apagado");
			
			System.out.println(UsoMedicamentoBO.apagarUsoMedicamento(codigo));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}

	}

}
