package br.com.remider.controller.LEMBRETE;

import br.com.remider.BO.LembreteBO;
import br.com.remider.beans.Lembrete;
import br.com.remider.beans.Medicamento;
import br.com.remider.beans.UsoMedicamento;
import br.com.remider.beans.Usuario;
import br.com.remider.excecao.Excecao;
import br.com.reminder.view.Magica;

public class TesteAtualizarLembrete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new LembreteBO();
			System.out.println(LembreteBO.atualizarLembrete(new Lembrete(Magica.inteiro("Codigo lembrete"), 
					 														 Magica.inteiro("Quantidade Lembrete"), 
					 														 Magica.texto("Alarme"), 
					 														 new UsoMedicamento(Magica.inteiro("Codigo do uso"), 
					 																 			new Usuario(Magica.inteiro("Codigo do usuario")), 
					 																 			new Medicamento(Magica.inteiro("Codigo do medicamento")), 
					 																 			Magica.texto("Data inicio"), 
					 																 			Magica.texto("Data Termino"))
					 														
					 )));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}

	}

}
