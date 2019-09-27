package br.com.colecoes.teste;

import java.util.HashSet;
import java.util.Set;

public class TesteSet {

	public static void main(String[] args) {
		Set<String> lista = new HashSet<String>(); 
		lista.add("DEV"); 
		lista.add("DBA"); 
		lista.add("DBA"); 
		lista.add("Analista"); 
		
		System.out.println(lista);

	}

}
