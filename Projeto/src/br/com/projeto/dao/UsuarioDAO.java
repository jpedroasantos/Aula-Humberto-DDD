package br.com.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.projeto.beans.Usuario;
import br.com.projeto.conexao.Conexao;

public class UsuarioDAO { 
	
	private Connection con; 
	private PreparedStatement stmt; 
	private ResultSet rs; 
	
	public UsuarioDAO() throws Exception{
		con = Conexao.queroConectar();
	}

	public Usuario getUser(int codigo) throws Exception {
		stmt = con.prepareStatement
				("select * from RW_T_USUARIO where CD_USUARIO=?");
		stmt.setInt(1, codigo);
		rs = stmt.executeQuery();
		if (rs.next()) { 
			return new Usuario(
					rs.getInt("CD_USUARIO"),
					rs.getString("NM_USUARIO"),
					rs.getString("PW_USUARIO")
					);
		} else {
			return new Usuario();
		}
	} 
	public int deletarUser(int codigo) throws Exception {
		stmt = con.prepareStatement
				("delete from RW_T_USUARIO where CD_USUARIO=?"); 
		stmt.setInt(1, codigo); 
		return stmt.executeUpdate();
	}
	
	public int addUser(Usuario u) throws Exception{
		stmt = con.prepareStatement("INSERT INTO "
				+ "RW_T_USUARIO(CD_USUARIO, NM_USUARIO, PW_USUARIO) "
				+ "VALUES(?,?,?)");
		stmt.setInt(1, u.getCodigo());
		stmt.setString(2, u.getNome());
		stmt.setString(3, u.getSenha());
		return stmt.executeUpdate();
	}
	
	public void encerrar() throws Exception{
		con.close();
	}
}
