package br.unit.agenda.model;

public enum TipoLogradouro {
	
	AV (1),
	Rua (2),
	Travessa (3);
	
	private int codigo;
	
	private TipoLogradouro(int codigo) {
		this.codigo = codigo;
	}
	
	public TipoLogradouro getTipoLogradouroByCodigo(int codigo) {
		
		for (TipoLogradouro tipoLogradouro : values()) {
			
			if(tipoLogradouro.codigo == codigo) {
				return tipoLogradouro;
			}
		}
		
		return null;
	}
	
	
}
