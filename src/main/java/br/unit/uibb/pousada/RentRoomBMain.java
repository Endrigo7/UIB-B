package br.unit.uibb.pousada;
import java.util.Scanner;

public class RentRoomBMain {
	
	public static void main(String[] args) {
		Scanner leTeclado = new Scanner(System.in);
		
		Quarto[] quartos = new Quarto[10];
		
		for (int i = 0; i < quartos.length; i++) {
			Quarto quarto = new Quarto(i, i % 2 == 0 ? true : false);
			quartos[i] = quarto;
		}
		
		System.out.println("Digite o numero de quartos alugados");
		int numeroQuartosAlugados = leTeclado.nextInt();
		
		for (int i = 0; i < numeroQuartosAlugados; i++) {
			System.out.println("Digite o nome do Estudante");
			leTeclado.nextLine();
			String nome = leTeclado.nextLine(); 
			
			String email = "";
			while(true) {
				System.out.println("Digite o e-mail do Estudante");
				email = leTeclado.next();
				
				if( email.indexOf("@") == -1 || email.indexOf(".") == -1) {
					System.out.println("E-mail invalido!");
				} else {
					break;
				}
			}
			
			System.out.println("Digite o numero do quarto do Estudante");
			int numeroQuarto = leTeclado.nextInt();
			
			Estudante estudante = new Estudante(nome, email);
			quartos[numeroQuarto].setEstudante(estudante); 
		}
		
		for (Quarto quarto : quartos) {
			if(quarto.getEstudante() != null) {
				System.out.println(quarto);
			}
		}
		
		leTeclado.close();
	}
}
