package com.epam.practice2.Array2D.Task16.test;

import com.epam.practice2.Array2D.Task16.MagicSquare;
import com.epam.practice2.Array2D.Task16.OddMagicSquare;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MagicSquareTest {

    MagicSquare magicSquare;

    @Test
    public void sum() {
        int n = 5;
        magicSquare = new OddMagicSquare(n);
        Assert.assertEquals(65, magicSquare.sum());
    }

    @Test
    public void isMagicSquare(){
        int n = 5;
        magicSquare = new OddMagicSquare(n);
        Assert.assertEquals(true, magicSquare.isMagicSquare());
        magicSquare.getMagicSquare()[0][n-1] = -24;
        Assert.assertNotEquals(true, magicSquare.isMagicSquare());
    }
}