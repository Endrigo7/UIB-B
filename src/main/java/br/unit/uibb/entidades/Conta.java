package br.unit.uibb.entidades;
import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringExclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Conta implements Serializable {
	
	private static final long serialVersionUID = -8996505142658043027L;

	@ToString.Include
	@Id
	@Column
	private String numero;
	
	@ToString.Include
	@Column
	private Double saldo;
	
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CPF_CLIENTE")
	private Cliente cliente;
	
	@Column
	private String senha;

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
