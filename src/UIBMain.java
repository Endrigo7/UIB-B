import java.util.Scanner;

public class UIBMain {
	
	private static final int TOTAL_CONTAS = 2;
	
	public static void main(String[] args) {
		Scanner leTeclado = new Scanner(System.in);
		Conta[] contas = new Conta[TOTAL_CONTAS];
		
		System.out.println("Bem vindo ao Unit Internet Bank"); 
		System.out.println("-------------------------------");
		
		int indice = 0;
		int opcao = -1;
		do {
			imprimeMenu();
			opcao = leTeclado.nextInt();

			switch (opcao) {
			case 1:
				Conta conta = montaConta();
				System.out.println("O numero da sua conta eh: " + conta.getNumero());
				
				contas[indice] = conta;
				indice++;
				break;
			case 2:
				conta = buscarConta(contas);
				if(conta != null) {
					System.out.println("seu saldo eh:" + conta.getSaldo());
				}
				
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				System.out.println("Obrigado por usa o  Unit Internet Bank"); 
				System.out.println("--------------------------------------");
				break;	
			default:
				System.out.println("Opção invalida! Selecione novamente!");
				break;
			}
			
		}while(opcao != 6);
	}
	
	private static void imprimeMenu() {
		System.out.println("[1] - Abrir Conta");
		System.out.println("[2] - consulta saldo");
		System.out.println("[3] - creditar em conta");
		System.out.println("[4] - debitar em conta");
		System.out.println("[5] - Transferir");
		System.out.println("[6] - sair");
	}
	
	private static Cliente montaCliente() {
		Scanner leTeclado = new Scanner(System.in);
		
		System.out.println("Digite o cpf do Cliente");
		String cpf = leTeclado.next();
		
		System.out.println("Digite o nome do Cliente");
		String nome = leTeclado.next();
		
		Cliente cliente = new Cliente(nome, cpf);
		return cliente;
	}
	
	private static Conta montaConta() {
		Scanner leTeclado = new Scanner(System.in);
		
		Cliente cliente = montaCliente();
		
		System.out.println("Digite a sua senha");
		String senha = leTeclado.next();
		String senhaHash = SenhaUtil.geraHash(senha);
		
		System.out.println("Digite valor do deposito inicial");
		double saldoInicial = leTeclado.nextDouble();
		
		String numero = Conta.gerarNumero();
		
		Conta conta = new Conta(numero, saldoInicial, cliente, senhaHash);
		return conta;
	}
	
	private static Conta buscarConta(Conta[] contas) {
		Scanner leTeclado = new Scanner(System.in);
		
		System.out.println("Digite o numero da Conta");
		String numero = leTeclado.next();
		
		System.out.println("Digite a sua senha");
		String senha = leTeclado.next();
		String senhaHash = SenhaUtil.geraHash(senha);
		
		for (Conta conta : contas) {
			if(conta != null) {
				if(conta.getNumero().equals(numero) //
						&& conta.getSenha().equals(senhaHash)) {
					return conta;
				}
			}
		}
		
		System.out.println("Conta " + numero +  " não encontrada!");
		return null;
	}
}
