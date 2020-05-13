package br.unit.uibb.repository;


import static java.util.Arrays.asList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.unit.uibb.entidades.Cliente;
import br.unit.uibb.entidades.Conta;

public class RepositorioContasArrayTest {

	private ContasArrayDao repositorioContasArray;

	@Before
	public void setup() {
		repositorioContasArray = new ContasArrayDao();

		List<Conta> contas = getContasDummy();
		contas.forEach(conta -> repositorioContasArray.inserir(conta));
	}
	
	private List<Conta> getContasDummy() {
		return asList( //
				new Conta("10", 100, new Cliente("Jair", "123"), "123"), //
				new Conta("15", 200, new Cliente("Joquina", "332"), "123"), //
				new Conta("20", 300, new Cliente("Jair", "123"), "123"), //
				new Conta("25", 400, new Cliente("Jose", "321"), "123"), //
				new Conta("30", 500, new Cliente("Maria", "456"), "123") //
		);
	}
	
	@Test
	public void deveExcluirContaQuandoContaExistir() {
		repositorioContasArray.remover("15");
		
		assertTrue(repositorioContasArray.existe("30"));
		assertFalse(repositorioContasArray.existe("15"));
	}

}
