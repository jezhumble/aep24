package edu.berkeley.aep;

import java.util.HashSet;

public class Route {
    private final Airport route;
    private final int cost;

    public Route(Airport route, int cost) {
        this.route = route;
        this.cost = cost;
    }

    public int costTo(Airport destination, HashSet<Airport> visited) {
        var path = route.costTo(destination, visited);
        if (path == Airport.UNREACHABLE) return Airport.UNREACHABLE;
        return path + cost;
    }
}
