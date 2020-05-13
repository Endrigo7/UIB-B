package br.unit.agenda.model;

public class Endereco {
	
	private TipoLogradouro tipoLogradouro;
	private String logradouro;
	private String numero;
	private String bairro;
	private String cidade;
	private EstadosEnum estado;
	
	public TipoLogradouro getTipoLogradouro() {
		return tipoLogradouro;
	}
	
	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public EstadosEnum getEstado() {
		return estado;
	}

	public void setEstado(EstadosEnum estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Endereco [tipoLogradouro=" + tipoLogradouro + ", logradouro=" + logradouro + ", numero=" + numero
				+ ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + "]";
	}
}
