package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.conexão.Conexao;
import br.com.fiap.model.Usuario;


public class UsuarioDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	public UsuarioDAO() throws Exception {
		con = Conexao.queroConectar();
	}
	
	public Usuario getUser(int id) throws Exception {
		stmt = con.prepareStatement
				("select * from NAC_USUARIO where ID_USUARIO=?");
		stmt.setInt(1, id);
		rs = stmt.executeQuery();
		if (rs.next()) { 
			return new Usuario(
					rs.getInt("ID_USUARIO"),
					rs.getString("NM_USUARIO"), 
					rs.getString("EMAIL_USUARIO"), 
					rs.getString("RM_USUARIO"),
					rs.getString("PW_USUARIO")
					);
		} else {
			return new Usuario();
		}
	} 
	
	public int addUser(Usuario u) throws Exception{ 
		stmt = con.prepareStatement("INSERT INTO "
				+ "NAC_USUARIO(ID_USUARIO, NM_USUARIO, EMAIL_USUARIO, RM_USUARIO, PW_USUARIO)"
				+ "VALUES(c_usuario_seq.nextval ,?,?,?,?)");  
		//stmt.setInt(1, u.getId_usuario());
		stmt.setString(1, u.getNome());
		stmt.setString(2, u.getEmail()); 
		stmt.setString(3, u.getRm());
		stmt.setString(4, u.getSenha());
		return stmt.executeUpdate();
	} 
	
	public void encerrar() throws Exception {
		con.close();
	}
}
