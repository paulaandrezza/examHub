package model.enums;

public enum EnumDiaDaSemana implements IEnum {
	DOMINGO(1, "domingo"), SEGUNDA(2, "segunda-feira"), TERCA(3, "terça-feira"), QUARTA(4, "quarta-feira"),
	QUINTA(5, "quinta-feira"), SEXTA(6, "sexta-feira"), SABADO(7, "sábado");

	private final int value;
	private final String description;

	private EnumDiaDaSemana(int value, String description) {
		this.value = value;
		this.description = description;
	}

	public int getValue() {
		return this.value;
	}

	public String getDescription() {
		return this.description;
	}

	public static EnumDiaDaSemana fromInt(int value) {
		for (EnumDiaDaSemana e : EnumDiaDaSemana.values()) {
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
