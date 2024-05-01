package model.enums;

public enum Genero {
    MASCULINO(1),
    FEMININO(2),
    NAO_BINARIO(3),
    OUTRO(4);

    private final int value;

    private Genero(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
