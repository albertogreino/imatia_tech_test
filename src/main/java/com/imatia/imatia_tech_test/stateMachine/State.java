package com.imatia.imatia_tech_test.stateMachine;

public enum State {
    RECOGIDO_EN_ALMACEN(1),
    EN_REPARTO(2),
    INCIDENCIA_EN_ENTREGA(3),
    ENTREGADO(4);

    private final int value;

    State(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
