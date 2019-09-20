package br.com.livro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.livro.beans.Livro;
import br.com.livro.conexao.Conexão;


public class LivroDAO {
	private Connection con; 
	private PreparedStatement stmt; 
	private ResultSet rs; 
	
	public LivroDAO() throws Exception{ 
		con = Conexão.queroConectar();
	}  
	
	public int addLivro(Livro l) throws Exception {
		stmt = con.prepareStatement("INSERT INTO RW_T_LIVROS"
				+ "(NR_ISBN, "
				+ "NM_LIVRO, NM_AUTOR, "
				+ "VL_LIVRO, ID_EDITORA) VALUES(?,?,?,?,?)"); 
		stmt.setInt(1, l.getCodigo());
		stmt.setString(2, l.getNm_livro());
		stmt.setString(3, l.getNm_autor());
		stmt.setInt(4, l.getVl_livro());
		stmt.setInt(5, l.getEditora().getCodigo()); 
		return stmt.executeUpdate();
	} 
	
	public boolean verificarLivro(int codigoLivro) throws Exception {
		stmt = con.prepareStatement("SELECT * FROM RW_T_LIVROS WHERE NR_ISBN=?"); 
		stmt.setInt(1, codigoLivro); 
		rs = stmt.executeQuery(); 
		return rs.next();
	}  
	
	public int deletarLivro(int codigo) throws Exception {
		stmt = con.prepareStatement
				("delete from RW_T_LIVROS where NR_ISBN=?"); 
		stmt.setInt(1, codigo); 
		return stmt.executeUpdate();
	}
	
	public void encerrar() throws Exception{
		con.close();
	}
}
