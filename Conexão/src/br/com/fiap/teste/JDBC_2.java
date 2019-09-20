package br.com.fiap.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class JDBC_2 {

	public static void main(String[] args) {
		try {
			Connection c = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "rm82680",
					"070801");
			System.out.println("Conectou");
			Statement stmt = c.createStatement();
			
			String pesquisa = JOptionPane.showInputDialog("Digite o nome: "); 
			
			ResultSet rs = stmt.executeQuery("select * from RW_T_USUARIO where NM_USUARIO LIKE '%"+pesquisa+"%'");
			while (rs.next()) {
				System.out.println(rs.getString("ID_USUARIO"));
				System.out.println(rs.getString("NM_USUARIO"));
				System.out.println(rs.getString("PW_USUARIO"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
