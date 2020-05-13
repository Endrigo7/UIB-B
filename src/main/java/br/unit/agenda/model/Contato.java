package br.unit.agenda.model;

import java.time.LocalDate;

public class Contato {

	private String nome;
	private String email;  
	private Long telefone;
	private Endereco endereco;
	private LocalDate dataAniversario;  //java8+
	private TipoContato tipoContato;  // Geral, Cliente, Fornecedor
	
	public Contato(String nome, String email, //
					Long telefone, Endereco endereco, //
					LocalDate dataAniversario, TipoContato tipoContato) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		this.dataAniversario = dataAniversario;
		this.tipoContato = tipoContato;
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

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public LocalDate getDataAniversario() {
		return dataAniversario;
	}

	public void setDataAniversario(LocalDate dataAniversario) {
		this.dataAniversario = dataAniversario;
	}

	public TipoContato getTipoContato() {
		return tipoContato;
	}

	public void setTipoContato(TipoContato tipoContato) {
		this.tipoContato = tipoContato;
	}

	@Override
	public String toString() {
		return "Contato [nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", endereco=" + endereco
				+ ", dataAniversario=" + dataAniversario + ", tipoContato=" + tipoContato + "]";
	}
	
}
