package br.unit.uibb.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringExclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="CLIENTES")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 9001780092108515333L;

	@Id
	@Column(name="CPF_CLIENTE")
	private String cpf;
	
	@Column(name="NOME_CLIENTE")
	private String nome;
	
	@OneToMany(mappedBy= "cliente", fetch=FetchType.EAGER)
	private List<Conta> contas;
	
}
