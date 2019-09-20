package br.com.projeto.principal;

import br.com.projeto.beans.Usuario;
import br.com.projeto.dao.UsuarioDAO;

public class TesteConsultarUsuario {

	public static void main(String[] args) {
		UsuarioDAO dao = null; 
		try {
			dao = new UsuarioDAO();
			Usuario u = dao.getUser(1); 
			System.out.println(u.getNome()); 
			System.out.println(u.getSenha()); 
		} catch(Exception e) {
			e.printStackTrace();
		} finally { 
			try {
			dao.encerrar(); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
