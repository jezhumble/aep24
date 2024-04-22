package edu.berkeley.aep;

import java.util.HashSet;
import java.util.function.Function;

// Understands how to compute the cost between two airports
public class Route {
    private final Airport next;
    private final int cost;

    public static Function<Route, Integer> HOP_STRATEGY = route -> 1;

    public static Function<Route, Integer> COST_STRATEGY = route -> route.cost;

    public Route(Airport next, int cost) {
        this.next = next;
        this.cost = cost;
    }

    public int costTo(Airport destination, HashSet<Airport> airports, Function<Route, Integer> strategy) {
        int costToNext = next.costTo(destination, airports, strategy);
        if (costToNext == Airport.UNREACHABLE) { return Airport.UNREACHABLE; }
        return costToNext + strategy.apply(this);
    }
}
