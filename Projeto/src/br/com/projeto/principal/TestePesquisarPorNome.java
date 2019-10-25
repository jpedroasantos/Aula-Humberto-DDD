package br.com.projeto.principal;

import java.util.List;

import br.com.projeto.beans.Usuario;
import br.com.projeto.bo.UsuarioBO;

public class TestePesquisarPorNome {

	public static void main(String[] args) {
		try {
			List<Usuario> lista = 
					UsuarioBO.perquisarPorNome(""); 
			for(Usuario u : lista) {
				System.out.println(u.getCodigo());
				System.out.println(u.getNome()); 
				System.out.println(u.getSenha());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
