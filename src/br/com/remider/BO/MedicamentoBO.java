package br.com.remider.BO;

import java.util.ArrayList;
import java.util.List;

import br.com.remider.DAO.MedicamentoDAO;
import br.com.remider.beans.Medicamento;
/**
 * Essa classe manipula a tabela T_RMD_USUARIO
 * Possui métodos para: Cadastrar, Consultar, Alterar e Excluir 
 * @author Luan Ferreira Mendes
 * @version 1.0
 * @since 1.0
 * @see MedicamentoBO
 * @see Medicamento
 * @see MedicamentoDAO
 */
public class MedicamentoBO {
	
	public static int adicioarUltimoId() throws Exception {
		MedicamentoDAO dao = new MedicamentoDAO();
		int ultimo = dao.ultimoMedicamento();
		
		dao.fechar();
		return ultimo;
	}
	
	
	public static List<Medicamento> listarMedicamentos()throws Exception{
		MedicamentoDAO dao = new MedicamentoDAO();
		List<Medicamento> medicamento = new ArrayList<>();
		
		medicamento = dao.listaDeMedicamentos();
		dao.fechar();
		return medicamento;
	}
	
	
	/**
	 * Responsável por adicionar dados na tabela T_RMD_MEDICAMENTO e validar seus campos
	 * @param medicamento
	 * @return Uma string com a mensagem de confirmação
	 * @throws Exception chamada de Excecao checked
	 * @author Luan F. Mendes 
	 */
	
	public static String gravarMedicamento(Medicamento medicamento)throws Exception{
		//Validação
		if(medicamento.getNomeMedicamento().length() > 40) {
			return "Nome Longo";
		}
		if(medicamento.getNomeFicticio().length() > 20) {
			return "Nome Ficticio longo";
		}
		if(medicamento.getQuantidadeMedicamento() > 9999) {
			return "Quantidade inválida";
		}
		if(medicamento.getDescricaoMedicamento().length() > 50) {
			return "Descrição longa";
		}
		if(medicamento.getFoto().length() > 40) {
			return "Foto inválida";
		}
		
		//Padronização
		medicamento.setNomeFicticio(medicamento.getNomeMedicamento().toUpperCase());
		medicamento.setNomeFicticio(medicamento.getNomeFicticio().toUpperCase());
		medicamento.setDescricaoMedicamento(medicamento.getDescricaoMedicamento().toUpperCase());
		
		MedicamentoDAO dao = new MedicamentoDAO();
		Medicamento resultado = dao.consultarPorCodigo(medicamento.getCodigo());
		if(resultado.getCodigo() > 0) {
			dao.fechar();
			return "Medicamento já existe";
		}
		
		String x = dao.gravar(medicamento);
		dao.fechar();
		return x;
	}
	
	/**
	 * Responsável por atualizar um medicamento ja cadastrado na tabela T_RMD_MEDICAMENTO e validar seus campos
	 * @param medicamento
	 * @return numero de medicamentos atualizados
	 * @throws Exception chamada de Excecao checked
	 * @author Luan F. Mendes
	 */
	
	public static int atualizarMedicamento(Medicamento medicamento)throws Exception {
		MedicamentoDAO dao = new MedicamentoDAO();
		Medicamento resultado = dao.consultarPorCodigo(medicamento.getCodigo());
		if(resultado == null) {
			return 0;
		}
		if(medicamento.getNomeMedicamento().length() > 40) {
			return 0;
		}
		if(medicamento.getNomeFicticio().length() > 20) {
			return 0;
		}
		if(medicamento.getQuantidadeMedicamento() > 9999) {
			return 0;
		}
		if(medicamento.getDescricaoMedicamento().length() > 50) {
			return 0;
		}
		if(medicamento.getFoto().length() > 40) {
			return 0;
		}
		
		//Padronização
		medicamento.setNomeFicticio(medicamento.getNomeMedicamento().toUpperCase());
		medicamento.setNomeFicticio(medicamento.getNomeFicticio().toUpperCase());
		medicamento.setDescricaoMedicamento(medicamento.getDescricaoMedicamento().toUpperCase());
		
		int x = dao.atualizar(medicamento);
		dao.fechar();
		return x;
		
		
	}
	
	/**
	 * Responsável por pesquisar dados na tabela T_RMD_MEDICAMENTO através do seu codigo
	 * @param codigo
	 * @return retornar todos os dados da tabela do codigo digitado
	 * @throws Excepetion chamada de Excecao checked
	 * @author Luan F. Mendes
	 */
	
	public static Medicamento procurarPorCodigo(int codigo)throws Exception{
		MedicamentoDAO dao = new MedicamentoDAO();
		Medicamento medicamento = new Medicamento();
		
		medicamento = dao.consultarPorCodigo(codigo);
		dao.fechar();
		return medicamento;
				
	}
	
	/**
	 * Responsavel por listar todos os medicamentos da tabela T_RMD_USUARIO que tem o mesmo nome
	 * @param nome
	 * @return todos os medicamentos com o mesmo nome
	 * @throws Exception chamada de Excecao checked
	 * @author Luan F. Mendes
	 */
	
	public static List<Medicamento> procurarPorNome(String nome)throws Exception{
		MedicamentoDAO dao = new MedicamentoDAO();
		List<Medicamento> medicamento = new ArrayList<>();
		
		medicamento = dao.consultarPorNome(nome);
		dao.fechar();
		return medicamento;
	}
	
	/**
	 * Responsável por excluir um usuario da tabela T_RMD_MEDICAMENTO
	 * @param codigo
	 * @return número de linhas excluidas
	 * @throws Exception chamada de Excecao checked
	 * @author Luan F. Mendes
	 */	
	
	public static int apagarMedicamento(int codigo)throws Exception{
		MedicamentoDAO dao = new MedicamentoDAO();
		
		int x = dao.apagar(codigo);
		dao.fechar();
		return x;
	}
}
