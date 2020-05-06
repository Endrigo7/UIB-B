package br.unit.uibb.pousada;

public class Quarto {
	
	private int numero;
	private boolean temBanheiro;
	private Estudante estudante;
	
	public Quarto(int numero, boolean temBanheiro) {
		this.numero = numero;
		this.temBanheiro = temBanheiro;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isTemBanheiro() {
		return temBanheiro;
	}

	public void setTemBanheiro(boolean temBanheiro) {
		this.temBanheiro = temBanheiro;
	}
	
	public Estudante getEstudante() {
		return estudante;
	}
	
	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}
	
	public String toString() {
		return "quarto de numero " + numero  // 
				+ (temBanheiro ? " com banheiro " : "" ) // 
				+ (estudante != null ? " alugado ao estudante :" + estudante : "");
	}
	
}
