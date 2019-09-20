package br.com.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.projeto.beans.Assinatura;
import br.com.projeto.beans.Usuario;
import br.com.projeto.conexao.Conexao;

public class AssinaturaDAO {
	private Connection con; 
	private PreparedStatement stmt; 
	private ResultSet rs; 
	
	
	public AssinaturaDAO() throws Exception{ 
		con = Conexao.queroConectar();
	} 
	/*
	 Select
	public Assinatura getAssinatura(int codigo) throws Exception {
		stmt = con.prepareStatement("SELECT * from RW_T_ASSINATURA where CD_ASSINATURA=?"); 
		stmt.setInt(1, codigo); 
		rs = stmt.executeQuery(); 
		if(rs.next()) {
			return new Assinatura(
					rs.getInt("CD_ASSINATURA"), 
					rs.getString("TP_ASSINATURA"), 
					rs.getDouble("VL_ASSINATURA"), 
					rs.getString("DT_ASSINATURA"), 
					new UsuarioDAO().getUser(rs.getInt("CD_USUARIO"))
					);
		} else {
			return new Assinatura();
		}
	}
	*/ 
	
	//Inner Join
	public Assinatura getAssinatura(int codigo) throws Exception {
		stmt = con.prepareStatement("SELECT * from RW_T_ASSINATURA INNER JOIN "
				+ "RW_T_USUARIO ON RW_T_ASSINATURA.CD_USUARIO = "
				+ "RW_T_USUARIO.CD_USUARIO WHERE CD_ASSINATURA=?"); 
		stmt.setInt(1, codigo); 
		rs = stmt.executeQuery(); 
		if(rs.next()) {
			return new Assinatura(
					rs.getInt("CD_ASSINATURA"), 
					rs.getString("TP_ASSINATURA"), 
					rs.getDouble("VL_ASSINATURA"), 
					rs.getString("DT_ASSINATURA"), 
					new Usuario(
							rs.getInt("CD_USUARIO"), 
							rs.getString("NM_USUARIO"), 
							rs.getString("PW_SENHA")
							)
					);
		} else {
			return new Assinatura();
		}
	}
	public int addAssinatura(Assinatura a) throws Exception {
		stmt = con.prepareStatement("INSERT INTO RW_T_ASSINATURA"
				+ "(CD_ASSINATURA, "
				+ "TP_ASSINATURA, VL_ASSINATURA, "
				+ "DT_ASSINATURA, CD_USUARIO) VALUES(?,?,?,?,?)"); 
		stmt.setInt(1, a.getCodigo());
		stmt.setString(2, a.getTipo());
		stmt.setDouble(3, a.getValor());
		stmt.setString(4, a.getData());
		stmt.setInt(5, a.getUsuario().getCodigo()); 
		return stmt.executeUpdate();
	}
	
	public boolean verificarUsuario(int codigoUsuario) throws Exception {
		stmt = con.prepareStatement("SELECT * FROM RW_T_ASSINATURA WHERE CD_USUARIO=?"); 
		stmt.setInt(1, codigoUsuario); 
		rs = stmt.executeQuery(); 
		return rs.next();
	}
	
	public void encerrar() throws Exception{
		con.close();
	}
}
