package edu.berkeley.aep;

public class Bester {
    private final Bestable[] quantities;

    public Bester(Bestable... quantities) {
        this.quantities = quantities;
    }

    public Bestable best() {
        if (quantities.length == 0)
            return null;
        Bestable best = quantities[0];
        for (var quantity : quantities) {
            if (quantity.betterThan(best)) best = quantity;
        }
        return best;
    }
}
