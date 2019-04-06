package br.com.remider.controller.MEDICAMENTO;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.remider.DAO.MedicamentoDAO;
import br.com.remider.beans.Medicamento;
import br.com.remider.excecao.Excecao;
import br.com.reminder.view.Magica;

public class TesteConsultarMedicamentoNome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			List<Medicamento> medicamentos = new ArrayList<>();
			MedicamentoDAO dao = new MedicamentoDAO();
			
			do {
				medicamentos = dao.consultarPorNome(Magica.texto("Digite o Nome"));
				for(Medicamento med: medicamentos) {
					System.out.println(med.getAll());
				}
				
			}while(JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Pergunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)== 0);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		}

	}

}
