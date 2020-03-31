import java.util.Scanner;

public class UIBMain {
	
	public static void main(String[] args) {
		final int TOTAL_CONTAS = 2;
		
		Scanner leTeclado = new Scanner(System.in);
		
		Conta[] contas = new Conta[TOTAL_CONTAS];
		
		System.out.println("Bem vindo ao UIB!");
		System.out.println("-----------------");
		
		for (int i = 0; i < TOTAL_CONTAS; i++) {
			Cliente cliente = new Cliente();
			Conta conta = new Conta();
			
			conta.setNumero(Conta.gerarNumero());
			
			System.out.println("Digite o nome do Cliente");
			cliente.setNome(leTeclado.next());
			
			System.out.println("Digite o cpf do Cliente");
			cliente.setCpf(leTeclado.next());
			
			System.out.println("Digite valor do deposito inicial");
			conta.creditar(leTeclado.nextDouble());
			
			conta.setCliente(cliente);
			contas[i] = conta;
		}
		
		contas[0].debitar(100); //Sergio 400 - Marcio 200 
		contas[0].creditar(20); //Sergio 420 - Marcio 200 
		contas[1].transferir(contas[0], 50); //Sergio 470 - Marcio 150
		
		for (int i = 0; i < TOTAL_CONTAS; i++) {
			System.out.println(contas[i]);
		}
	}
}
