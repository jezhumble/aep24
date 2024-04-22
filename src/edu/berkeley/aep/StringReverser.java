package edu.berkeley.aep;

// Understands how to reverse a string
public class StringReverser {
    private final String toReverse;

    public StringReverser(String toReverse) {
        this.toReverse = toReverse;
    }

    public String reverse() {
        if (toReverse.length() < 2) {
            return toReverse;
        }
        var recursive = new StringReverser(toReverse.substring(0, toReverse.length() - 1));
        return toReverse.charAt(toReverse.length() - 1) + recursive.reverse();
    }
}
