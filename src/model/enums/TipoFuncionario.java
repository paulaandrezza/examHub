package model.enums;

public enum TipoFuncionario {
	ADMIN(1),
	SECRETARIA(2),
	MEDICO(3);
	
	private final int value;
	
	private TipoFuncionario(int value) {
		this.value= value;	
	}
	
	public int getValue() {
        return this.value;
    }
}
