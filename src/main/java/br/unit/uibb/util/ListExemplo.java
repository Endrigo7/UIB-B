package br.unit.uibb.util;

public class ListExemplo {

	public static void main(String[] args) {
		Integer[] numerosGrades = new Integer[1000];
		for (int i = 0; i < 1000; i++) {
			numerosGrades[i] = new Integer(i);
		}
		
		for (int i = 1; i < numerosGrades.length; i++) {
			
			if(i % 2 != 0) {
				continue;
			}
			
			System.out.println(i);
		}
	}
	
}
