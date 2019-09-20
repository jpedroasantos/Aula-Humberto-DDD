package br.com.fiap.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class JDBC_3 {

	public static void main(String[] args) {
		try {
			Connection c = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "rm82680",
					"070801");
			System.out.println("Conectou");
			Statement stmt = c.createStatement();
			
			String login = JOptionPane.showInputDialog("Digite o login: "); 
			String senha = JOptionPane.showInputDialog("Digite a senha: ");
			
			ResultSet rs = stmt.executeQuery("select * from RW_T_USUARIO where NM_USUARIO = '"+login+"' and PW_USUARIO = '"+senha+"'");
			if(rs.next()) {
				System.out.println("Logado");
			} else {
				System.out.println("Não autorizado");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
