package br.unit.uibb.util;
import java.util.Scanner;

public class FormatadorString {

	private static final String PONTO = ".";
	private static final String VIRGULA = ",";
	private static final int NUMERO_MAXIMO_CARACTERES_POR_LINHA = 30;
	private static final char QUEBRA_DE_LINHA = '\n';

	public static void main(String[] args) {
		Scanner leTeclado = new Scanner(System.in);

		System.out.println("Por favor digite a frase");
		String frase = leTeclado.nextLine();

		String fraseAjustada = "";
		String letraAnterior = "";
		int quantidadeQuebraLinhas = 0;
		for (int i = 0; i < frase.length(); i++) {
			String letra = String.valueOf(frase.charAt(i));
			
			fraseAjustada = fraseAjustada + convertMaisculo(letra, letraAnterior);
			fraseAjustada = fraseAjustada + isPontoOuVirgula(letra);
			fraseAjustada = fraseAjustada + quebraLinha(fraseAjustada.length() - quantidadeQuebraLinhas);
			
			char ultimaLetra = fraseAjustada.charAt(fraseAjustada.length() -1);
			quantidadeQuebraLinhas = quantidadeQuebraLinhas 
					+ (ultimaLetra == QUEBRA_DE_LINHA ? 1 : 0);
			
			letraAnterior = letra;
		}
		
		System.out.println(fraseAjustada);
		leTeclado.close();
	}
	
	private static String convertMaisculo(String letra, String letraAnterior) {
		if(PONTO.equals(letraAnterior)) {
			return letra.toUpperCase();
		}
		return letra;
	}

	private static String isPontoOuVirgula(String letra) {
		if (PONTO.equals(letra) || VIRGULA.equals(letra)) {
			return " ";
		}
		return "";
	}
	
	private static String quebraLinha(int tamanhoFrase) {
		if (tamanhoFrase % NUMERO_MAXIMO_CARACTERES_POR_LINHA == 0) {
			return String.valueOf(QUEBRA_DE_LINHA);
		}
		return "";
	}
}
