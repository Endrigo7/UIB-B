package br.unit.uibb.util;

public enum JogoForcaEnum {

	CORES_PORTUGUES(1, "cores.txt"), //
	CORES_INGLES(2, "cores_ingles.txt"), //
	ANIMAIS(3, "animais.txt");

	private int codigo;
	private String nomeArquivo;

	private JogoForcaEnum(int codigo, String nomeArquivo) {
		this.codigo = codigo;
		this.nomeArquivo = nomeArquivo;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}
	
	public static JogoForcaEnum procurarPorCodigo(int codigo) {
		for (JogoForcaEnum jogoForcaEnum : values()) {
			if (jogoForcaEnum.codigo == codigo) {
				return jogoForcaEnum;
			}
		}
		return null;
	}
}
