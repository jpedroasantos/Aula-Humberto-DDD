package br.com.colecoes.teste;

import java.util.HashMap;
import java.util.Map;

import br.com.colecoes.beans.Cargo;

public class TesteMap {

	public static void main(String[] args) {
		Map<String, Cargo> lista = new HashMap<String,Cargo>(); 
		lista.put("ABC", new Cargo("ESTAGIARIO", "JUNIOR",3000)); 
		lista.put("ABC", new Cargo("ESTAGIARIO", "SENIOR",6000));  
		System.out.println(lista); 
		//retorna as chaves
		System.out.println(lista.keySet()); 
		//pesquisa pela chave
		System.out.println(lista.get("ABC").getNome()); 
		//retorna todos os dados 
		for(Cargo c : lista.values()) {
			System.out.println(c.getNome()); 
			System.out.println(c.getNivel()); 
			System.out.println(c.getSalario());
		}
	}

}
