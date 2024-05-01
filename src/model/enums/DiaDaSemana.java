package model.enums;

public enum DiaDaSemana {
    DOMINGO(1),
    SEGUNDA(2),
    TERCA(3),
    QUARTA(4),
    QUINTA(5),
    SEXTA(6),
    SABADO(7);

    private final int value;

    private DiaDaSemana(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
