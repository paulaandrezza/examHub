package model.enums;

public enum EnumTipoFuncionario implements IEnum {
	ADMIN(1, "Administrador"), SECRETARIA(2, "Secretária"), MEDICO(3, "Médico");

	private final int value;
	private final String description;

	private EnumTipoFuncionario(int value, String description) {
		this.value = value;
		this.description = description;
	}

	public int getValue() {
		return this.value;
	}

	public String getDescription() {
		return this.description;
	}

	public static EnumTipoFuncionario fromInt(int value) {
		for (EnumTipoFuncionario e : EnumTipoFuncionario.values()) {
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
