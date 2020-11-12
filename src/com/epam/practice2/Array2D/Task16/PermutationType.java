package com.epam.practice2.Array2D.Task16;

public class PermutationType {
    private boolean centralSymmetricPermutation;
    private boolean horizontalSymmetricPermutation;
    private boolean verticalSymmetricPermutation;

    public boolean isAnySymmetricPermutation() {
        return anySymmetricPermutation;
    }

    private boolean anySymmetricPermutation = false;

    public boolean isCentralSymmetricPermutation() {
        return centralSymmetricPermutation;
    }

    public void setCentralSymmetricPermutation(boolean centralSymmetricPermutation) {
        this.centralSymmetricPermutation = centralSymmetricPermutation;
        anySymmetricPermutation = true;
    }

    public boolean isHorizontalSymmetricPermutation() {
        return horizontalSymmetricPermutation;
    }

    public void setHorizontalSymmetricPermutation(boolean horizontalSymmetricPermutation) {
        this.horizontalSymmetricPermutation = horizontalSymmetricPermutation;
        anySymmetricPermutation = true;
    }

    public boolean isVerticalSymmetricPermutation() {
        return verticalSymmetricPermutation;
    }

    public void setVerticalSymmetricPermutation(boolean verticalSymmetricPermutation) {
        this.verticalSymmetricPermutation = verticalSymmetricPermutation;
        anySymmetricPermutation = true;
    }

    PermutationType() {
        centralSymmetricPermutation = horizontalSymmetricPermutation = verticalSymmetricPermutation = false;
    }
}