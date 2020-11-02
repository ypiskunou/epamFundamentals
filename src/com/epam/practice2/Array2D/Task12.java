package com.epam.practice2.Array2D;

import java.util.Arrays;

/**
 * @author Piskunou Yury
 * @my.task 12. Отсортировать строки матрицы по возрастанию и убыванию значений элементов.
 * @since 26.10.20
 */
public class Task12 {

    public static void main(String[] args) {

        int[][] array = new int[][]{
                {3, 5, 7, 27},
                {3, 5, 4, 3},
                {3, 3, 7, 25},
                {3, 3, 7, 25}
        };

        System.out.printf("Original array: \n%s", Task1.print2dArray(array));

        System.out.println("\nSorted array: ");
        InfoArray infoArray = new InfoArray(array);
        infoArray.sortMatrixOnRows(array);
        printArrayOnInfoArray(array, infoArray.getReferenceArray());
    }

    private static int[] reverseArray(int[] array) {
        int[] reversedArray = new int[array.length];
        for (int i = 0; i < array.length; i++)
            reversedArray[i] = array[array.length - 1 - i];

        return reversedArray;
    }

    private static void printArrayOnInfoArray(int[][] array, int[] indexArray, boolean decreasing) {
        if (decreasing)
            indexArray = reverseArray(indexArray);
        for (int anIndexArray : indexArray) System.out.println(Arrays.toString(array[anIndexArray]));
    }

    private static void printArrayOnInfoArray(int[][] array, int[] indexArray) {
        printArrayOnInfoArray(array, indexArray, false);
    }

}

class InfoArray {
    public int[] getReferenceArray() {
        return referenceArray;
    }

    private int[] referenceArray;

    private InfoRow[] infoRows;

    public int[][] getArray() {
        return array;
    }

    private int[][] array;

    InfoArray(int[][] array) {

        this.array = array;
        infoRows = new InfoRow[array.length];
        for (int i = 0; i < array.length; i++)
            infoRows[i] = new InfoRow(i, array[i]);
        referenceArray = new int[array.length];
    }

    public void sortMatrixOnRows(int[][] array) {
        boolean isAnotherIteration = true;

        for (int j = 0; j < array[0].length && isAnotherIteration; j++) {
            isAnotherIteration = false;

            for (int infoPointer = 0; infoPointer < array.length; infoPointer++) {
                if (infoRows[infoPointer].isLocked())
                    continue;
                int min = infoRows[infoPointer].getRowElements()[j];
                int index = infoPointer;

                for (int i = infoPointer; i < infoRows.length; i++) {
                    if (!infoRows[i].isLocked())
                        if (j == 0 || infoRows[i].getGroup() == infoRows[infoPointer].getGroup()) {
                            if (infoRows[i].getRowElements()[j] < min) {
                                min = infoRows[i].getRowElements()[j];
                                index = i;
                            }
                        }
                }

                infoRows[infoPointer] = swapArrayElements(infoRows[index], infoRows[index] = infoRows[infoPointer]);
            }

            if (j == 0)
                for (int i = 0; i < array.length; i++)
                    infoRows[i].setLocked(true);

            for (int p = 0; p < array.length; p++)
                for (int q = p; q < array.length; q++)
                    if (infoRows[q].getRowElements()[j] == infoRows[p].getRowElements()[j] && p != q) {
                        if (j == 0 || infoRows[q].getGroup() == infoRows[p].getGroup())
                            isAnotherIteration = true;
                        if (j == 0)
                            infoRows[q].setGroup(infoRows[p].getGroup());
                        else if (infoRows[q].getGroup() == infoRows[p].getGroup()) {
                            infoRows[q].setGroup(infoRows[p].getIndex());
                            infoRows[p].setGroup(infoRows[p].getIndex());
                        }

                        if (infoRows[q].getGroup() == infoRows[p].getGroup()) {
                            infoRows[p].setLocked(false);
                            infoRows[q].setLocked(false);
                        }
                    }
        }

        for (int i = 0; i < array.length; i++)
            referenceArray[i] = infoRows[i].getIndex();
    }

    private static InfoRow swapArrayElements(InfoRow a, InfoRow b) {
        return a;
    }
}

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