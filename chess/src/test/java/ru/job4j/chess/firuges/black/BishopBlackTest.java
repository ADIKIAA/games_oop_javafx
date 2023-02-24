package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BishopBlackTest {

    @Test
    public void whenPositionRight() {
        BishopBlack figure = new BishopBlack(Cell.E2);
        Assertions.assertEquals(Cell.E2, figure.position());
    }

    @Test
    public void whenCopyRight() {
        BishopBlack figure = new BishopBlack(Cell.B6);
        Assertions.assertEquals(figure.copy(Cell.D1).position(), Cell.D1);
    }

    @Test
    public void whenWayRight() {
        BishopBlack figure = new BishopBlack(Cell.C1);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Cell[] actual = figure.way(Cell.G5);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void whenWayWrong() {
        BishopBlack figure = new BishopBlack(Cell.C1);
        ImpossibleMoveException  exception = assertThrows(
                ImpossibleMoveException.class,
                () -> {
                    figure.way(Cell.H3);
                });
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from C1 to H3");
    }
}