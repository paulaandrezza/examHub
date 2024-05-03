package model.enums;

public enum EnumExame implements IEnum {
	ECOCARDIOGRAMA(1, "Ecocardiograma"), ELETROCARDIOGRAMA(2, "Eletrocardiograma"), HOLTER(3, "Holter"),
	MAPA(4, "MAPA"), TESTE_ERGOMETRICO(5, "Teste Ergométrico");

	private final int value;
	private final String description;

	private EnumExame(int value, String description) {
		this.value = value;
		this.description = description;
	}

	@Override
	public int getValue() {
		return this.value;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	public static EnumExame fromInt(int value) {
		for (EnumExame e : EnumExame.values()) {
			if (e.getValue() == value) {
				return e;
			}
		}
		throw new IllegalArgumentException("Valor desconhecido para Exame: " + value);
	}

	@Override
	public String toString() {
		return this.description;
	}
}
