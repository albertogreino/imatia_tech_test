package com.imatia.imatia_tech_test.stateMachine;

public class StateTransitionValidator {
    public static boolean isValidTransition(State from, State to) {
        if (from == State.RECOGIDO_EN_ALMACEN
                && to != State.RECOGIDO_EN_ALMACEN) {
            return true;
        } else if (to == State.RECOGIDO_EN_ALMACEN) {
            return false;
        } else if (from == State.ENTREGADO) {
            return false;
        } else if (from == State.EN_REPARTO &&
                (to == State.INCIDENCIA_EN_ENTREGA || to == State.ENTREGADO)) {
            return true;
        } else if (from == State.INCIDENCIA_EN_ENTREGA &&
                (to == State.EN_REPARTO || to == State.ENTREGADO)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValidTransition(int from, int to) {
        return isValidTransition(State.values()[from - 1], State.values()[to - 1]);
    }
}
