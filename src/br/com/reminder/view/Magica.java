package br.com.reminder.view;

import javax.swing.JOptionPane;

public class Magica {
	public static String texto(String msg) {
		return JOptionPane.showInputDialog(msg).toUpperCase();
	}
	
	public static int inteiro(String msg) {
		return Integer.parseInt(texto(msg));
	}
	
	public static double decimal(String msg) {
		return Double.parseDouble(texto(msg));
	}
	
	public static char chare(String msg) {
		char resposta = texto(msg).toUpperCase().charAt(0);
		return resposta;
	}
}
