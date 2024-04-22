package edu.berkeley.aep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

// Understands how to navigate through the airport route network
public class Airport {
    private final List<Route> routes = new ArrayList<>();
    public final static int UNREACHABLE = -1;

    public Airport() {
    }

    public void addRoute(Airport destination, int cost) {
        routes.add(new Route(destination, cost));
    }

    public boolean canReach(Airport destination) {
        return costTo(destination, new HashSet<>(), Route.HOP_STRATEGY) != UNREACHABLE;
    }

    public int hopsTo(Airport destination) {
        return costTo(destination, new HashSet<>(), Route.HOP_STRATEGY);
    }

    public int costTo(Airport destination) {
        return costTo(destination, new HashSet<>(), Route.COST_STRATEGY);
    }

    public int costTo(Airport destination, Set<Airport> visited, Function<Route, Integer> strategy) {
        if (!visited.add(this)) return UNREACHABLE;
        if (this == destination) return 0;
        int minCost = UNREACHABLE;
        for (var route : routes) {
            int cost = route.costTo(destination, new HashSet<>(visited), strategy);
            if (cost != UNREACHABLE && (cost < minCost || minCost == UNREACHABLE)) {
                minCost = cost;
            }
        }
        return minCost;
    }

}
