package br.com.projeto.principal;

import javax.swing.JOptionPane;

import br.com.projeto.beans.Assinatura;
import br.com.projeto.beans.Usuario;
import br.com.projeto.dao.AssinaturaDAO;

public class TesteGravarAssinatura {

	public static void main(String[] args) {
		AssinaturaDAO dao = null;  
		try {
			dao = new AssinaturaDAO(); 
			Assinatura a = new Assinatura(); 
			a.setCodigo(Integer.parseInt(JOptionPane.showInputDialog
					("Digite o codigo: "))); 
			a.setTipo(JOptionPane.showInputDialog("Digite o tipo: "));
			a.setValor(Double.parseDouble(JOptionPane.showInputDialog("Digite o valor: ")));
			a.setData(JOptionPane.showInputDialog("Digite a data: "));
			Usuario u = new Usuario(); 
			a.setUsuario(u);
			u.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Codigo: "))); 
			u.setNome(JOptionPane.showInputDialog("Nome: ")); 
			u.setSenha(JOptionPane.showInputDialog("Senha: ")); 
			if(dao.addAssinatura(a) == 0) {
				System.out.println("Não gravou!");
			} else {
				System.out.println("Gravado com sucesso!");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dao.encerrar();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}
