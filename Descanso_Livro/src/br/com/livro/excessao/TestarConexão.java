package br.com.livro.excessao;

import java.sql.Connection;

import br.com.livro.conexao.Conex�o;

public class TestarConex�o {

	public static void main(String[] args) {
		Connection conectar = null;
		try {
			conectar = Conex�o.queroConectar();
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
