package br.com.descanso.principal;

import br.com.descanso.beans.Produto;
import br.com.descanso.dao.ProdutoDAO;

public class TestarProdutoDAO {
int i = 1;
	public static void main(String[] args) {
		ProdutoDAO dao_prod = null;
		try {
			dao_prod = new ProdutoDAO(); 
			Produto p = dao_prod.getUser(1); 
			System.out.println("Descrição: "+p.getDesc_prod());
			System.out.println("Quantidade: "+p.getQuant_prod());
			System.out.println("Valor: "+p.getValor_prod());  
			System.out.println("Subtotal: "+p.getQuant_prod()*p.getValor_prod());
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dao_prod.encerrar();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
