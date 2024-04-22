package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringReverserTest {
    // Given a string "Object Oriented Programming Rocks" return "skcoR gnimmargorP detneirO tcejbO"

    @Test
    public void reverserShouldReturnEmptyString() {
        var reverser = new StringReverser("");
        assertEquals("", reverser.reverse());
    }

    @Test
    public void singleLetterReversedShouldBeItself() {
        var reverser = new StringReverser("j");
        assertEquals("j", reverser.reverse());
    }

    @Test
    public void jezsNameShouldComesBackBackwards() {
        var reverser = new StringReverser("Jez");
        assertEquals("zeJ", reverser.reverse());
    }

    @Test
    public void reversingALongStringShouldWork() {
        var reverser = new StringReverser("Object Oriented Programming Rocks");
        assertEquals("skcoR gnimmargorP detneirO tcejbO", reverser.reverse());
    }
}
