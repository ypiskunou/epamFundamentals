package com.epam.practice2.Array2D.Task16.test;

import com.epam.practice2.Array2D.Task16.EvenMagicSquare;
import com.epam.practice2.Array2D.Task16.MagicSquare;
import org.junit.Assert;
import org.junit.Test;

public class EvenMagicSquareTest {

    int[][] array = new int[][]{
            {1, 15, 14, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 3, 2, 16},
    };
    int[][] arrayRow = new int[][]{
            {1, 2, 3, 4},
            {5, 6, 11, 8},
            {9, 10, 7, 12},
            {13, 14, 15, 16},
    };
    int[][] arrayColumn = new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 11, 10, 12},
            {13, 14, 15, 16},
    };

//    @Test
//    public void swapCentralSymetric() {
//        EvenMagicSquare evenMagicSquare = new EvenMagicSquare(array.length);
//        evenMagicSquare.swapCentralSymetric(new int[]{2, 14});
//
//        Assert.assertArrayEquals(array, evenMagicSquare.getMagicSquare());
//    }

    @Test
    public void isMagicSquare() {
        int n = 8;
        MagicSquare magicSquare = new EvenMagicSquare(n);
        Assert.assertEquals(true, magicSquare.isMagicSquare());
    }

//    @Test
//    public void swapCentralRowSymetric() {
//        EvenMagicSquare evenMagicSquare = new EvenMagicSquare(arrayRow.length);
//        evenMagicSquare.swapCentralRowSymetric(new int[]{6});
//
//        Assert.assertArrayEquals(arrayRow, evenMagicSquare.getMagicSquare());
//    }
//
//    @Test
//    public void swapCentralColumnSymetric() {
//        EvenMagicSquare evenMagicSquare = new EvenMagicSquare(arrayColumn.length);
//        evenMagicSquare.swapCentralColumnSymetric(new int[]{10});
//
//        Assert.assertArrayEquals(arrayColumn, evenMagicSquare.getMagicSquare());
//    }
}