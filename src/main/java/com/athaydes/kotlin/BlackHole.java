package com.athaydes.kotlin;

public class BlackHole {
    public int state = (int)(Math.random() * Integer.MAX_VALUE);

    public void consume(int value) {
        state = state ^ (state << 1) ^ value;
    }

    public void consume(Object value) {
        if (value == null) {
            state = state ^ (state << 1) ^ 1823577408;
        } else {
            state = state ^ (state << 1) ^ 993781958;
        }
    }

    public void consumeArray(int[] value) {
        state = state ^ (state << 1) ^ value.length;
    }
}
