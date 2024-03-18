package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class BesterTest {
    @Test
    public void oneCupShouldBeTheBestQuantity() {
        ArithmeticQuantity oneCup = new ArithmeticQuantity(1, Unit.CUP);
        ArithmeticQuantity oneOz = new ArithmeticQuantity(1, Unit.OZ);
        ArithmeticQuantity oneTbsp = new ArithmeticQuantity(1, Unit.TBSP);
        ArithmeticQuantity oneTsp = new ArithmeticQuantity(1, Unit.TSP);
        assertEquals(oneCup, new Bester(oneOz, oneCup, oneTsp, oneTbsp).best());
    }

    @Test
    public void oneShouldBeTheBestProbability() {
        Chance one = new Chance(1);
        Chance half = new Chance(0.5);
        Chance quarter = new Chance(0.25);
        assertEquals(one, new Bester(one, half, quarter).best());
    }

    @Test
    public void tryingToSortEmptyListShouldReturnException() {
        assertEquals(null, new Bester().best());
    }
}
