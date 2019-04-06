package br.com.remider.beans;

public class Lembrete implements Comparable<Lembrete> {
	
	private int codigo;
	private int quantidadeLembretes;
	private String alarme;
	private UsoMedicamento usoMedicamento;

	public int compareTo(Lembrete outro) {
		if(this.codigo<outro.codigo) {
			return -1;
		}else if(this.codigo>outro.codigo){
			return 1;
		}else {
			return 0;
		}
	}
	
	public void setAll(int codigo, int quantidadeLembretes, String alarme, UsoMedicamento usoMedicamento) {
		
		setCodigo(codigo);
		setQuantidadeLembretes(quantidadeLembretes);
		setAlarme(alarme);
		setUsoMedicamento(usoMedicamento);
	}
	
	public String getAll() {
		return codigo + "\n" + quantidadeLembretes + "\n" + alarme + "\n" + usoMedicamento.getAll();
	}
	
	public String getResumo() {
		return codigo + "\n" + quantidadeLembretes + "\n" + alarme + "\n" + usoMedicamento.getResumo();
	}
	public Lembrete() {
		
	}
	
	public Lembrete(int codigo) {
		setCodigo(codigo);
	}
	public Lembrete(int codigo, int quantidadeLembretes, String alarme, UsoMedicamento usoMedicamento) {
		
		setCodigo(codigo);
		setQuantidadeLembretes(quantidadeLembretes);
		setAlarme(alarme);
		setUsoMedicamento(usoMedicamento);
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getQuantidadeLembretes() {
		return quantidadeLembretes;
	}
	public void setQuantidadeLembretes(int quantidadeLembretes) {
		this.quantidadeLembretes = quantidadeLembretes;
	}
	public String getAlarme() {
		return alarme;
	}
	public void setAlarme(String alarme) {
		this.alarme = alarme;
	}
	public UsoMedicamento getUsoMedicamento() {
		return usoMedicamento;
	}
	public void setUsoMedicamento(UsoMedicamento usoMedicamento) {
		this.usoMedicamento = usoMedicamento;
	}
	
	
	

}
