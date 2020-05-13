package br.unit.agenda;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.unit.agenda.model.Contato;
import br.unit.agenda.model.Endereco;
import br.unit.agenda.model.EstadosEnum;
import br.unit.agenda.model.TipoContato;

public class AgendaUtil {

	public void imprimeMenu() {
		System.out.println("Seleciona uma opção");
		System.out.println("[1] - incluir contato");
		System.out.println("[2] - excluir contato");
		System.out.println("[3] - listar contatos");
		System.out.println("[4] - consultar dados contato");
		System.out.println("[5] - sair");
	}
	
	public Contato criaContato(Scanner leTeclado) {
		System.out.println("Digite o nome");
		leTeclado.next();
		String nome = leTeclado.nextLine();
		
		System.out.println("Digite o email");
		String email = leTeclado.next();
		
		System.out.println("Digite o telefone");
		Long telefone = leTeclado.nextLong();
		
		System.out.println("Digite o logradouro");
		leTeclado.next();
		String logradouro = leTeclado.nextLine();
		
		System.out.println("Digite a sigla do Estado");
		String estado = leTeclado.next();
		EstadosEnum estadosEnum = EstadosEnum.get(estado);
		
		System.out.println("Digite a data de aniversario (DD/MM/YYYY) ");
		String dataAniversarioString = leTeclado.next();
		
		DateTimeFormatter padraoDeData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataAniversario = LocalDate.parse(dataAniversarioString, padraoDeData) ;
		
		System.out.println("Digite o tipo do contato \n[1] - Geral \n[12] - Cliente \n[22] - Fornecedor");
		int tipoContatoString = leTeclado.nextInt();
		TipoContato tipoContato = TipoContato.getTipoContatoPorCodigo(tipoContatoString);
		
		Endereco endereco = new Endereco();
		endereco.setLogradouro(logradouro);
		endereco.setEstado(estadosEnum);
		
		Contato contato = new Contato(nome, email, telefone, endereco, dataAniversario, tipoContato);
		System.out.println(contato);
		
		return contato;
	}
	
}
