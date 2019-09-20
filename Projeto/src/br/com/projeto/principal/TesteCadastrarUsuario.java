package br.com.projeto.principal;

import javax.swing.JOptionPane;

import br.com.projeto.beans.Usuario;
import br.com.projeto.dao.UsuarioDAO;

public class TesteCadastrarUsuario {
	
	public static void main(String[] args) {
		UsuarioDAO dao = null;
		try {
			dao = new UsuarioDAO();
			Usuario usu = new Usuario(); 
			usu.setCodigo(Integer.parseInt
					(JOptionPane.showInputDialog
					("Digite o codigo: ")));
			usu.setNome((JOptionPane.showInputDialog("Digite o nome: "))); 
			usu.setSenha((JOptionPane.showInputDialog("Digite a senha: "))); 
			if(dao.addUser(usu) == 0) {
				System.out.println("Não cadastrado!");
			} else {
				System.out.println("Cadastrado com sucesso!");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dao.encerrar();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
