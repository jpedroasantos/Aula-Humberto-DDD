package br.com.livro.beans;

public class Livro {
	private int codigo; 
	private String nm_livro; 
	private String nm_autor; 
	private int vl_livro; 
	private Editora editora;
	
	public Livro(int codigo, String nm_livro, String nm_autor, int vl_livro, Editora editora) {
		super();
		this.codigo = codigo;
		this.nm_livro = nm_livro;
		this.nm_autor = nm_autor;
		this.vl_livro = vl_livro;
		this.editora = editora;
	}
	public Livro() {
		super();
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNm_livro() {
		return nm_livro;
	}
	public void setNm_livro(String nm_livro) {
		this.nm_livro = nm_livro;
	}
	public String getNm_autor() {
		return nm_autor;
	}
	public void setNm_autor(String nm_autor) {
		this.nm_autor = nm_autor;
	}
	public int getVl_livro() {
		return vl_livro;
	}
	public void setVl_livro(int vl_livro) {
		this.vl_livro = vl_livro;
	}
	public Editora getEditora() {
		return editora;
	}
	public void setEditora(Editora editora) {
		this.editora = editora;
	} 
}
