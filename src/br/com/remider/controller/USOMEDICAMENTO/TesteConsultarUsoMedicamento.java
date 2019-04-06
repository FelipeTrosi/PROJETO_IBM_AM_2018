package br.com.remider.controller.USOMEDICAMENTO;

import br.com.remider.BO.UsoMedicamentoBO;
import br.com.remider.beans.UsoMedicamento;
import br.com.remider.excecao.Excecao;
import br.com.reminder.view.Magica;

public class TesteConsultarUsoMedicamento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			UsoMedicamento uso = new UsoMedicamento();
			new UsoMedicamentoBO();
			
			uso = UsoMedicamentoBO.procurarPorCodigo(Magica.inteiro("Codigo a ser buscado"));
			
			if(uso.getCodigo() > 0) {
				System.out.println(uso.getResumo());
			}else{
				System.out.println("Não cadastrado");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}

	}

}
