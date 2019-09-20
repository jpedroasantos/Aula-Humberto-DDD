package br.com.projeto.principal;

import javax.swing.JOptionPane;

import br.com.projeto.beans.Usuario;
import br.com.projeto.bo.UsuarioBO;

public class TesteNovoUsuario {

	public static void main(String[] args) {
		try {
			UsuarioBO bo = new UsuarioBO();
			Usuario usu = new Usuario(); 
			usu.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo: ")));
			usu.setNome((JOptionPane.showInputDialog("Digite o nome: "))); 
			usu.setSenha((JOptionPane.showInputDialog("Digite a senha: "))); 
			if(bo.novoUsuario(usu) == 1) {
				System.out.println("Cadastrado com sucesso!");
			} else {
				System.out.println("Não cadastrado!");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
