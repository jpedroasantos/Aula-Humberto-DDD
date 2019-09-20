package br.com.livro.beans;

public class Editora {
	private int codigo; 
	private String nm_editora; 
	private int nr_telefone; 
	private String nm_email;
	
	public Editora(int codigo, String nm_editora, int nr_telefone, String nm_email) {
		super();
		this.codigo = codigo;
		this.nm_editora = nm_editora;
		this.nr_telefone = nr_telefone;
		this.nm_email = nm_email;
	}
	public Editora() {
		super();
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNm_editora() {
		return nm_editora;
	}
	public void setNm_editora(String nm_editora) {
		this.nm_editora = nm_editora;
	}
	public int getNr_telefone() {
		return nr_telefone;
	}
	public void setNr_telefone(int nr_telefone) {
		this.nr_telefone = nr_telefone;
	}
	public String getNm_email() {
		return nm_email;
	}
	public void setNm_email(String nm_email) {
		this.nm_email = nm_email;
	} 
}
