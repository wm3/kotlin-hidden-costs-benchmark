package com.athaydes.kotlin;

public class BlackHole {
    private Object[] values = new Object[16];
    private int i = 0;

    public void consume(Object value) {
        this.values[i] = value;
        i = (i + 1) % 16;
    }
}
