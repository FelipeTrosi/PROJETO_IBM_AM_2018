package br.com.remider.BO;

import java.util.ArrayList;
import java.util.List;

import br.com.remider.DAO.UsuarioDAO;
import br.com.remider.beans.Usuario;
/**
 * Essa classe manipula a tabela T_RMD_USUARIO
 * Possui métodos para: Cadastrar, Consultar, Alterar e Excluir 
 * @author Luan Ferreira Mendes
 * @version 1.0
 * @since 1.0
 * @see UsuarioBO
 * @see Usuario
 * @see UsuarioDAO
 */

public class UsuarioBO {
	

	public static List<Usuario> listarUsuarios()throws Exception {
		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> usuario = new ArrayList<>();
		
		usuario = dao.listaUsuarios();
		dao.fechar();
		return usuario;		
		
	}
	
	public static Usuario autenticarProLogin(String username, String senha)throws Exception{
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = new Usuario();
		usuario = dao.procurarLoginSenha(username, senha);

		dao.fechar();
		return usuario;
		
	}
	
	/**
	 * Responsável por adicionar dados na tabela T_RMD_USUARIO e validar seus campos
	 * @param usuario
	 * @return Uma string com a mensagem de confirmação
	 * @throws Exception chamada de Excecao checked
	 * @author Luan F. Mendes 
	 */
	
	public static String novoUsuario(Usuario usuario)throws Exception {
		//Validação
		if(usuario.getNome().length() > 40) {
			return "Nome longo";
		}
		if(usuario.getSexo().length() > 1) {
			return "F ou M apenas";
		}
		if(usuario.getUsername().length() > 20) {
			return "Username longo";
		}
		if(usuario.getNivelPermissao().length() > 15) {
			return "Permissao longa";
		}
		if(usuario.getPergunta().length() > 30) {
			return "Pergunta longa";
		}
		if(usuario.getResposta().length() > 30) {
			return "Resposta longa";
		}
		if(usuario.getSenha().length() > 30) {
			return "Senha longa";
		}
		
		//Padronização
		usuario.setNome(usuario.getNome().toUpperCase());
		usuario.setSexo(usuario.getSexo().toUpperCase());
		usuario.setUsername(usuario.getUsername().toUpperCase());
		usuario.setNivelPermissao(usuario.getNivelPermissao().toUpperCase());
		usuario.setPergunta(usuario.getPergunta().toUpperCase());
		usuario.setResposta(usuario.getResposta().toUpperCase());
		
		UsuarioDAO dao = new UsuarioDAO();
		Usuario resultado = dao.consultarPorCodigo(usuario.getCodigo());
		if(resultado.getCodigo() > 0) {
			dao.fechar();
			return "Usuario já existe";
		}
		
		String x = dao.gravar(usuario);
		dao.fechar();
		return x;
		
	}
	
	/**
	 * Responsável por atualizar um usuario ja cadastrado na tabela T_RMD_USUARIO e validar seus campos
	 * @param usuario
	 * @return numero de usuarios atualizados
	 * @throws Exception chamada de Excecao checked
	 * @author Luan F. Mendes
	 */
	
	public static int alterarUsuario(Usuario usuario)throws Exception{
		UsuarioDAO dao = new UsuarioDAO();
		Usuario resultado = dao.consultarPorCodigo(usuario.getCodigo());
		if(resultado == null) {
			return 0;
		}
		if(usuario.getNome().length() > 40) {
			return 0;
		}
		if(usuario.getSexo().length() > 1) {
			return 0;
		}
		if(usuario.getUsername().length() > 20) {
			return 0;
		}
		if(usuario.getNivelPermissao().length() > 15) {
			return 0;
		}
		if(usuario.getPergunta().length() > 30) {
			return 0;
		}
		if(usuario.getResposta().length() > 30) {
			return 0;
		}
		if(usuario.getSenha().length() > 30) {
			return 0;
		}
		
		//Padronização
		usuario.setNome(usuario.getNome().toUpperCase());
		usuario.setSexo(usuario.getSexo().toUpperCase());
		usuario.setUsername(usuario.getUsername().toUpperCase());
		usuario.setNivelPermissao(usuario.getNivelPermissao().toUpperCase());
		usuario.setPergunta(usuario.getPergunta().toUpperCase());
		usuario.setResposta(usuario.getResposta().toUpperCase());
		
		int x = dao.atualizar(usuario);
		dao.fechar();
		return x;
	}
	
	/**
	 * Responsável por pesquisar o ultimo id cadastrado na tabela T_RMD_USUARIO
	 * @param não há parametros
	 * @return o proximo id a ser cadastrado
	 * @throws Exception chamada de Excecao checked
     * @author Luan F. Mendes 
	 */
	
	public static int adicioarUltimoId() throws Exception {
		UsuarioDAO dao = new UsuarioDAO();
		int ultimo = dao.ultimoUsuario();
		
		dao.fechar();
		return ultimo;
	}

	/**
	 * Responsável por pesquisar dados na tabela T_RMD_USUARIO através do seu codigo
	 * @param codigo
	 * @return retornar todos os dados da tabela do codigo digitado
	 * @throws Excepetion chamada de Excecao checked
	 * @author Luan F. Mendes
	 */
	
	public static Usuario procurarPorCodigo(int codigo)throws Exception{
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = new Usuario();
		usuario = dao.consultarPorCodigo(codigo);

		dao.fechar();
		return usuario;
		
	}
	
	/**
	 * Responsavel por listar todos os usuarios da tabela T_RMD_USUARIO que tem o mesmo nome
	 * @param nome
	 * @return todos os usuarios com o mesmo nome
	 * @throws Exception chamada de Excecao checked
	 * @author Luan F. Mendes
	 */
	
	public static List<Usuario> procurarPorNome(String nome)throws Exception {
		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> usuario = new ArrayList<>();
		
		usuario = dao.consultarPorNome(nome);
		dao.fechar();
		return usuario;		
		
	}
	
	/**
	 * Responsável por desativar um usuario da tabela T_RMD_USUARIO
	 * @param numero
	 * @return número de linhas excluidas
	 * @throws Exception chamada de Excecao checked
	 * @author Luan F. Mendes
	 */
	
	public static int desativarUsuario(int numero)throws Exception {
		UsuarioDAO dao = new UsuarioDAO();

		int x = dao.desativar(numero);
		dao.fechar();
		return x;
		
	}
	
	/**
	 * Responsável por desativar um usuario da tabela T_RMD_USUARIO
	 * @param numero
	 * @return número de linhas excluidas
	 * @throws Exception chamada de Excecao checked
	 * @author Luan F. Mendes
	 */
	
	public int ativarUsuario(int numero)throws Exception {
		UsuarioDAO dao = new UsuarioDAO();

		int x = dao.ativar(numero);
		dao.fechar();
		return x;
		
	}
	
	/**
	 * Responsável por pesquisar dados na tabela T_RMD_USUARIO através do seu codigo
	 * @param codigo
	 * @return retornar todos os dados da tabela do codigo digitado que estão desativados no sistema
	 * @throws Excepetion chamada de Excecao checked
	 * @author Luan F. Mendes
	 */
	
	public static Usuario procurarPorInativo(int codigo)throws Exception{
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = new Usuario();
		usuario = dao.consultarPorCodigoInativo(codigo);

		dao.fechar();
		return usuario;
		
	}

}
