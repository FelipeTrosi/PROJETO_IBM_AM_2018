package br.com.remider.BO;

import java.util.ArrayList;
import java.util.List;

import br.com.remider.DAO.LembreteDAO;
import br.com.remider.DAO.UsoMedicamentoDAO;
import br.com.remider.beans.Lembrete;
import br.com.remider.beans.UsoMedicamento;

/**
 * Essa classe manipula a tabela T_RMD_USUARIO
 * Possui métodos para: Cadastrar, Consultar, Alterar e Excluir 
 * @author Luan Ferreira Mendes
 * @version 1.0
 * @since 1.0
 * @see LembreteBO
 * @see Lembrete
 * @see LembreteDAO
 */

public class LembreteBO {
	
	
	public static List<Lembrete> listarLembrete()throws Exception {
		LembreteDAO dao = new LembreteDAO();
		List<Lembrete> Lembrete = new ArrayList<>();
		
		Lembrete = dao.listaLembretes();
		dao.fechar();
		return Lembrete;		
		
	}
	
	
	
	
	/**
	 * Responsável por adicionar dados na tabela T_RMD_LEMBRETE e validar seus campos
	 * @param lembrete
	 * @return Uma string com a mensagem de confirmação
	 * @throws Exception chamada de Excecao checked
	 * @author Luan F. Mendes 
	 */
	public static String gravarLembrete(Lembrete lembrete)throws Exception {
		//Validação
		if(lembrete.getQuantidadeLembretes() > 99) {
			return "Quantidade inválida"; 
		}
		
		UsoMedicamentoDAO UsoMedDao = new UsoMedicamentoDAO();
		UsoMedicamento uso = new UsoMedicamento();
		uso = UsoMedDao.consultarPorCodigo(lembrete.getUsoMedicamento().getCodigo());
		if(uso.getCodigo() == 0) {
			UsoMedDao.fechar();
			return "Uso de Medicamento não encontrado";
		}
		
	LembreteDAO dao = new LembreteDAO();
	Lembrete resultado = dao.consultarPorCodigo(lembrete.getCodigo());
	if(resultado.getCodigo() > 0) {
		dao.fechar();
		return "Lembrete já cadastrado";
	}
	
	String x = dao.gravar(lembrete);
	dao.fechar();
	return x;
		
	}
	
	/**
	 * Responsável por atualizar um lembrete ja cadastrado na tabela T_RMD_LEMBRETE e validar seus campos
	 * @param lembrete
	 * @return numero de lembretes atualizados
	 * @throws Exception chamada de Excecao checked
	 * @author Luan F. Mendes
	 */
	
	public static int atualizarLembrete(Lembrete lembrete)throws Exception {
		LembreteDAO dao = new LembreteDAO();
		Lembrete resultado = dao.consultarPorCodigo(lembrete.getCodigo());
		if(resultado == null) {
			return 0;
		}
		if(lembrete.getQuantidadeLembretes() > 99) {
			return 0; 
		}
		
		UsoMedicamentoDAO UsoMedDao = new UsoMedicamentoDAO();
		UsoMedicamento uso = new UsoMedicamento();
		uso = UsoMedDao.consultarPorCodigo(lembrete.getUsoMedicamento().getCodigo());
		if(uso.getCodigo() == 0) {
			UsoMedDao.fechar();
			return 0;
		}
		
		int x = dao.atualizar(lembrete);
		dao.fechar();
		return x;
		
	}
	
	/**
	 * Responsável por pesquisar dados na tabela T_RMD_LEMBRETE através do seu codigo
	 * @param codigo
	 * @return retornar todos os dados da tabela do codigo digitado
	 * @throws Excepetion chamada de Excecao checked
	 * @author Luan F. Mendes
	 */
	
	public static Lembrete procurarPorCodigoLembrete(int codigo)throws Exception {
		LembreteDAO dao = new LembreteDAO();
		Lembrete lembrete = new Lembrete();
		
		lembrete = dao.consultarPorCodigo(codigo);
		
		dao.fechar();
		return lembrete;
	}
	
	/**
	 * Responsável por pesquisar o ultimo id cadastrado na tabela T_RMD_LEMBRETE
	 * @param não há parametros
	 * @return o proximo id a ser cadastrado
	 * @throws Exception chamada de Excecao checked
     * @author Luan F. Mendes 
	 */
	
	public static int adicioarUltimoId() throws Exception {
		LembreteDAO dao = new LembreteDAO();
		int ultimo = dao.ultimoLembrete();
		
		dao.fechar();
		return ultimo;
	}
	
	/**
	 * Responsável por excluir um lembrete da tabela T_RMD_LEMREBTE
	 * @param codigo
	 * @return número de linhas excluidas
	 * @throws Exception chamada de Excecao checked
	 * @author Luan F. Mendes
	 */	
	
	public static int apagarLembrete(int codigo)throws Exception {
		LembreteDAO dao = new LembreteDAO();
		
		int x = dao.apagar(codigo);
		dao.fechar();
		return x;
	}
}
