package br.com.remider.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.remider.BO.UsuarioBO;
import br.com.remider.beans.Usuario;
import br.com.remider.conexao.Conexao;
/**
 * Essa classe manipula a tabela T_RMD_USUARIO
 * Possui métodos para: Cadastrar, Consultar, Alterar e Excluir 
 * @author Luan Ferreira Mendes
 * @version 1.0
 * @since 1.0
 * @see UsuarioBO
 * @see Usuario
 */
public class UsuarioDAO {

	//HUMBERTO
	private static Connection con;
	private static PreparedStatement stmt;
	private static ResultSet rs;


	public List<Usuario> listaUsuarios() throws Exception{
		List<Usuario> lista = new ArrayList<>();
		stmt = con.prepareStatement("SELECT * FROM T_RMD_USUARIO WHERE ATIVO=1");
		rs = stmt.executeQuery();

		while(rs.next()) {
			lista.add(new Usuario(rs.getInt("CD_USUARIO"), 
					rs.getString("NM_USUARIO"), 
					rs.getString("DT_NASCIMENTO"), 
					rs.getString("DS_SEXO"), 
					rs.getString("NM_USERNAME"),
					rs.getString("DS_SENHA"),
					rs.getString("DS_PERMISSAO"), 
					rs.getString("DS_PERGUNTA"), 
					rs.getString("DS_RESPOSTA")));

		}
		return lista;
	}
	
	public Usuario procurarLoginSenha(String username, String senha) throws Exception{
		
		stmt = con.prepareStatement("SELECT * FROM T_RMD_USUARIO WHERE NM_USERNAME=? AND DS_SENHA=?");
		stmt.setString(1, username);
		stmt.setString(2, senha);
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			
			return new Usuario(rs.getInt("CD_USUARIO"), 
					rs.getString("NM_USUARIO"), 
					rs.getString("DT_NASCIMENTO"), 
					rs.getString("DS_SEXO"), 
					rs.getString("NM_USERNAME"),
					rs.getString("DS_SENHA"),
					rs.getString("DS_PERMISSAO"), 
					rs.getString("DS_PERGUNTA"), 
					rs.getString("DS_RESPOSTA"));
		}else {
		
		return new Usuario();
		}
	}
	
	
	
	/**
	 * Neste método construtor, estabelecemos a comunicação com o banco
	 * @author Luan F. Mendes
	 * @param não possui parâmetros
	 * @return não há retorno
	 * @throws Exception Chamada de exceção checked SQLException
	 */
	public UsuarioDAO() throws Exception{
		con = new Conexao().conectar();
	}


	/**
	 * Responsável por pesquisar o proximo id a ser cadastrado na tabela T_RMD_USUARIO
	 * @param não há parametros
	 * @return o proximo id a ser cadastrado
	 * @throws Exception chamada de Excecao checked
     * @author Luan F. Mendes 
	 */
	 
	 public int ultimoUsuario() throws Exception{
		 stmt = con.prepareStatement("SELECT MAX(CD_USUARIO)+1 as CD_USUARIO FROM T_RMD_USUARIO");
		 
		 rs = stmt.executeQuery();
		 rs.next();
		 
		 int ultimoId = rs.getInt("CD_USUARIO");
		 
		 return ultimoId;
		 }
	
	
	
	/**
	 * Responsável por adicionar dados na tabela T_RMD_USUARIO
	 * @param usuario
	 * @return Uma string com a mensagem de confirmação
	 * @throws Exception chamada de Excecao checked
	 * @author Luan F. Mendes 
	 */

	 public String gravar(Usuario usuario) throws Exception{
			stmt = con.prepareStatement("INSERT INTO T_RMD_USUARIO (CD_USUARIO, NM_USUARIO, DT_NASCIMENTO, DS_SEXO, NM_USERNAME, DS_SENHA, DS_PERMISSAO, DS_PERGUNTA, DS_RESPOSTA, ATIVO) VALUES "
					+ "(?,?,?,?,?,?,?,?,?,1)");
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date data = (java.util.Date) formatter.parse(usuario.getDataNascimento());			

			stmt.setInt(1, usuario.getCodigo());
			stmt.setString(2, usuario.getNome());
			stmt.setDate(3, new Date(data.getTime()));
			stmt.setString(4, usuario.getSexo());
			stmt.setString(5, usuario.getUsername());
			stmt.setString(6, usuario.getSenha());
			stmt.setString(7, usuario.getNivelPermissao());
			stmt.setString(8, usuario.getPergunta());
			stmt.setString(9, usuario.getResposta());
			
			stmt.executeUpdate();
			
			return "Cadastrado com sucesso";
		}

	/**
	 * Responsável por pesquisar dados na tabela T_RMD_USUARIO através do seu codigo
	 * @param codigo
	 * @return retornar todos os dados da tabela do codigo digitado que estão ativos no sistema
	 * @throws Excepetion chamada de Excecao checked
	 * @author Luan F. Mendes
	 */

	public Usuario consultarPorCodigo(int codigo)throws Exception {
		stmt = con.prepareStatement("SELECT * FROM T_RMD_USUARIO WHERE CD_USUARIO=? AND ATIVO=1");
		stmt.setInt(1, codigo);
		rs = stmt.executeQuery();

		if(rs.next()) {
			return new Usuario(rs.getInt("CD_USUARIO"), 
					rs.getString("NM_USUARIO"), 
					rs.getString("DT_NASCIMENTO"), 
					rs.getString("DS_SEXO"), 
					rs.getString("NM_USERNAME"),
					rs.getString("DS_SENHA"),
					rs.getString("DS_PERMISSAO"), 
					rs.getString("DS_PERGUNTA"), 
					rs.getString("DS_RESPOSTA"));
		}else {
			return new Usuario();
		}
	}
	/**
	 * Responsável por pesquisar dados na tabela T_RMD_USUARIO através do seu codigo
	 * @param codigo
	 * @return retornar todos os dados da tabela do codigo digitado que estão desativados no sistema
	 * @throws Excepetion chamada de Excecao checked
	 * @author Luan F. Mendes
	 */
	public Usuario consultarPorCodigoInativo(int codigo)throws Exception {
		stmt = con.prepareStatement("SELECT * FROM T_RMD_USUARIO WHERE CD_USUARIO=? AND ATIVO=0");
		stmt.setInt(1, codigo);
		rs = stmt.executeQuery();

		if(rs.next()) {
			return new Usuario(rs.getInt("CD_USUARIO"), 
					rs.getString("NM_USUARIO"), 
					rs.getString("DT_NASCIMENTO"), 
					rs.getString("DS_SEXO"), 
					rs.getString("NM_USERNAME"),
					rs.getString("DS_SENHA"),
					rs.getString("DS_PERMISSAO"), 
					rs.getString("DS_PERGUNTA"), 
					rs.getString("DS_RESPOSTA"));
		}else {
			return new Usuario();
		}
	}

	/**
	 * Responsavel por listar todos os usuarios da tabela T_RMD_USUARIO que tem o mesmo nome
	 * @param nome
	 * @return todos os usuarios com o mesmo nome
	 * @throws Exception chamada de Excecao checked
	 * @author Luan F. Mendes
	 */

	public List<Usuario> consultarPorNome(String nome) throws Exception{
		List<Usuario> lista = new ArrayList<>();
		stmt = con.prepareStatement("SELECT * FROM T_RMD_USUARIO WHERE NM_USUARIO LIKE ? AND ATIVO=1");
		stmt.setString(1, nome + "%");
		rs = stmt.executeQuery();

		while(rs.next()) {
			lista.add(new Usuario(rs.getInt("CD_USUARIO"), 
					rs.getString("NM_USUARIO"), 
					rs.getString("DT_NASCIMENTO"), 
					rs.getString("DS_SEXO"), 
					rs.getString("NM_USERNAME"),
					rs.getString("DS_SENHA"),
					rs.getString("DS_PERMISSAO"), 
					rs.getString("DS_PERGUNTA"), 
					rs.getString("DS_RESPOSTA")));

		}
		return lista;
	}

	/**
	 * Responsável por atualizar um usuario ja cadastrado na tabela T_RMD_USUARIO
	 * @param usuario
	 * @return numero de usuarios atualizados
	 * @throws Exception chamada de Excecao checked
	 * @author Luan F. Mendes
	 */

	public int atualizar(Usuario usuario) throws Exception {
		stmt = con.prepareStatement("UPDATE T_RMD_USUARIO SET NM_USUARIO=?, DT_NASCIMENTO=?, DS_SEXO=?, NM_USERNAME=?,"
				+ "DS_SENHA=?, DS_PERMISSAO=?, DS_PERGUNTA=?, DS_RESPOSTA=? WHERE CD_USUARIO=?");

		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date data = (java.util.Date) formatter.parse(usuario.getDataNascimento());
		
		stmt.setString(1, usuario.getNome());
		stmt.setDate(2, new Date(data.getTime()));
		stmt.setString(3, usuario.getSexo());
		stmt.setString(4, usuario.getUsername());
		stmt.setString(5, usuario.getSenha());
		stmt.setString(6, usuario.getNivelPermissao());
		stmt.setString(7, usuario.getPergunta());
		stmt.setString(8, usuario.getResposta());
		stmt.setInt(9, usuario.getCodigo());

		return stmt.executeUpdate();

	}

	/**
	 * Responsável por desativar um usuario da tabela T_RMD_USUARIO
	 * @param numero
	 * @return número de linhas excluidas
	 * @throws Exception chamada de Excecao checked
	 * @author Luan F. Mendes
	 */

	public int desativar(int numero)throws Exception {
		stmt = con.prepareStatement("UPDATE T_RMD_USUARIO SET ATIVO=0 WHERE CD_USUARIO=?");
		stmt.setInt(1, numero);

		return stmt.executeUpdate();

	}

	/**
	 * Responsável por desativar um usuario da tabela T_RMD_USUARIO
	 * @param numero
	 * @return número de linhas excluidas
	 * @throws Exception chamada de Excecao checked
	 * @author Luan F. Mendes
	 */

	public int ativar(int numero)throws Exception {
		stmt = con.prepareStatement("UPDATE T_RMD_USUARIO SET ATIVO=1 WHERE CD_USUARIO=?");
		stmt.setInt(1, numero);

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
