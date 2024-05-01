package model.enums;

public enum Diagnostico {
    NORMAL_ADULTO(1),
    NORMAL_CRIANCA(2);

    private final int value;

    private Diagnostico(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
