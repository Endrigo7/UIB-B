package br.unit.uibb.pousada;

public class Estudante {

	private String nome;
	private String email;
	
	public Estudante(String nome) {
		this.nome = nome;
		this.email = "Não cadastrado";
	}
	
	public Estudante(String nome, String email) {
		setNome(nome); 
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return nome + ", " + email; 
	}
}
