package br.com.livro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.livro.beans.Editora;
import br.com.livro.conexao.Conexão;

public class EditoraDAO {
	private Connection con; 
	private PreparedStatement stmt; 
	private ResultSet rs; 
	
	public EditoraDAO() throws Exception{
		con = Conexão.queroConectar();
	} 
	
	public Editora getEditora(int codigo) throws Exception{
		stmt = con.prepareStatement("select * from RW_T_EDITORA where ID_EDITORA = ?"); 
		stmt.setInt(1, codigo); 
		rs = stmt.executeQuery(); 
		if(rs.next()) {
			return new Editora(
					rs.getInt("ID_EDITORA"), 
					rs.getString("NM_EDITORA"), 
					rs.getInt("NR_TELEFONE"), 
					rs.getString("NM_EMAIL")
					);
		} else {
			return new Editora();
		} 
	} 
	public int deletarEditora(int codigo) throws Exception {
		stmt = con.prepareStatement
				("delete from RW_T_EDITORA where ID_EDITORA=?"); 
		stmt.setInt(1, codigo); 
		return stmt.executeUpdate();
	}
	
	public int addEditora(Editora e) throws Exception{
		stmt = con.prepareStatement("INSERT INTO "
				+ "RW_T_EDITORA(ID_EDITORA, NM_EDITORA, NR_TELEFONE, NM_EMAIL) "
				+ "VALUES(?,?,?,?)");
		stmt.setInt(1, e.getCodigo());
		stmt.setString(2, e.getNm_editora());
		stmt.setInt(3, e.getNr_telefone()); 
		stmt.setString(4, e.getNm_email());
		return stmt.executeUpdate();
	} 
	public void encerrar() throws Exception{
		con.close();
	}
}
