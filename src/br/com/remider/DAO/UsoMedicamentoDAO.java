package br.com.remider.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.remider.BO.UsoMedicamentoBO;
import br.com.remider.beans.Medicamento;
import br.com.remider.beans.UsoMedicamento;
import br.com.remider.beans.Usuario;
import br.com.remider.conexao.Conexao;

/**
 * Essa classe manipula a tabela T_RMD_USOMEDICAMENTO
 * Possui m�todos para: Cadastrar, Consultar, Alterar e excluir
 * @author Luan Ferreira Mendes
 * @version 1.0
 * @since 1.0
 * @see UsoMedicamentoBO
 * @see UsoMedicamento
 */

public class UsoMedicamentoDAO {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	
	
	
	public List<UsoMedicamento> listaUsoMedicamentos()throws Exception {
		List<UsoMedicamento> lista = new ArrayList<>();
		stmt = con.prepareStatement("SELECT * FROM T_RMD_USOMEDICAMENTO INNER JOIN T_RMD_USUARIO ON (T_RMD_USOMEDICAMENTO.CD_USUARIO = T_RMD_USUARIO.CD_USUARIO)"
				+ " INNER JOIN T_RMD_MEDICAMENTO ON (T_RMD_USOMEDICAMENTO.CD_MEDICAMENTO = T_RMD_MEDICAMENTO.CD_MEDICAMENTO) ORDER BY CD_USOMEDICAMENTO");
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			lista.add(new	UsoMedicamento(rs.getInt("CD_USOMEDICAMENTO"), 
											new Usuario(rs.getInt("CD_USUARIO"), 
													   rs.getString("NM_USUARIO"), 
													   rs.getString("DT_NASCIMENTO"), 
													   rs.getString("DS_SEXO"), 
													   rs.getString("NM_USERNAME"),
													   rs.getString("DS_SENHA"),
													   rs.getString("DS_PERMISSAO"), 
													   rs.getString("DS_PERGUNTA"), 
													   rs.getString("DS_RESPOSTA")), 
											new Medicamento(rs.getInt("CD_MEDICAMENTO"), 
													   rs.getString("NM_MEDICAMENTO"), 
													   rs.getString("NM_FICTICIO"), 
													   rs.getInt("QT_MEDICAMENTO"),
													   rs.getString("DS_MEDICAMENTO"), 
													   rs.getString("DT_CADASTRO"), 
													   rs.getString("DS_FOTO")), 
									  rs.getString("DT_INICIO"), 
									  rs.getString("DT_TERMINO")));
		}
		return lista;
	}
	
	/**
	 * Neste m�todo construtor, estabelecemos a comunica��o com o banco
	 * @author Luan F. Mendes
	 * @param n�o possui par�metros
	 * @return n�o h� retorno
	 * @throws Exception Chamada de exce��o checked SQLException
	 */
	public UsoMedicamentoDAO() throws Exception{
		con = new Conexao().conectar();
	}
	
	/**
	 * Respons�vel por adicionar dados na tabela T_RMD_USOMEDICAMENTO
	 * @param uso
	 * @return Uma string com a mensagem de confirma��o
	 * @throws Exception chamada de Excecao checked
	 * @author Luan F. Mendes 
	 */
	
	public String gravar(UsoMedicamento uso) throws Exception{
		stmt = con.prepareStatement("INSERT INTO T_RMD_USOMEDICAMENTO (CD_USOMEDICAMENTO, CD_USUARIO, CD_MEDICAMENTO, DT_INICIO, DT_TERMINO) "
				+ "VALUES (?, ?, ?, ?, ?)");
		
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date data1 = (java.util.Date) formatter.parse(uso.getDataInicio());
		java.util.Date data2 = (java.util.Date) formatter.parse(uso.getDataTermino());
		
		stmt.setInt(1, uso.getCodigo());
		stmt.setInt(2, uso.getUsuario().getCodigo());
		stmt.setInt(3, uso.getMedicamento().getCodigo());
		stmt.setDate(4, new Date(data1.getTime()));
		stmt.setDate(5, new Date(data2.getTime()));
		
		
		stmt.executeUpdate();
		
		return"OK";
	}
	
	/**
	 * Respons�vel por pesquisar dados na tabela T_RMD_USOMEDICAMENTO atrav�s do seu codigo
	 * @param codigo
	 * @return retornar todos os dados da tabela do codigo digitado
	 * @throws Excepetion chamada de Excecao checked
	 * @author Luan F. Mendes
	 */
	
	public UsoMedicamento consultarPorCodigo(int codigo)throws Exception {
		stmt = con.prepareStatement("SELECT * FROM T_RMD_USOMEDICAMENTO INNER JOIN T_RMD_USUARIO ON (T_RMD_USOMEDICAMENTO.CD_USUARIO = T_RMD_USUARIO.CD_USUARIO)"
				+ " INNER JOIN T_RMD_MEDICAMENTO ON (T_RMD_USOMEDICAMENTO.CD_MEDICAMENTO = T_RMD_MEDICAMENTO.CD_MEDICAMENTO) WHERE CD_USOMEDICAMENTO=?");
		stmt.setInt(1, codigo);
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			return new UsoMedicamento(rs.getInt("CD_USOMEDICAMENTO"), 
											new Usuario(rs.getInt("CD_USUARIO"), 
													   rs.getString("NM_USUARIO"), 
													   rs.getString("DT_NASCIMENTO"), 
													   rs.getString("DS_SEXO"), 
													   rs.getString("NM_USERNAME"),
													   rs.getString("DS_SENHA"),
													   rs.getString("DS_PERMISSAO"), 
													   rs.getString("DS_PERGUNTA"), 
													   rs.getString("DS_RESPOSTA")), 
											new Medicamento(rs.getInt("CD_MEDICAMENTO"), 
													   rs.getString("NM_MEDICAMENTO"), 
													   rs.getString("NM_FICTICIO"), 
													   rs.getInt("QT_MEDICAMENTO"),
													   rs.getString("DS_MEDICAMENTO"), 
													   rs.getString("DT_CADASTRO"), 
													   rs.getString("DS_FOTO")), 
									  rs.getString("DT_INICIO"), 
									  rs.getString("DT_TERMINO"));
		}else {
			return new UsoMedicamento();
		}
	}
	
	
	/**
	 * Respons�vel por atualizar um uso de medicamento ja cadastrado na tabela T_RMD_USOMEDICAMENTO
	 * @param uso
	 * @return numero de medicamentos atualizados
	 * @throws Exception chamada de Excecao checked
	 * @author Luan F. Mendes
	 */
	
	public int atualizar(UsoMedicamento uso) throws Exception {
		stmt = con.prepareStatement("UPDATE T_RMD_USOMEDICAMENTO SET CD_USUARIO=?, CD_MEDICAMENTO=?, DT_INICIO=?, DT_TERMINO=? "
				+ "WHERE CD_USOMEDICAMENTO=?");
		
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date data1 = (java.util.Date) formatter.parse(uso.getDataInicio());
		java.util.Date data2 = (java.util.Date) formatter.parse(uso.getDataTermino());
		
		
		stmt.setInt(1, uso.getUsuario().getCodigo());
		stmt.setInt(2, uso.getMedicamento().getCodigo());
		stmt.setDate(3, new Date(data1.getTime()));
		stmt.setDate(4, new Date(data2.getTime()));
		stmt.setInt(5, uso.getCodigo());
		
		return stmt.executeUpdate();		
		
		
	}
	
	/**
	 * Respons�vel por pesquisar o proximo id a ser cadastrado na tabela T_RMD_USOMEDICAMENTO
	 * @param n�o h� parametros
	 * @return o proximo id a ser cadastrado
	 * @throws Exception chamada de Excecao checked
     * @author Luan F. Mendes 
	 */
	 
	 public int ultimoUsoMedicamento() throws Exception{
		 stmt = con.prepareStatement("SELECT MAX(CD_USOMEDICAMENTO)+1 as CD_USOMEDICAMENTO FROM T_RMD_USOMEDICAMENTO");
		 
		 rs = stmt.executeQuery();
		 rs.next();
		 
		 int ultimoId = rs.getInt("CD_USOMEDICAMENTO");
		 
		 return ultimoId;
		 }
	 	
	 	/**
		 * Respons�vel por excluir um medicamento da tabela T_RMD_USOMEDICAMENTO
		 * @param codigo
		 * @return n�mero de linhas excluidas
		 * @throws Exception chamada de Excecao checked
		 * @author Luan F. Mendes
		 */	
			
		
		public int apagar(int codigo) throws Exception{
			stmt = con.prepareStatement("DELETE FROM T_RMD_USOMEDICAMENTO WHERE CD_USOMEDICAMENTO=?");
			
			stmt.setInt(1, codigo);
			
			return stmt.executeUpdate();
		}
	
	/**
	 * Neste m�todo construtor, encerramos a comunica��o com o banco
	 * @author Luan F. Mendes
	 * @param n�o possui par�metros
	 * @return n�o h� retorno
	 * @throws Exception Chamada de exce��o checked SQLException
	 */
	
	public void fechar()throws Exception{
		con.close();
	}
}
