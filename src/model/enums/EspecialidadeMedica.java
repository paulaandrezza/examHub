package model.enums;

public enum EspecialidadeMedica {
    CARDIOLOGIA(1),
    DERMATOLOGIA(2),
    ENDOCRINOLOGIA(3),
    GASTROENTEROLOGIA(4),
    GINECOLOGIA(5),
    NEUROLOGIA(6),
    ORTOPEDIA(7),
    PEDIATRIA(8),
    PSIQUIATRIA(9),
    UROLOGIA(10);

    private final int value;

    private EspecialidadeMedica(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
