package com.example.MarsRover;

import org.junit.Before;
import org.junit.Test;

import static com.example.MarsRover.Direction.*;
import static org.junit.Assert.*;


public class PositionTest {
    private Position positionNorth;
    private Position positionEast;

    @Before
    public void initPositions() {
        positionNorth = new Position(0,0, NORTH);
        positionEast = new Position(0,0, EAST);
    }

    @Test
    public void shouldTurnRight() {
        assertEquals(new Position(0,0, EAST), positionNorth.rotateRight());
        assertEquals(new Position(0,0, SOUTH), positionEast.rotateRight());
    }

    @Test
    public void shouldTurnLeft() {
        assertEquals(new Position(0,0, WEST), positionNorth.rotateLeft());
        assertEquals(new Position(0,0, NORTH), positionEast.rotateLeft());
    }

    @Test
    public void shouldMoveAhead() {
        assertEquals(new Position(0,1, NORTH), positionNorth.moveAhead());
        assertEquals(new Position(1,0, EAST), positionEast.moveAhead());
    }

    @Test
    public void shouldReturnTrueWhenPositionIsInsideGivenCoordinates() {
        Position position = new Position(1, 2, NORTH);

        assertTrue(position.isWithIn(5, 5));
    }

    @Test
    public void shouldReturnFalseWhenPositionIsNotInsideGivenCoordinates() {
        Position position = new Position(6, 2, NORTH);

        assertFalse(position.isWithIn(5, 5));
    }
     @Test
    public void shouldReturnTrueWhenPositionIsOutsideGivenCoordinates() {
        Position position = new Position(1, 2, NORTH);

        assertTrue(position.isOutside(0, 0));
    }

    @Test
    public void shouldReturnFalseWhenPositionIsNotOutsideGivenCoordinates() {
        Position position = new Position(-1, 2, NORTH);

        assertFalse(position.isOutside(0, 0));
    }
}
