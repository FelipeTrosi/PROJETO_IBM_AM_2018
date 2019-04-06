package br.com.remider.beans;

public class Medicamento implements Comparable<Medicamento> {
	
	private int codigo;
	private String nomeMedicamento;
	private String nomeFicticio;
	private int quantidadeMedicamento;
	private String descricaoMedicamento;
	private String dataCadastro;
	private String foto;
	
	public int compareTo(Medicamento outro) {
		if(this.codigo<outro.codigo) {
			return -1;
		}else if(this.codigo>outro.codigo){
			return 1;
		}else {
			return 0;
		}
	}
	
	public void setAll(int codigo, String nomeMedicamento, String nomeFicticio, int quantidadeMedicamento,
			String descricaoMedicamento, String dataCadastro, String foto) {
		setCodigo(codigo);
		setNomeMedicamento(nomeMedicamento);
		setNomeFicticio(nomeFicticio);
		setQuantidadeMedicamento(quantidadeMedicamento);
		setDescricaoMedicamento(descricaoMedicamento);
		setDataCadastro(dataCadastro);
		setFoto(foto);
	}
	
	public String getResumo() {
		return codigo + "\n" + nomeMedicamento + "\n" + nomeFicticio + "\n" + descricaoMedicamento + "\n" + foto;
	}
	
	public String getAll() {
		return codigo + "\n" + nomeMedicamento + "\n" + nomeFicticio + "\n" + quantidadeMedicamento + "\n" + descricaoMedicamento + "\n" + dataCadastro + "\n" + foto;
	}
	
	public Medicamento(int codigo) {
		setCodigo(codigo);
	}
	public Medicamento(int codigo, String nomeMedicamento, String nomeFicticio,String descricaoMedicamento,String foto) {
		setCodigo(codigo);
		setNomeMedicamento(nomeMedicamento);
		setNomeFicticio(nomeFicticio);
		setDescricaoMedicamento(descricaoMedicamento);
		setFoto(foto);
	}
	
	public Medicamento() {
		
	}
	public Medicamento(int codigo, String nomeMedicamento, String nomeFicticio, int quantidadeMedicamento,
			String descricaoMedicamento, String dataCadastro, String foto) {
		setCodigo(codigo);
		setNomeMedicamento(nomeMedicamento);
		setNomeFicticio(nomeFicticio);
		setQuantidadeMedicamento(quantidadeMedicamento);
		setDescricaoMedicamento(descricaoMedicamento);
		setDataCadastro(dataCadastro);
		setFoto(foto);
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNomeMedicamento() {
		return nomeMedicamento;
	}
	public void setNomeMedicamento(String nomeMedicamento) {
		this.nomeMedicamento = nomeMedicamento;
	}
	public String getNomeFicticio() {
		return nomeFicticio;
	}
	public void setNomeFicticio(String nomeFicticio) {
		this.nomeFicticio = nomeFicticio;
	}
	public int getQuantidadeMedicamento() {
		return quantidadeMedicamento;
	}
	public void setQuantidadeMedicamento(int quantidadeMedicamento) {
		this.quantidadeMedicamento = quantidadeMedicamento;
	}
	public String getDescricaoMedicamento() {
		return descricaoMedicamento;
	}
	public void setDescricaoMedicamento(String descricaoMedicamento) {
		this.descricaoMedicamento = descricaoMedicamento;
	}
	public String getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	

}
