package br.com.fiap.model;

public class Usuario {
	private int id_usuario;
	private String nome;
	private String email;
	private String rm;
	private String senha;
	
	public Usuario(int id_usuario, String nome, String email, String rm, String senha) {
		super();
		this.id_usuario = id_usuario;
		this.nome = nome;
		this.email = email;
		this.rm = rm;
		this.senha = senha;
	} 
	public Usuario() {
		super();
	}

	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRm() {
		return rm;
	}
	public void setRm(String rm) {
		this.rm = rm;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
