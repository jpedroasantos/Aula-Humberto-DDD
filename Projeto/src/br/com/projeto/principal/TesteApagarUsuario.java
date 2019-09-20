package br.com.projeto.principal;

import javax.swing.JOptionPane;

import br.com.projeto.dao.UsuarioDAO;

public class TesteApagarUsuario {

	public static void main(String[] args) {
		UsuarioDAO dao = null;
		try {
		dao = new UsuarioDAO();
		if (dao.deletarUser(Integer.parseInt
				(JOptionPane.showInputDialog
				("Digite o codigo: "))) == 0) {
			System.out.println("Usuario não encontrado");
		} else {
			System.out.println("E morreu");
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
