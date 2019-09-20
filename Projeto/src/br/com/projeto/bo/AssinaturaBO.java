package br.com.projeto.bo;

import br.com.projeto.beans.Assinatura;
import br.com.projeto.beans.Usuario;
import br.com.projeto.dao.AssinaturaDAO;
import br.com.projeto.dao.UsuarioDAO;

public class AssinaturaBO {
	
	public static String novaAssinatura(Assinatura objeto) throws Exception {
		//Regra de Negocio
		if (objeto.getCodigo() <= 0) {
			return "Codigo inválido";
		} 
		if(objeto.getValor() < 0) {
			return "Valor não pode ser negativo";
		} 
		//Requisito Funcional
		if(objeto.getTipo().length() > 15) {
			return "Tipo excedeu qtde de caracteres";
		} 
		// verificando se a FK existe 
		UsuarioDAO usuDAO = new UsuarioDAO(); 
		Usuario objUsuario = 
				usuDAO.getUser(objeto.getUsuario().getCodigo()); 
		usuDAO.encerrar();
		if(objUsuario.getCodigo() == 0) {
			return "Usuario não existe";
		}
		
		//verificar se a PK não existe 
		AssinaturaDAO assDAO = new AssinaturaDAO(); 
		Assinatura objAssinatura = 
				assDAO.getAssinatura(objeto.getCodigo());
		if(objAssinatura.getCodigo() > 0) {
			return "Codigo da assinatura já existe"; 
		} 
		
		//Padronização 
		objeto.setTipo(objeto.getTipo().toUpperCase()); 
		
		//Finalização
		int x = assDAO.addAssinatura(objeto);  
		assDAO.encerrar();
		if(x == 0) {
			return "Assinatura não cadastrada";
		} else {
			return "Assinatura Cadastrada";
		}
	}
}
