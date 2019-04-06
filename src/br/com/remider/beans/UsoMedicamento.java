package br.com.remider.beans;

public class UsoMedicamento implements Comparable<UsoMedicamento> {
	private int codigo;
	private Usuario usuario;
	private Medicamento medicamento;
	private String dataInicio;
	private String dataTermino;

	public int compareTo(UsoMedicamento outro) {
		if(this.codigo<outro.codigo) {
			return -1;
		}else if(this.codigo>outro.codigo){
			return 1;
		}else {
			return 0;
		}
	}
	
	public void setAll(int codigo, Usuario usuario, Medicamento medicamento, String dataInicio, String dataTermino) {
		setCodigo(codigo);
		setUsuario(usuario);
		setMedicamento(medicamento);
		setDataInicio(dataInicio);
		setDataTermino(dataTermino);
	}
	
	public String getAll() {
		return codigo + "\n" + usuario.getAll() + "\n" + medicamento.getAll() + "\n" + dataInicio + "\n" + dataTermino;
	}
	
	
	public UsoMedicamento() {
		
	}
	
	
	public String getResumo() {
		return codigo + "\n" + usuario.getCodigo() + "\n" + usuario.getNome() + "\n" + medicamento.getResumo(); 
	}
	
	public UsoMedicamento(int codigo) {
		setCodigo(codigo);
	}

	public UsoMedicamento(int codigo, Usuario usuario, Medicamento medicamento, String dataInicio, String dataTermino) {
		setCodigo(codigo);
		setUsuario(usuario);
		setMedicamento(medicamento);
		setDataInicio(dataInicio);
		setDataTermino(dataTermino);
	}
	
	public UsoMedicamento(Usuario usuario) {
		setUsuario(usuario);
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(String dataTermino) {
		this.dataTermino = dataTermino;
	}

}
