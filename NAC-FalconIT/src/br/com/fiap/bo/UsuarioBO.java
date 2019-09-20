package br.com.fiap.bo;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.model.Usuario;

public class UsuarioBO {
	public int novoUsuario(Usuario objUsuario) throws Exception{
		if(objUsuario.getNome().length() > 50) {
			System.out.println("Nome muito longo");
		} 
		if(objUsuario.getNome().length() <= 3) {
			System.out.println("Nome muito curto");
		}  
		if(objUsuario.getEmail().length() > 50) {
			System.out.println("Email muito longo");
		} 
		if(objUsuario.getEmail().length() < 3) {
			System.out.println("Email muito curto");
		}  
		if(objUsuario.getEmail().indexOf("@") < 0) {
			System.out.println("@ necessario");
		}
		if(objUsuario.getRm().length() > 7) {
			System.out.println("RM muito longo");
		} 
		if(objUsuario.getRm().length() < 5) {
			System.out.println("RM muito curto");
		} 
		
		if(objUsuario.getSenha().length() < 3 || objUsuario.getSenha().length() > 20) {
			System.out.println("Senha deve estar entre 3 e 15 caracteres");
		} 
		objUsuario.setNome(objUsuario.getNome().toUpperCase());
		UsuarioDAO dao = new UsuarioDAO(); 
		if (dao.getUser(objUsuario.getId_usuario()).getId_usuario()==0) {
			dao.addUser(objUsuario); 
			dao.encerrar(); 
			return 1;
		} else { 
			dao.encerrar();
			return 0;
		}
	}
}
