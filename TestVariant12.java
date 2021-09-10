package test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lab0.Variant12;

public class TestVariant12 {

    public static double EPS = 0.000001;

    ////////////////////////////////////////////////

    @Test(dataProvider = "integerProvider")
    public void inputTest(int p1, int p3) {
        assertEquals(new Variant12().integerNumbersTask(p1), p3);
    }

    @DataProvider
    public Object[][] integerProvider() {
        return new Object[][] { { 110, 11 }, { 374, 473 }, {808, 808} };
    }

    @Test(expectedExceptions = AssertionError.class)
    public void negativeIntegerTest() {
        new Variant12().integerNumbersTask(-2);
    }

    ////////////////////////////////////////////////

    @Test(dataProvider = "ifProvider")
    public void ifTest(int p1, int p2, int p3, int p4) {
        assertEquals(new Variant12().ifTask(p1, p2, p3), p4);
    }

    @DataProvider
    public Object[][] ifProvider() {
        return new Object[][] { { 1, 2, 3, 1 }, { 25, 25, 25, 25 }, { -23, -69, -10, -69 } };
    }

    //////////////////////////////////////////////////

    @Test(dataProvider = "booleanProvider")
    public void booleanTest(int p1, int p2, int p3, boolean p4) {
        assertEquals(new Variant12().booleanTask(p1, p2, p3), p4);
    }

    @DataProvider
    public Object[][] booleanProvider() {
        return new Object[][] { { 1, 1, 1, true }, { 0, 17, 42, false }, { -3, 57000, 69, false } };
    }

    //////////////////////////////////////////////////

    @Test(dataProvider = "switchProvider")
    public void switchTest(int p1, int p2, double[] arr) {
        assertEquals(new Variant12().switchTask(p1, p2), arr);
    }

    @DataProvider
    public Object[][] switchProvider() {
        double[] input1 = { 1, 2, 6.28, 3.14 };
        double[] input2 = { 3, 6, 6.28 * 3, 3.14 * 3 * 3 };
        double[] input3 = { 4, 8, 6.28 * 4, 3.14 * 4 * 4};
        return new Object[][] { { 1, 1, input1 }, { 2, 6, input2 }, { 3, 6.28 * 4, input3 } };
    }

    @Test(expectedExceptions = AssertionError.class)
    public void switchNegativeTest() {
        new Variant12().forTask(10);
    }

    ///////////////////////////////////////////////////

    @Test(dataProvider = "forProvider")
    public void forTest(int n, double p2) {
        assertEquals(new Variant12().forTask(n), p2, EPS);
    }

    @DataProvider
    public Object[][] forProvider() {
        return new Object[][] { { 3, 1.716 }, { 7, 9.801792 }, { 12, 309.744468 } };
    }

    ///////////////////////////////////////////////////

    @Test(dataProvider = "whileProvider")
    public void whileTest(int n, int[] res) {
        assertEquals(new Variant12().whileTask(n), res);
    }

    @DataProvider
    public Object[][] whileProvider() {
        return new Object[][] { { 5, new int[] {3, 6} }, { 10, new int[] {4, 10} }, { 100, new int[] {14, 105} } };
    }

    @Test(expectedExceptions = AssertionError.class, dataProvider = "negativeWhileProvider")
    public void negativeWhileTest(int n) {
        new Variant12().whileTask(n);
    }

    @DataProvider
    public Object[][] negativeWhileProvider() {
        return new Object[][] { { 0 }, { -20 } };
    }

    ///////////////////////////////////////////////////

    @Test(dataProvider = "minMaxProvider")
    public void minMaxTest(int[] arr, int n, int min){
        assertEquals(new Variant12().minMaxTask(arr, n), min);
    }

    @DataProvider
    public Object[][] minMaxProvider(){
        return new Object[][] { { new int[] {1, 2, 3, 4, 5, 0, 10}, 7, 1}, { new int[] { -1, -2 ,-69 }, 3, 0}, { new int[] { 0 }, 1, 0 } };
    }

    //////////////////////////////////////////

    @Test(dataProvider = "arrayProvider")
    public void arrayTest(double[] array, double value) {
        assertEquals(new Variant12().arrayTask(array), value);
    }

    @DataProvider
    public Object[][] arrayProvider() {
        return new Object[][] { { new double[] { 10, 2, 3 }, 0 }, { new double[] { 10, 2, 13 }, 10 },
                { new double[] { 4, 3, 5, -4, 9, 2 }, -4 } };
    }



    //////////////////////////////////////////

    @Test(dataProvider = "matrixProvider")
    public void twoDimensionArrayTest(int[][] input, int from, int to, int[][] output) {
        assertEquals(new Variant12().twoDimensionArrayTask(input, from, to), output);
    }

    @DataProvider
    public Object[][] matrixProvider() {
        int[][] input = {{2, 3, 6, 9, -9},
                {34, 98, -9, 2, 1},
                {-4, 2, 1, 6, 1},
                {-98, 8, 1, 5, 3}};

        int[][] input23 = {{2, 3, 6, 9, -9},
                {-4, 2, 1, 6, 1},
                {34, 98, -9, 2, 1},
                {-98, 8, 1, 5, 3}};

        int[][] input14 = {{-98, 8, 1, 5, 3},
                {-4, 2, 1, 6, 1},
                {34, 98, -9, 2, 1},
                {2, 3, 6, 9, -9}};

        return new Object[][] { {input, 2, 3, input23}, { input, 1,4, input14 } };
    }
}
