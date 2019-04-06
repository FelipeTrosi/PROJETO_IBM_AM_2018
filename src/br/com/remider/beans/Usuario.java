package br.com.remider.beans;

public class Usuario implements Comparable<Usuario>  {
	private int codigo;
	private String nome;
	private String dataNascimento;
	private String sexo;
	private String username;
	private String senha;
	private String nivelPermissao;
	private String pergunta;
	private String resposta;
	
	public int compareTo(Usuario outro) {
		if(this.codigo<outro.codigo) {
			return -1;
		}else if(this.codigo>outro.codigo){
			return 1;
		}else {
			return 0;
		}
	}
	
	
	public void setAll(int codigo, String nome, String dataNascimento, String sexo, String username,String senha,
			String nivelPermissao, String pergunta, String resposta) {
		setCodigo(codigo);
		setNome(nome);
		setDataNascimento(dataNascimento);
		setSexo(sexo);
		setUsername(username);
		setSenha(senha);
		setNivelPermissao(nivelPermissao);
		setPergunta(pergunta);
		setResposta(resposta);
	}
	
	
	public String getAll() {
		return codigo + "\n" + nome + "\n" + dataNascimento + "\n" + sexo + "\n" + username + "\n" + senha + "\n" + nivelPermissao + "\n" + pergunta + "\n" + resposta;
	}
	
	public String getResumo() {
		return codigo + "\n" + nome + "\n" + dataNascimento + "\n" + sexo + "\n" + username;
	}
	
	public Usuario(int codigo) {
		setCodigo(codigo);
	}
	
	public Usuario() {
		
	}
	public Usuario(String username, String senha) {
		setUsername(username);
		setSenha(senha);
	}
	
	public Usuario(int codigo, String nome) {
		setCodigo(codigo);
		setNome(nome);
	}
	public Usuario(int codigo, String nome, String dataNascimento, String sexo, String username,String senha,
			String nivelPermissao, String pergunta, String resposta) {
		setCodigo(codigo);
		setNome(nome);
		setDataNascimento(dataNascimento);
		setSexo(sexo);
		setUsername(username);
		setSenha(senha);
		setNivelPermissao(nivelPermissao);
		setPergunta(pergunta);
		setResposta(resposta);
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNivelPermissao() {
		return nivelPermissao;
	}
	public void setNivelPermissao(String nivelPermissao) {
		this.nivelPermissao = nivelPermissao;
	}
	public String getPergunta() {
		return pergunta;
	}
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	
	
	
	
}
	
	
	
	
	
