package br.com.livro.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conex�o {
	
	public static Connection queroConectar() throws Exception {
		return DriverManager.getConnection
		("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL","rm82680","070801");
	}
}
