package model.enums;

public enum EnumDiagnostico implements IEnum {
	NORMAL_ADULTO(1, "Normal Adulto"), NORMAL_CRIANCA(2, "Normal Criança");

	private final int value;
	private final String description;

	private EnumDiagnostico(int value, String description) {
		this.value = value;
		this.description = description;
	}

	public int getValue() {
		return this.value;
	}

	public String getDescription() {
		return this.description;
	}

	public static EnumDiagnostico fromInt(int value) {
		for (EnumDiagnostico e : EnumDiagnostico.values()) {
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
