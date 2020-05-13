package br.unit.agenda.model;

public enum TipoContato {
	
	GERAL (1),        
	CLIENTE (12),    
	FORNECEDOR (22); 

	private int codigo;
	
	private TipoContato(int codigo) {
		this.codigo = codigo;
	}
	
	public static TipoContato getTipoContatoPorCodigo(int codigo) {
	
		for (TipoContato tipoContato : values()) {
			if(tipoContato.codigo == codigo) {
				return tipoContato;
			}
		}
		
		return null;
	}

}
