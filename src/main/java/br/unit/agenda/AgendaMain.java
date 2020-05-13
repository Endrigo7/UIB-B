package br.unit.agenda;

import java.util.Scanner;

import br.unit.agenda.model.Contato;

public class AgendaMain {

	public static void main(String[] args) {
		Scanner leTeclado = new Scanner(System.in);
		
		Contato[] contatos = new Contato[10];
		
		AgendaUtil agenda = new AgendaUtil();
		
		int opcao = -1;
		do {
		
			agenda.imprimeMenu();
			opcao = leTeclado.nextInt();
			
			switch (opcao) {
			case 1:
				Contato contato = agenda.criaContato(leTeclado); 
				
				break;

			default:
				break;
			}
			
		}while(opcao != 5);
		
		leTeclado.close();
	}
	
	

}
