package br.com.remider.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	/*
	public Connection conectar() throws Exception {
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "010800");
	}*/
	
	
	public Connection conectar() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		return DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM80805", "010800");

	}
	
}
