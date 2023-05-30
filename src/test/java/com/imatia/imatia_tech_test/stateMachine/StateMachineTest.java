package com.imatia.imatia_tech_test.stateMachine;

import org.junit.jupiter.api.Test;

public class StateMachineTest {
    @Test
    void whenStateIsRecogidoEnAlmacenAndNextStateIsNotRecogidoEnAlmacenThenIsValidTransition() {
        assert StateTransitionValidator.isValidTransition(State.RECOGIDO_EN_ALMACEN, State.EN_REPARTO);
        assert StateTransitionValidator.isValidTransition(State.RECOGIDO_EN_ALMACEN, State.INCIDENCIA_EN_ENTREGA);
        assert StateTransitionValidator.isValidTransition(State.RECOGIDO_EN_ALMACEN, State.ENTREGADO);
    }

    @Test
    void whenStateIsRecogidoEnAlmacenAndNextStateIsRecogidoEnAlmacenThenIsNotValidTransition() {
        assert !StateTransitionValidator.isValidTransition(State.RECOGIDO_EN_ALMACEN, State.RECOGIDO_EN_ALMACEN);
    }

    @Test
    void whenStateIsEnRepartoAndNextStateIsIncidenciaEnEntregaThenIsValidTransition() {
        assert StateTransitionValidator.isValidTransition(State.EN_REPARTO, State.INCIDENCIA_EN_ENTREGA);
    }

    @Test
    void whenStateIsEnRepartoAndNextStateIsEntregadoThenIsValidTransition() {
        assert StateTransitionValidator.isValidTransition(State.EN_REPARTO, State.ENTREGADO);
    }

    @Test
    void whenStateIsIncidencaEnEntregaAndNextStateIsEnRepartoThenIsValidTransition() {
        assert StateTransitionValidator.isValidTransition(State.INCIDENCIA_EN_ENTREGA, State.EN_REPARTO);
    }

    @Test
    void whenStateIsIncidenciaEnEntregaAndNextStateIsEntregadoThenIsValidTransition() {
        assert StateTransitionValidator.isValidTransition(State.INCIDENCIA_EN_ENTREGA, State.ENTREGADO);
    }

    @Test
    void whenStateIsEntregadoAndNoNextStateIsValidTransition() {
        assert !StateTransitionValidator.isValidTransition(State.ENTREGADO, State.RECOGIDO_EN_ALMACEN);
        assert !StateTransitionValidator.isValidTransition(State.ENTREGADO, State.EN_REPARTO);
        assert !StateTransitionValidator.isValidTransition(State.ENTREGADO, State.INCIDENCIA_EN_ENTREGA);
        assert !StateTransitionValidator.isValidTransition(State.ENTREGADO, State.ENTREGADO);
    }
}
