package br.com.remider.BO;

import java.util.ArrayList;
import java.util.List;

import br.com.remider.DAO.MedicamentoDAO;
import br.com.remider.DAO.UsoMedicamentoDAO;
import br.com.remider.DAO.UsuarioDAO;
import br.com.remider.beans.Medicamento;
import br.com.remider.beans.UsoMedicamento;
import br.com.remider.beans.Usuario;
/**
 * Essa classe manipula a tabela T_RMD_USOMEDICAMENTO
 * Possui m�todos para: Cadastrar, Consultar, Alterar e Excluir 
 * @author Luan Ferreira Mendes
 * @version 1.0
 * @since 1.0
 * @see UsoMedicamentoBO
 * @see UsoMedicamento
 * @see UsoMedicamentoDAO
 */
public class UsoMedicamentoBO {
	
	
	
	public static List<UsoMedicamento> listarUsoMedicamentos()throws Exception {
		UsoMedicamentoDAO dao = new UsoMedicamentoDAO();
		List<UsoMedicamento> usoMedicamento = new ArrayList<>();
		
		usoMedicamento = dao.listaUsoMedicamentos();
		dao.fechar();
		return usoMedicamento;		
		
	}
	
	/**
	 * Respons�vel por adicionar dados na tabela T_RMD_USOMEDICAMENTO e validar seus campos
	 * @param uso
	 * @return Uma string com a mensagem de confirma��o
	 * @throws Exception chamada de Excecao checked
	 * @author Luan F. Mendes 
	 */
	
	public static String gravarUsoMedicamento(UsoMedicamento uso)throws Exception{
		UsoMedicamentoDAO dao = new UsoMedicamentoDAO();
		UsoMedicamento resultado = dao.consultarPorCodigo(uso.getCodigo());
		
		if(resultado.getCodigo() > 0) {
			dao.fechar();
			return "Uso de medicamento j� existe";
		}
		MedicamentoDAO medDao = new MedicamentoDAO();
		Medicamento medicamento = new Medicamento();
		medicamento = medDao.consultarPorCodigo(uso.getMedicamento().getCodigo());
		
		if(medicamento.getCodigo() == 0) {
			medDao.fechar();
			return "Medicamento n�o cadastrado";
		}
		
		UsuarioDAO usuDao = new UsuarioDAO();
		Usuario usuario = new Usuario();
		usuario = usuDao.consultarPorCodigo(uso.getUsuario().getCodigo());
		
		if(usuario.getCodigo() == 0) {
			usuDao.fechar();
			return "Usu�rio n�o cadastrado";
		}
		
		String x = dao.gravar(uso);
		dao.fechar();
		return x;
	}
	
	/**
	 * Respons�vel por atualizar um uso de medicamento ja cadastrado na tabela T_RMD_USOMEDICAMENTO e validar seus campos
	 * @param uso
	 * @return numero de medicamentos atualizados
	 * @throws Exception chamada de Excecao checked
	 * @author Luan F. Mendes
	 */
	
	public static int alterarUsoMedicamento(UsoMedicamento uso)throws Exception {
		UsoMedicamentoDAO dao = new UsoMedicamentoDAO();
		UsoMedicamento resultado = dao.consultarPorCodigo(uso.getCodigo());
		
		if(resultado == null) {
			return 0;
		}
		MedicamentoDAO medDao = new MedicamentoDAO();
		Medicamento medicamento = new Medicamento();
		medicamento = medDao.consultarPorCodigo(uso.getMedicamento().getCodigo());
		
		if(medicamento.getCodigo() == 0) {
			medDao.fechar();
			return 0;
		}
		
		UsuarioDAO usuDao = new UsuarioDAO();
		Usuario usuario = new Usuario();
		usuario = usuDao.consultarPorCodigo(uso.getUsuario().getCodigo());
		
		if(usuario.getCodigo() == 0) {
			usuDao.fechar();
			return 0;
		}
		
		int x = dao.atualizar(uso);
		dao.fechar();
		return x;
	}
	
	/**
	 * Respons�vel por pesquisar o ultimo id cadastrado na tabela T_RMD_USOMEDICAMENTO
	 * @param n�o h� parametros
	 * @return o proximo id a ser cadastrado
	 * @throws Exception chamada de Excecao checked
     * @author Luan F. Mendes 
	 */
	
	public static int adicioarUltimoId() throws Exception {
		UsoMedicamentoDAO dao = new UsoMedicamentoDAO();
		int ultimo = dao.ultimoUsoMedicamento();
		
		dao.fechar();
		return ultimo;
	}
	
	/**
	 * Respons�vel por excluir um usuario da tabela T_RMD_USOMEDICAMENTO
	 * @param codigo
	 * @return n�mero de linhas excluidas
	 * @throws Exception chamada de Excecao checked
	 * @author Luan F. Mendes
	 */	
	
	public static int apagarUsoMedicamento(int codigo)throws Exception{
		UsoMedicamentoDAO dao = new UsoMedicamentoDAO();
		
		int x = dao.apagar(codigo);
		dao.fechar();
		return x;
	}
	
	/**
	 * Respons�vel por pesquisar dados na tabela T_RMD_USOMEDICAMENTO atrav�s do seu codigo
	 * @param codigo
	 * @return retornar todos os dados da tabela do codigo digitado
	 * @throws Excepetion chamada de Excecao checked
	 * @author Luan F. Mendes
	 */
	
	public static UsoMedicamento procurarPorCodigo(int codigo)throws Exception{
		UsoMedicamentoDAO dao = new UsoMedicamentoDAO();
		UsoMedicamento uso = new UsoMedicamento();
		uso = dao.consultarPorCodigo(codigo);
		
		dao.fechar();
		return uso;
	}
	
	
}
