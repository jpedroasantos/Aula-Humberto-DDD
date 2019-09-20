package br.com.fiap.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class JDBC_4 {

	public static void main(String[] args) {
		try {
			Connection c = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL","rm82680",
					"070801");
			System.out.println("Conectou");
			PreparedStatement stmt = c.prepareStatement
					("select * from RW_T_USUARIO where NM_USUARIO = ? and PW_USUARIO =?");
			
			String login = JOptionPane.showInputDialog("Digite o login: "); 
			String senha = JOptionPane.showInputDialog("Digite a senha: ");
			
			stmt.setString(1, login);
			stmt.setString(2, senha);
			
			ResultSet rs = stmt.executeQuery();
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
