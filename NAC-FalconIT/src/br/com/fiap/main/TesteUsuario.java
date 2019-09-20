package br.com.fiap.main;

import javax.swing.JOptionPane;


import br.com.fiap.bo.UsuarioBO;
import br.com.fiap.model.Usuario;

public class TesteUsuario {

	public static void main(String[] args) {
		try {
			
			UsuarioBO bo = new UsuarioBO();
			Usuario u = new Usuario();  
			u.setNome(JOptionPane.showInputDialog("Digite o nome: ")); 
			u.setEmail(JOptionPane.showInputDialog("Digite o email: ")); 
			u.setRm(JOptionPane.showInputDialog("Digite o rm: "));
			u.setSenha(JOptionPane.showInputDialog("Digite a senha: ")); 
			if(bo.novoUsuario(u) == 0) {
				System.out.println("Usuario não cadastrado");
			} else {
				System.out.println("Usuario cadastrado com sucesso");
			}
		} catch (Exception e){
			e.printStackTrace();
		} 
	}
}
