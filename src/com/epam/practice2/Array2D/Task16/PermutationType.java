package com.epam.practice2.Array2D.Task16;

public class PermutationType {
    private boolean a;
    private boolean b;
    private boolean c;

    public boolean isAny() {
        return any;
    }

    private boolean any = false;

    public boolean isA() {
        return a;
    }

    public void setA(boolean a) {
        this.a = a;
        any = true;
    }

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
        any = true;
    }

    public boolean isC() {
        return c;
    }

    public void setC(boolean c) {
        this.c = c;
        any = true;
    }

    public PermutationType() {
        a = b = c = false;
    }
}