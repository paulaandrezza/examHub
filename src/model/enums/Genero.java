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
    
    public static Genero fromInt(int value) {
        for (Genero g : Genero.values()) {
            if (g.getValue() == value) {
                return g;
            }
        }
        throw new IllegalArgumentException("Valor desconhecido para Genero: " + value);
    }
}
