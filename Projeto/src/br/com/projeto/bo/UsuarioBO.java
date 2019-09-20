package br.com.projeto.bo;

import br.com.projeto.beans.Usuario;
import br.com.projeto.dao.AssinaturaDAO;
import br.com.projeto.dao.UsuarioDAO;

public class UsuarioBO {
	
	public int novoUsuario(Usuario objUsuario) throws Exception{
		if(objUsuario.getNome().length() > 50) {
			throw new RuntimeException("Excedeu caracteres");
		} 
		if(objUsuario.getNome().length() <= 3) {
			throw new RuntimeException("Poucos caracteres");
		} 
		if(objUsuario.getSenha().length() < 3 || objUsuario.getSenha().length() > 15) {
			throw new RuntimeException("Senha deve estar entre 3 e 15 caracteres");
		} 
		objUsuario.setNome(objUsuario.getNome().toUpperCase());
		UsuarioDAO dao = new UsuarioDAO(); 
		if (dao.getUser(objUsuario.getCodigo()).getCodigo()==0) {
			dao.addUser(objUsuario); 
			dao.encerrar(); 
			return 1;
		} else {  
			dao.encerrar();
			return 0;
		}
	} 
	
	public String excluirUsuario(int codigo) throws Exception{
		if(codigo <= 0) {
			return "Codigo inválido";
		} 
		UsuarioDAO dao = new UsuarioDAO(); 
		if (dao.getUser(codigo).getCodigo() == 0) {
			dao.encerrar();
			return "Usuário inexistente";
		} 
		AssinaturaDAO dao2 = new AssinaturaDAO(); 
		if(dao2.verificarUsuario(codigo)==true) {
			return "Usuario em uso"; 
		} 
		dao.deletarUser(codigo); 
		dao.encerrar(); 
		dao2.encerrar();
		return "Usuario excluido";
		
	}
}
