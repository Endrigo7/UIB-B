package br.unit.uibb.repository;

import static br.unit.uibb.Constantes.TOTAL_CONTAS;
import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.unit.uibb.entidades.Conta;

public class ContasArrayDao {

	private Conta[] contas;
	private int totalContasCadastradas;

	public ContasArrayDao() {
		contas = new Conta[TOTAL_CONTAS];
		totalContasCadastradas = 0;
	}

	private int procurarIndice(String numero) {
		for (int i = 0; i < totalContasCadastradas; i++) {
			if (numero.equals(contas[i].getNumero())) {
				return i;
			}
		}

		return -1;
	}

	public void inserir(Conta novaConta) {
		contas[totalContasCadastradas] = novaConta;
		totalContasCadastradas++;
	}

	public Conta procurar(String numero) {
		int indice = procurarIndice(numero);

		if (indice == -1) {
			return null;
		}

		return contas[indice];
	}

	public void atualizar(Conta conta) {
		int indice = procurarIndice(conta.getNumero());

		if (indice != -1) {
			contas[indice] = conta;
		}
	}

	public void remover(String numero) {
		int indice = procurarIndice(numero);

		if (indice != -1) {
			for (int i = indice; i < totalContasCadastradas; i++) {
				contas[i] = contas[i + 1];
			}
		}

		totalContasCadastradas--;
	}

	protected boolean existe(String numero) {
		int indice = procurarIndice(numero);
		return indice != -1;
	}

	public List<Conta> procurarContas(String cpf) {

		List<Conta> contasCliente = new ArrayList<>();

		for (Conta conta : contas) {
			if (//
					(conta != null) && //
					(conta.getCliente() != null) && //
					(conta.getCliente().getCpf().equals(cpf)) //
			) {
				contasCliente.add(conta);
			}
		}

		return contasCliente;
	}

	public List<Conta> procurarContasJava8(String cpf) {

		return asList(contas) //
				.stream() //
				.filter(conta -> ( //
						(conta != null) && //
						(conta.getCliente() != null) && //
						(conta.getCliente().getCpf().equals(cpf))) //
				).collect(Collectors.toList());
	}
}
