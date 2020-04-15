package br.unit.uibb.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class JogoForca {

	private static final int NUMERO_MAXIMO_DE_ERROS = 3;
	private static final String QUEBRAR_LINHA = "\n";
	
	public static void main(String[] args) {
		JogoForca jogo = new JogoForca();
		Scanner leTeclado = new Scanner(System.in);
		
		int totalErros = 0;
		int totalChances = NUMERO_MAXIMO_DE_ERROS;
		int totalLetrasCorretas = 0;
		
		jogo.exibeMenu();
		int op = leTeclado.nextInt();
		JogoForcaEnum jogoForcaEnum = JogoForcaEnum.procurarPorCodigo(op);
		
		String chave = jogo.gerarChave(jogoForcaEnum);
		String[] palavra = new String[chave.length()];
		
		for (int i = 0; i < palavra.length; i++) {
			palavra[i] = "_";
		}
		
		do {
			jogo.exibePalavra(palavra);

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
				totalChances = jogo.naoAchou(totalErros, letraLida);
			}
		} while (totalErros < NUMERO_MAXIMO_DE_ERROS);

		jogo.encerrarPartida(totalChances, chave);
		leTeclado.close();
	}

	private void exibePalavra(String[] palavra) {
		for (int i = 0; i < palavra.length; i++) {
			System.out.print(palavra[i] + "  ");
		}
		System.out.print(QUEBRAR_LINHA);
	}

	private String gerarChave(JogoForcaEnum jogoForcaEnum) {
		List<String> lista = getPossibilidadesChave(jogoForcaEnum.getNomeArquivo());

		int indice = getRandomNumberInRange(0, lista.size() - 1);
		return lista.get(indice);
	}

	private int getRandomNumberInRange(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

	private int naoAchou(int totalErros, String letraLida) {
		int totalChances = (NUMERO_MAXIMO_DE_ERROS - totalErros);

		System.out.println("A letra " + letraLida + " não existe na senha!");

		if (totalChances > 0) {
			System.out.println("Você tem " + totalChances + " chances!");
		}

		return totalChances;
	}

	private void encerrarPartida(int totalChances, String chave) {
		if (totalChances > 0) {
			System.out.println("Parabens ,vc venceu!");
		} else {
			System.out.println("Vc não acertou a senha. A senha era:" + chave);
		}
	}

	private List<String> getPossibilidadesChave(String nomeArquivo) {
		List<String> cores = new ArrayList<>();

		InputStream stream = getClass()
				.getClassLoader().getResourceAsStream(nomeArquivo);
		
		Scanner leArquivo;

		leArquivo = new Scanner(stream);

		while (leArquivo.hasNextLine()) {
			String cor = leArquivo.nextLine();
			cores.add(cor);
		}

		leArquivo.close();
		return cores;
	}
	
	private void exibeMenu() {
		System.out.println("Selecione o tipo da senha");
		System.out.println("1 - cores em português");
		System.out.println("2 - cores em ingles");
		System.out.println("3 - animais");
	}
}
