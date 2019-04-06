package br.com.remider.controller.MEDICAMENTO;

import br.com.remider.DAO.MedicamentoDAO;
import br.com.remider.beans.Medicamento;
import br.com.remider.excecao.Excecao;
import br.com.reminder.view.Magica;

public class TesteConsultarMedicamento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Medicamento medicamento = new Medicamento();
			MedicamentoDAO dao = new MedicamentoDAO();
			
			medicamento = dao.consultarPorCodigo(Magica.inteiro("Codigo a ser buscado"));
			System.out.println(medicamento.getAll());
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}

	}

}
