package model.enums;

public enum EnumStatusAgendamento implements IEnum {
	AGENDADO(1, "Agendado"), CANCELADO(2, "Cancelado");

	private final int value;
	private final String description;

	private EnumStatusAgendamento(int value, String description) {
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

	public static EnumStatusAgendamento fromInt(int value) {
		for (EnumStatusAgendamento status : EnumStatusAgendamento.values()) {
			if (status.getValue() == value) {
				return status;
			}
		}
		throw new IllegalArgumentException("Valor desconhecido para Status: " + value);
	}

	public String toString() {
		return this.description;
	}
}
