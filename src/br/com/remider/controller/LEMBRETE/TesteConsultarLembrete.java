package br.com.remider.controller.LEMBRETE;

import br.com.remider.BO.LembreteBO;
import br.com.remider.beans.Lembrete;
import br.com.remider.excecao.Excecao;
import br.com.reminder.view.Magica;

public class TesteConsultarLembrete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Lembrete lembrete = new Lembrete();
			new LembreteBO();
			lembrete = LembreteBO.procurarPorCodigoLembrete(Magica.inteiro("Codigo a ser buscado"));
			
			if(lembrete.getCodigo() > 0) {
				System.out.println(lembrete.getResumo());
			}else {
				System.out.println("Lembrete não encontrado");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}
	}

}
