package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BishopBlackTest {

    @Test
    public void whenPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        bishopBlack.position();
        assertThat(bishopBlack.position()).isEqualTo(Cell.A1);
    }

    @Test
    public void whenCopying() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A2);
        bishopBlack.copy(Cell.A2);
        assertThat(bishopBlack.copy(Cell.A2).position()).isEqualTo(Cell.A2);
    }

    @Test
    public void whenDiagonalWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        bishopBlack.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(bishopBlack.way(Cell.G5)).isEqualTo(expected);
    }

    @Test
    public void whenNotDiagonalWay() {
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        bishopBlack.way(Cell.G6);
                });
        assertThat(exception.getMessage()).isEqualTo(String.format
                ("Could not move by diagonal from %s to %s", Cell.C1, Cell.G6));
    }
}