package br.com.remider.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.remider.BO.LembreteBO;
import br.com.remider.beans.Lembrete;
import br.com.remider.beans.Medicamento;
import br.com.remider.beans.UsoMedicamento;
import br.com.remider.beans.Usuario;
import br.com.remider.conexao.Conexao;
/**
 * Essa classe manipula a tabela T_RMD_LEMBRETE
 * Possui métodos para: Cadastrar, Consultar, Alterar e Excluir 
 * @author Luan Ferreira Mendes
 * @version 1.0
 * @since 1.0
 * @see LembreteBO
 * @see Lembrete
 */
public class LembreteDAO {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public List<Lembrete> listaLembretes()throws Exception {
		List<Lembrete> lista = new ArrayList<>();
		stmt = con.prepareStatement("SELECT * FROM T_RMD_LEMBRETE INNER JOIN T_RMD_USOMEDICAMENTO ON (T_RMD_LEMBRETE.CD_USOMEDICAMENTO = T_RMD_USOMEDICAMENTO.CD_USOMEDICAMENTO)"
				+ " INNER JOIN T_RMD_MEDICAMENTO ON (T_RMD_USOMEDICAMENTO.CD_MEDICAMENTO = T_RMD_MEDICAMENTO.CD_MEDICAMENTO)"
				+ " INNER JOIN T_RMD_USUARIO ON (T_RMD_USOMEDICAMENTO.CD_USUARIO = T_RMD_USUARIO.CD_USUARIO) ORDER BY CD_LEMBRETE");
		
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			lista.add(new Lembrete(rs.getInt("CD_LEMBRETE"), 
								rs.getInt("QT_LEMBRETE"), 
								rs.getString("ALARME"), 
								new UsoMedicamento(rs.getInt("CD_USOMEDICAMENTO"), 
												   new Usuario(rs.getInt("CD_USUARIO"), 
														   	   rs.getString("NM_USUARIO")), 
												   new Medicamento(rs.getInt("CD_MEDICAMENTO"), 
														   		   rs.getString("NM_MEDICAMENTO"), 
														   		   rs.getString("NM_FICTICIO"),
														   		   rs.getString("DS_MEDICAMENTO"),
														   		   rs.getString("DS_FOTO")), 
												   rs.getString("DT_INICIO"), 
												   rs.getString("DT_TERMINO")
												   
										)));
		}return lista;
	}
	
	/**
	 * Neste método construtor, estabelecemos a comunicação com o banco
	 * @author Luan F. Mendes
	 * @param não possui parâmetros
	 * @return não há retorno
	 * @throws Exception Chamada de exceção checked SQLException
	 */
	public LembreteDAO() throws Exception{
		con = new Conexao().conectar();
	}
	
	/**
	 * Responsável por adicionar dados na tabela T_RMD_LEMBRETE
	 * @param lembrete
	 * @return Uma string com a mensagem de confirmação
	 * @throws Exception chamada de Excecao checked
	 * @author Luan F. Mendes 
	 */
	
	public String gravar(Lembrete lembrete) throws Exception{
		stmt = con.prepareStatement("INSERT INTO T_RMD_LEMBRETE (CD_LEMBRETE, QT_LEMBRETE, ALARME, CD_USOMEDICAMENTO) "
				+ "VALUES (?, ?, ?, ?)");
		
		
		
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date data = (java.util.Date) formatter.parse(lembrete.getAlarme());
		
		
		stmt.setInt(1, lembrete.getCodigo());
		stmt.setInt(2, lembrete.getQuantidadeLembretes());
		stmt.setDate(3, new Date(data.getTime()));
		stmt.setInt(4, lembrete.getUsoMedicamento().getCodigo());
		
		
		stmt.executeUpdate();
		
		return"OK";
	}
	
	/**
	 * Responsável por pesquisar dados na tabela T_RMD_LEMBRETE através do seu codigo
	 * @param codigo
	 * @return retornar todos os dados da tabela do codigo digitado
	 * @throws Excepetion chamada de Excecao checked
	 * @author Luan F. Mendes
	 */
	
	public Lembrete consultarPorCodigo(int codigo)throws Exception {
		stmt = con.prepareStatement("SELECT * FROM T_RMD_LEMBRETE INNER JOIN T_RMD_USOMEDICAMENTO ON (T_RMD_LEMBRETE.CD_USOMEDICAMENTO = T_RMD_USOMEDICAMENTO.CD_USOMEDICAMENTO)"
				+ " INNER JOIN T_RMD_MEDICAMENTO ON (T_RMD_USOMEDICAMENTO.CD_MEDICAMENTO = T_RMD_MEDICAMENTO.CD_MEDICAMENTO)"
				+ " INNER JOIN T_RMD_USUARIO ON (T_RMD_USOMEDICAMENTO.CD_USUARIO = T_RMD_USUARIO.CD_USUARIO)WHERE CD_LEMBRETE=?");
		stmt.setInt(1, codigo);
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			return new Lembrete(rs.getInt("CD_LEMBRETE"), 
								rs.getInt("QT_LEMBRETE"), 
								rs.getString("ALARME"), 
								new UsoMedicamento(rs.getInt("CD_USOMEDICAMENTO"), 
												   new Usuario(rs.getInt("CD_USUARIO"), 
														   	   rs.getString("NM_USUARIO")), 
												   new Medicamento(rs.getInt("CD_MEDICAMENTO"), 
														   		   rs.getString("NM_MEDICAMENTO"), 
														   		   rs.getString("NM_FICTICIO"),
														   		   rs.getString("DS_MEDICAMENTO"),
														   		   rs.getString("DS_FOTO")), 
												   rs.getString("DT_INICIO"), 
												   rs.getString("DT_TERMINO")
												   
										));
		}else {
			return new Lembrete();
		}
	}
	
	
	/**
	 * Responsável por atualizar um lembrete ja cadastrado na tabela T_RMD_LEMBRETE
	 * @param lembrete
	 * @return numero de lembretes atualizados
	 * @throws Exception chamada de Excecao checked
	 * @author Luan F. Mendes
	 */
	
	public int atualizar(Lembrete lembrete) throws Exception {
		stmt = con.prepareStatement("UPDATE T_RMD_LEMBRETE SET QT_LEMBRETE=?, ALARME=?, CD_USOMEDICAMENTO=? "
				+ "WHERE CD_LEMBRETE=?");
		
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date data = (java.util.Date) formatter.parse(lembrete.getAlarme());
		
		stmt.setInt(1, lembrete.getQuantidadeLembretes());
		stmt.setDate(2, new Date(data.getTime()));
		stmt.setInt(3, lembrete.getUsoMedicamento().getCodigo());
		stmt.setInt(4, lembrete.getCodigo());
		
		return stmt.executeUpdate();
		
		
		
		
	}
	
	/**
	 * Responsável por pesquisar o proximo id a ser cadastrado na tabela T_RMD_LEMBRETE
	 * @param não há parametros
	 * @return o proximo id a ser cadastrado
	 * @throws Exception chamada de Excecao checked
     * @author Luan F. Mendes 
	 */
	 
	 public int ultimoLembrete() throws Exception{
		 stmt = con.prepareStatement("SELECT MAX(CD_LEMBRETE)+1 as CD_LEMBRETE FROM T_RMD_LEMBRETE");
		 
		 rs = stmt.executeQuery();
		 rs.next();
		 
		 int ultimoId = rs.getInt("CD_LEMBRETE");
		 
		 return ultimoId;
		 }
	
	
	/**
	 * Responsável por excluir um uso de medicamento da tabela T_RMD_LEMBRETE
	 * @param codigo
	 * @return número de linhas excluidas
	 * @throws Exception chamada de Excecao checked
	 * @author Luan F. Mendes
	 */	
		
	
	public int apagar(int codigo) throws Exception{
		stmt = con.prepareStatement("DELETE FROM T_RMD_LEMBRETE WHERE CD_LEMBRETE=?");
		
		stmt.setInt(1, codigo);
		
		return stmt.executeUpdate();
	}
	
	/**
	 * Neste método construtor, encerramos a comunicação com o banco
	 * @author Luan F. Mendes
	 * @param não possui parâmetros
	 * @return não há retorno
	 * @throws Exception Chamada de exceção checked SQLException
	 */
	
	public void fechar()throws Exception{
		con.close();
	}
}
