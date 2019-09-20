package br.com.projeto.beans;

public class Assinatura {
	private int codigo; 
	private String tipo; 
	private double valor; 
	private String data; 
	private Usuario usuario;
	
	public Assinatura(int codigo, String tipo, double valor, String data, Usuario usuario) {
		super();
		this.codigo = codigo;
		this.tipo = tipo;
		this.valor = valor;
		this.data = data;
		this.usuario = usuario;
	}
	public Assinatura() {
		super();
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	} 
}
