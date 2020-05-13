package br.unit.uibb.entidades;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Conta {
	
	@ToString.Include
	private String numero;
	
	@ToString.Include
	private double saldo;
	
	@ToString.Include
	private Cliente cliente;
	
	private String senha;

	public void setNumero(String numero) {
		this.numero = numero;
	}

	//setSaldo nao deve ser implementado

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void creditar(double valor) {
		saldo += valor;
	}

	public void debitar(double valor) {
		saldo -= valor;
	}

	public void transferir(Conta contaDestino, double valor) {
		debitar(valor);
		contaDestino.creditar(valor);
	}

	public static String gerarNumero() {
		return UUID.randomUUID().toString();
	}
}
