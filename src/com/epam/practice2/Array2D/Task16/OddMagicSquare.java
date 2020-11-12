package com.epam.practice2.Array2D.Task16;

public class OddMagicSquare extends MagicSquare {

//    private int p;
//    private int q;

    public OddMagicSquare(int n) {
        super(n);
        p = 0;
        q = n / 2;
        magicSquare[p][q] = 1;
        p--;
        q++;
        for (int i = 2; i <= n * n; i++, p--, q++) {

            if (!equivalentMove(i))
                if (!diagonalMove(i))
                    bottomMove(i);
        }
    }

    private boolean diagonalMove(int i) {
        if (isNotInArrayColumnBounds(p) || isNotInArrayRowBounds(q) || magicSquare[p][q] != 0)
            return false;
        magicSquare[p][q] = i;
        return true;
    }

    private boolean equivalentMove(int i) {
        int prevP = p;
        int prevQ = q;
        boolean equivalentStep = false;
        if (isNotInArrayColumnBounds(p)) {
            equivalentMoveDown();
            equivalentStep = true;
        }
        if (isNotInArrayRowBounds(q)) {
            equivalentMoveLeft();
            equivalentStep = true;
        }
        if (equivalentStep)
            if (magicSquare[p][q] == 0)
                magicSquare[p][q] = i;
            else {
                p = prevP;
                q = prevQ;
                return false;
            }

        return equivalentStep;
    }

    private void bottomMove(int i) {
        p += 2;
        q--;
        magicSquare[p][q] = i;
    }

//    private void equivalentMoveLeft() {
//        q = (n + q) % n;
//    }
//
//    private void equivalentMoveDown() {
//        p = n - (n - p) % n;
//    }

    private boolean isNotInArrayColumnBounds(int p) {
        return p <= -1 || p >= n;
    }

    private boolean isNotInArrayRowBounds(int q) {
        return q <= -1 || q >= n;
    }
}
