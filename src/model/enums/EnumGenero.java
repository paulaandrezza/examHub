package model.enums;

public enum EnumGenero implements IEnum {
	MASCULINO(1, "Masculino"), FEMININO(2, "Feminino"), NAO_BINARIO(3, "Não-binário"), OUTRO(4, "Outro");

	private final int value;
	private final String description;

	private EnumGenero(int value, String description) {
		this.value = value;
		this.description = description;
	}

	public int getValue() {
		return this.value;
	}

	public String getDescription() {
		return this.description;
	}

	public static EnumGenero fromInt(int value) {
		for (EnumGenero e : EnumGenero.values()) {
			if (e.getValue() == value) {
				return e;
			}
		}
		throw new IllegalArgumentException("Valor desconhecido para Genero: " + value);
	}

	@Override
	public String toString() {
		return this.description;
	}
}
