package com.epam.practice2.Array2D.Task16;

class InfoRow {

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    private int group;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    private int index;

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    private boolean isLocked;

    public int[] getRowElements() {
        return rowElements;
    }

    private int[] rowElements;

    InfoRow(int index, int[] rowElements) {
        group = index;
        this.index = index;
        this.rowElements = rowElements;
    }
}