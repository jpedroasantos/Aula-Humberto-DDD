package br.com.colecoes.teste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.colecoes.beans.Cargo;

public class TesteLista {

	public static void main(String[] args) {
		//Sempre 
		List<Cargo> lista = new ArrayList<Cargo>(); 
		
		lista.add(new Cargo("ESTAGIARIO", "JUNIOR",3000)); 
		lista.add(new Cargo("DBA", "TRAINEE", 1500)); 
		lista.add(new Cargo("ANALISTA", "JUNIOR", 400));
		
		Collections.sort(lista);
		for (Cargo objeto : lista) {
			System.out.println(objeto.getNome()); 
			System.out.println(objeto.getNivel()); 
			System.out.println(objeto.getSalario());
		} 
		System.out.println(lista.get(2));
	}

}
