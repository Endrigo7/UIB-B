package br.unit.agenda.model;

public enum EstadosEnum {
	
	PERNAMBUCO("PE"),
	ALAGOAS("AL"),
	PARAIBA("PB"),
	CEARA("CE"),
	BAHIA("BA");
	
	private String sigla;
	
	private EstadosEnum(String sigla) {
		this.sigla = sigla;
	}
	
	public static EstadosEnum get(String sigla) {
		
		if(sigla == null) {
			return null;
		}
		
		for (EstadosEnum estadosEnum : values()) {
			if(sigla.equals(estadosEnum.sigla)) {
				return estadosEnum;
			}
		}
		
		return null;
	}
	
}
