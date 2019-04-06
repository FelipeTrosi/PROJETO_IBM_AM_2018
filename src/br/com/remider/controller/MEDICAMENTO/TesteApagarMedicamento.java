package br.com.remider.controller.MEDICAMENTO;

import br.com.remider.BO.MedicamentoBO;
import br.com.remider.excecao.Excecao;
import br.com.reminder.view.Magica;

public class TesteApagarMedicamento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new MedicamentoBO();
			System.out.println(MedicamentoBO.apagarMedicamento(Magica.inteiro("Codigo a ser apagado")));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}

	}

}
