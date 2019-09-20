package br.com.livro.excessao;

import javax.swing.JOptionPane;

import br.com.livro.beans.Editora;
import br.com.livro.bo.EditoraBO;


public class TestarGravarEditora {

	public static void main(String[] args) {
		try {
			EditoraBO bo = new EditoraBO();
			Editora e = new Editora(); 
			e.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo: ")));
			e.setNm_editora((JOptionPane.showInputDialog("Digite o nome da editora: "))); 
			e.setNr_telefone(Integer.parseInt(JOptionPane.showInputDialog("Digite o nome: "))); 
			e.setNm_email((JOptionPane.showInputDialog("Digite o email: ")));
			if(bo.novaEditora(e) == 1) {
				System.out.println("Cadastrado com sucesso!");
			} else {
				System.out.println("Não cadastrado!");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	}

