package br.com.remider.controller.MEDICAMENTO;

import br.com.remider.BO.MedicamentoBO;
import br.com.remider.beans.Medicamento;
import br.com.remider.excecao.Excecao;
import br.com.reminder.view.Magica;

public class TesteAtualizarMedicamento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			new MedicamentoBO();
			System.out.println(MedicamentoBO.atualizarMedicamento(new Medicamento(Magica.inteiro("Codigo"), 
																					 Magica.texto("Nome"), 
																					 Magica.texto("Nome Ficticio"), 
																					 Magica.inteiro("Quantidade Medicamento"),
																					 Magica.texto("Descrição Medicamento"), 
																					 Magica.texto("Data cadastro"), 
																					 Magica.texto("Foto")
																					 
					)));	
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}
	}

}
