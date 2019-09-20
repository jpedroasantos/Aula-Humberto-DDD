package br.com.descanso.beans;

public class Produto { 
	private int cod_prod;
	private String desc_prod; 
	private int valor_prod; 
	private int quant_prod;
	
	
	public Produto(int cod_prod, String desc_prod, int valor_prod, int quant_prod) {
		super();
		this.cod_prod = cod_prod;
		this.desc_prod = desc_prod;
		this.valor_prod = valor_prod;
		this.quant_prod = quant_prod;
	} 
	public Produto() {
		super();
	}
	public int getCod_prod() {
		return cod_prod;
	}
	public void setCod_prod(int cod_prod) {
		this.cod_prod = cod_prod;
	}
	public String getDesc_prod() {
		return desc_prod;
	}
	public void setDesc_prod(String desc_prod) {
		this.desc_prod = desc_prod;
	}

	public int getValor_prod() {
		return valor_prod;
	}

	public void setValor_prod(int valor_prod) {
		this.valor_prod = valor_prod;
	}

	public int getQuant_prod() {
		return quant_prod;
	}

	public void setQuant_prod(int quant_prod) {
		this.quant_prod = quant_prod;
	}  
}
