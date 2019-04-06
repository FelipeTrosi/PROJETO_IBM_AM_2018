package br.com.remider.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.remider.BO.MedicamentoBO;
import br.com.remider.beans.Medicamento;
import br.com.remider.conexao.Conexao;
/**
 * Essa classe manipula a tabela T_RMD_MEDICAMENTO
 * Possui métodos para: Cadastrar, Consultar, Alterar e Excluir 
 * @author Luan Ferreira Mendes
 * @version 1.0
 * @since 1.0
 * @see MedicamentoBO
 * @see Medicamento
 */
public class MedicamentoDAO {

	private static Connection con;
	private static PreparedStatement stmt;
	private static ResultSet rs;
	
	
	public int ultimoMedicamento() throws Exception{
		 stmt = con.prepareStatement("SELECT MAX(CD_MEDICAMENTO)+1 as CD_MEDICAMENTO FROM T_RMD_MEDICAMENTO");
		 
		 rs = stmt.executeQuery();
		 rs.next();
		 
		 int ultimoId = rs.getInt("CD_MEDICAMENTO");
		 
		 return ultimoId;
		 }
	
	
	public List<Medicamento> listaDeMedicamentos() throws Exception{
		List<Medicamento> lista = new ArrayList<>();
		stmt = con.prepareStatement("SELECT * FROM  T_RMD_MEDICAMENTO");
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			lista.add(new Medicamento(rs.getInt("CD_MEDICAMENTO"), 
					   rs.getString("NM_MEDICAMENTO"), 
					   rs.getString("NM_FICTICIO"), 
					   rs.getInt("QT_MEDICAMENTO"),
					   rs.getString("DS_MEDICAMENTO"), 
					   rs.getString("DT_CADASTRO"), 
					   rs.getString("DS_FOTO")));
			
		}
		return lista;
	}
	
	/**
	 * Neste método construtor, estabelecemos a comunicação com o banco
	 * @author Luan F. Mendes
	 * @param não possui parâmetros
	 * @return não há retorno
	 * @throws Exception Chamada de exceção checked SQLException
	 */
	public MedicamentoDAO() throws Exception{
		con = new Conexao().conectar();
	}
	
	/**
	 * Responsável por adicionar dados na tabela T_RMD_MEDICAMENTO
	 * @param medicamento
	 * @return Uma string com a mensagem de confirmação
	 * @throws Exception chamada de Excecao checked
	 * @author Luan F. Mendes 
	 */
	
	public String gravar(Medicamento medicamento) throws Exception{
		stmt = con.prepareStatement("INSERT INTO T_RMD_MEDICAMENTO (CD_MEDICAMENTO, NM_MEDICAMENTO, NM_FICTICIO, QT_MEDICAMENTO, DS_MEDICAMENTO, DT_CADASTRO, DS_FOTO) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)");
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date data = (java.util.Date) formatter.parse(medicamento.getDataCadastro());
		
		
		stmt.setInt(1, medicamento.getCodigo());
		stmt.setString(2, medicamento.getNomeMedicamento());
		stmt.setString(3, medicamento.getNomeFicticio());
		stmt.setInt(4, medicamento.getQuantidadeMedicamento());
		stmt.setString(5, medicamento.getDescricaoMedicamento());
		stmt.setDate(6, new Date(data.getTime()));
		stmt.setString(7, medicamento.getFoto());
		
		
		stmt.executeUpdate();
		
		return"OK";
	}
	
	/**
	 * Responsável por pesquisar dados na tabela T_RMD_MEDICAMENTO através do seu codigo
	 * @param codigo
	 * @return retornar todos os dados da tabela do codigo digitado
	 * @throws Excepetion chamada de Excecao checked
	 * @author Luan F. Mendes
	 */
	
	public Medicamento consultarPorCodigo(int codigo)throws Exception {
		stmt = con.prepareStatement("SELECT * FROM T_RMD_MEDICAMENTO WHERE CD_MEDICAMENTO=?");
		stmt.setInt(1, codigo);
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			return new Medicamento(rs.getInt("CD_MEDICAMENTO"), 
								   rs.getString("NM_MEDICAMENTO"), 
								   rs.getString("NM_FICTICIO"), 
								   rs.getInt("QT_MEDICAMENTO"),
								   rs.getString("DS_MEDICAMENTO"), 
								   rs.getString("DT_CADASTRO"), 
								   rs.getString("DS_FOTO"));
		}else {
			return new Medicamento();
		}
	}
	
	/**
	 * Responsavel por listar todos os medicamentos da tabela T_RMD_MEDICAMENTO que tem o mesmo nome
	 * @param nome
	 * @return todos os medicamentos com o mesmo nome
	 * @throws Exception chamada de Excecao checked
	 * @author Luan F. Mendes
	 */
	
	public List<Medicamento> consultarPorNome(String nome) throws Exception{
		List<Medicamento> lista = new ArrayList<>();
		stmt = con.prepareStatement("SELECT * FROM  T_RMD_MEDICAMENTO WHERE NM_MEDICAMENTO LIKE ?");
		stmt.setString(1, nome + "%");
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			lista.add(new Medicamento(rs.getInt("CD_MEDICAMENTO"), 
					   rs.getString("NM_MEDICAMENTO"), 
					   rs.getString("NM_FICTICIO"), 
					   rs.getInt("QT_MEDICAMENTO"),
					   rs.getString("DS_MEDICAMENTO"), 
					   rs.getString("DT_CADASTRO"), 
					   rs.getString("DS_FOTO")));
			
		}
		return lista;
	}
	
	
	/**
	 * Responsável por atualizar um usuario ja cadastrado na tabela T_RMD_MEDICAMENTO
	 * @param usuario
	 * @return numero de medicamentos atualizados
	 * @throws Exception chamada de Excecao checked
	 * @author Luan F. Mendes
	 */
	
	public int atualizar(Medicamento medicamento) throws Exception {
		stmt = con.prepareStatement("UPDATE T_RMD_MEDICAMENTO SET NM_MEDICAMENTO=?, NM_FICTICIO=?, QT_MEDICAMENTO=?, DS_MEDICAMENTO=?, "
				+ "DT_CADASTRO=?, DS_FOTO=? WHERE CD_MEDICAMENTO=?");
		
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date data = (java.util.Date) formatter.parse(medicamento.getDataCadastro());
		
		stmt.setString(1, medicamento.getNomeMedicamento());
		stmt.setString(2, medicamento.getNomeFicticio());
		stmt.setInt(3, medicamento.getQuantidadeMedicamento());
		stmt.setString(4, medicamento.getDescricaoMedicamento());
		stmt.setDate(5, new Date(data.getTime()));
		stmt.setString(6, medicamento.getFoto());
		stmt.setInt(7, medicamento.getCodigo());
		
		return stmt.executeUpdate();
		
		
		
		
	}
	
	
	/**
	 * Responsável por excluir um medicamento da tabela T_RMD_MEDICAMENTO
	 * @param codigo
	 * @return número de linhas excluidas
	 * @throws Exception chamada de Excecao checked
	 * @author Luan F. Mendes
	 */	
		
	
	public int apagar(int codigo) throws Exception{
		stmt = con.prepareStatement("DELETE FROM T_RMD_MEDICAMENTO WHERE CD_MEDICAMENTO=?");
		
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
