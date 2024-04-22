package edu.berkeley.aep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Airport {
    private final List<Airport> children = new ArrayList<>();
    private final List<Route> routes = new ArrayList<>();
    public final static int UNREACHABLE = -1;

    public Airport() {
    }

    public boolean canReach(Airport destination) {
        return hopsTo(destination, new HashSet<>()) != UNREACHABLE;
    }

    public void addRoute(Airport destination, int cost) {
        children.add(destination);
        routes.add(new Route(destination, cost));
    }

    public int hopsTo(Airport destination) {
        return hopsTo(destination, new HashSet<>());
    }

    public int hopsTo(Airport destination, Set<Airport> visited) {
        if (!visited.add(this)) return UNREACHABLE;
        if (this == destination) return 0;
        int minHops = UNREACHABLE;
        for (var child : children) {
            int hops = child.hopsTo(destination, new HashSet<>(visited));
            if (hops != UNREACHABLE && (hops < minHops || minHops == UNREACHABLE)) {
                minHops = hops;
            }
        }
        return minHops == UNREACHABLE ? UNREACHABLE : minHops + 1;
    }

    public int costTo(Airport destination) {
        return costTo(destination, new HashSet<>());
    }

    public int costTo(Airport destination, Set<Airport> visited) {
        if (!visited.add(this)) return UNREACHABLE;
        if (this == destination) return 0;
        int minHops = UNREACHABLE;
        for (var route : routes) {
            int hops = route.costTo(destination, new HashSet<>(visited));
            if (hops != UNREACHABLE && (hops < minHops || minHops == UNREACHABLE)) {
                minHops = hops;
            }
        }
        return minHops;
    }
}
