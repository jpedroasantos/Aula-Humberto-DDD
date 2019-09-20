package br.com.descanso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.descanso.beans.Produto;
import br.com.descanso.conexao.Conexao;

public class ProdutoDAO {
		
	private Connection con; 
	private PreparedStatement stmt; 
	private ResultSet rs; 
	 
	public ProdutoDAO() throws Exception{
		con = Conexao.queroConectar();
	} 
	
	public Produto getUser(int cod_prod) throws Exception{
		stmt = con.prepareStatement
				("select * from RW_T_PRODUTO where CD_PRODUTO=?"); 
		stmt.setInt(1, cod_prod);  
		rs = stmt.executeQuery(); 
		if(rs.next()) {
			return new Produto(
					rs.getInt("CD_PRODUTO"), 
					rs.getString("DS_PRODUTO"), 
					rs.getInt("VL_PRODUTO"), 
					rs.getInt("QT_PRODUTO")
					);
		} else {
			return new Produto();
		}
	} 
	public int deletarUser(int cod_prod) throws Exception {
		stmt = con.prepareStatement
				("delete from RW_T_PRODUTO where CD_PRODUTO=?"); 
		stmt.setInt(1, cod_prod); 
		return stmt.executeUpdate();
	}
	public void encerrar() throws Exception{
		con.close();
	}
}
