package br.com.remider.excecao;

public class Excecao {
	public static String tratarExcecao(Exception e) {
		if(e.getClass().getName().equals("java.sql.SQLException")) {
			return "Ocorreu um erro ao conectar ao banco";
		}else if(e.getClass().getName().equalsIgnoreCase("java.lang.NumberFormatException")) {
			return "N�mero inv�lido";
		}else {
			return "Deu ruim";
		}
	}
}
