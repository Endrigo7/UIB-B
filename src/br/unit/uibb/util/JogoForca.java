package br.unit.uibb.util;

import java.util.Random;
import java.util.Scanner;

public class JogoForca {

	private static final int NUMERO_MAXIMO_DE_ERROS = 3;
	private static final String QUEBRAR_LINHA = "\n";
	private static final String[] CHAVES = { "azul", "amerelo", "verde", //
			"preto", "branco", "cinza", "laranja", "vermelho", "rosa" };

	public static void main(String[] args) {
		Scanner leTeclado = new Scanner(System.in);
		
		int totalErros = 0;
		int totalChances = NUMERO_MAXIMO_DE_ERROS;
		int totalLetrasCorretas = 0;

		String chave = gerarChave();
		String[] palavra = new String[chave.length()];

		for (int i = 0; i < palavra.length; i++) {
			palavra[i] = "_";
		}

		do {
			exibePalavra(palavra);

			System.out.println("Digite uma letra");
			String letraLida = leTeclado.next();

			boolean isAchou = false;
			for (int i = 0; i < chave.length(); i++) {
				String letra = String.valueOf(chave.charAt(i));

				if (letra.equalsIgnoreCase(letraLida)) {
					palavra[i] = letraLida;
					totalLetrasCorretas++;
					isAchou = true;
				}
			}

			if (totalLetrasCorretas == chave.length()) {
				break;
			}

			if (!isAchou) {
				totalErros++;
				totalChances = naoAchou(totalErros, letraLida); 			
			}
		} while (totalErros < NUMERO_MAXIMO_DE_ERROS);

		encerrarPartida(totalChances, chave);
		leTeclado.close();
	}

	private static void exibePalavra(String[] palavra) {
		for (int i = 0; i < palavra.length; i++) {
			System.out.print(palavra[i] + "  ");
		}
		System.out.print(QUEBRAR_LINHA);
	}

	private static String gerarChave() {
		int indice = getRandomNumberInRange(0, 8);
		return CHAVES[indice];
	}

	private static int getRandomNumberInRange(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
	private static int naoAchou(int totalErros, String letraLida) {
		int totalChances = (NUMERO_MAXIMO_DE_ERROS - totalErros);

		System.out.println("A letra " + letraLida + " não existe na senha!");

		if (totalChances > 0) {
			System.out.println("Você tem " + totalChances + " chances!");
		}
		
		return totalChances;
	}
	
	private static void encerrarPartida(int totalChances, String chave) {
		if (totalChances > 0) {
			System.out.println("Parabens ,vc venceu!");
		} else {
			System.out.println("Vc não acertou a senha. A senha era:" + chave);
		}
	}
}
