package br.com.livro.excessao;

import java.sql.Connection;

import br.com.livro.conexao.Conexão;

public class TestarConexão {

	public static void main(String[] args) {
		Connection conectar = null;
		try {
			conectar = Conexão.queroConectar();
			System.out.println("Conectou"); 
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			conectar.close(); 
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
