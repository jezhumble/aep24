package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.*;

public class AirportTest {

    static Airport a = new Airport(), b = new Airport(), c = new Airport(), d = new Airport(), e = new Airport(), f = new Airport(), h = new Airport(), g = new Airport();

    static {
        h.addRoute(b, 87);
        b.addRoute(a, 179);
        b.addRoute(c, 402);
        a.addRoute(f,72);
        c.addRoute(d, 126);
        c.addRoute(e, 749);
        c.addRoute(e, 320);
        d.addRoute(e, 79);
        e.addRoute(b, 312);
    }

    @Test
    public void shouldBeAbleToReachItself() {
        var airport = new Airport();
        assertTrue(airport.canReach(airport));
    }

    @Test
    public void hShouldBeAbleToReachC() {
        assertTrue(h.canReach(c));
    }

    @Test
    public void hShouldNotBeAbleToReachG() {
        assertFalse(h.canReach(g));
    }

    @Test
    public void hopsFromHToItselfShouldBeZero() {
        assertEquals(0, h.hopsTo(h));
    }

    @Test
    public void hToBShouldBeOneHop() {
        assertEquals(1, h.hopsTo(b));
    }

    @Test
    public void hToFShouldBeThreeHop() {
        assertEquals(3, h.hopsTo(f));
    }

    @Test
    public void bToEShouldBeTwoHops() {
        assertEquals(2, b.hopsTo(e));
    }

    @Test
    public void bToEShouldCost607Dollars() {
        assertEquals(607, b.costTo(e));
    }
}
