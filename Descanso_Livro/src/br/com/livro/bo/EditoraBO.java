package br.com.livro.bo;

import br.com.livro.beans.Editora;
import br.com.livro.dao.EditoraDAO;
import br.com.livro.dao.LivroDAO;

public class EditoraBO {
	
	public int novaEditora(Editora objEditora) throws Exception {
		if(objEditora.getNm_editora().length() > 40) {
			throw new RuntimeException("Excedeu caracteres"); 
		} 
		if(objEditora.getNm_editora().length() <= 3) {
			throw new RuntimeException("Poucos caracteres");
		} 
		objEditora.setNm_editora(objEditora.getNm_editora().toUpperCase());
		EditoraDAO dao = new EditoraDAO(); 
		if(dao.getEditora(objEditora.getCodigo()).getCodigo() == 0) {
			dao.addEditora(objEditora); 
			dao.encerrar(); 
			return 1;
		} else {
			dao.encerrar(); 
			return 0;
		}
	}  
	
	public String excluirEditora(int codigo) throws Exception {
		if(codigo <= 0) {
			return "Codigo inválido";
		} 
		EditoraDAO dao = new EditoraDAO(); 
		if(dao.getEditora(codigo).getCodigo() == 0) {
			dao.encerrar(); 
			return "Editora inexistente";
		} 
		LivroDAO dao2 = new LivroDAO(); 
		if(dao2.verificarLivro(codigo)==true) {
			return "Editora em uso";
		} 
		dao.deletarEditora(codigo); 
		dao.encerrar(); 
		dao2.encerrar(); 
		return "Editora excluida";
	}
}
