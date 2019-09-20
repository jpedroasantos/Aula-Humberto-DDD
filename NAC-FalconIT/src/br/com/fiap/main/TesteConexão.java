package br.com.fiap.main;

import java.sql.Connection;

import br.com.fiap.conex�o.Conexao;

public class TesteConex�o {

	public static void main(String[] args) {
		Connection conectar = null;
		try {
			conectar = Conexao.queroConectar();
			System.out.println("Conectou");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conectar.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
