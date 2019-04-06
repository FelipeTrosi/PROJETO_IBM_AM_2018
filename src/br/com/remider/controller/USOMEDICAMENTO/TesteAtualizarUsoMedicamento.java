package br.com.remider.controller.USOMEDICAMENTO;

import br.com.remider.BO.UsoMedicamentoBO;
import br.com.remider.beans.Medicamento;
import br.com.remider.beans.UsoMedicamento;
import br.com.remider.beans.Usuario;
import br.com.remider.excecao.Excecao;
import br.com.reminder.view.Magica;

public class TesteAtualizarUsoMedicamento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			new UsoMedicamentoBO();
			System.out.println(UsoMedicamentoBO.alterarUsoMedicamento(new UsoMedicamento(Magica.inteiro("Codigo"), 
																							  new Usuario(Magica.inteiro("Codigo Usuario")), 
																							  new Medicamento(Magica.inteiro("Codigo Medicamento")), 
																							  Magica.texto("Data inicio"), 
																							  Magica.texto("Data Termino")
																							  
					)));
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}
	}

}
