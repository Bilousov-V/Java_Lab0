package lab0;

import static java.lang.Math.sqrt;

public class Variant12 {
    /**
     *
     * @param k is a 3-digit positive number
     * @return the same number read backwards
     */
    public int integerNumbersTask(int k) {
        assert 99 < k && k < 1000: "Number should be 3-digit long";
        return (k % 10) * 100 + ((k / 10) % 10) * 10 + (k / 100);
    }
    /**
     *
     * @param A ,
     * @param B ,
     * @param C ,
     * @return true, if all numbers are positive
     */
    public boolean booleanTask(int A, int B, int C) {
        return (A > 0) && (B > 0) && (C > 0);
    }
    /**
     *
     * @param a ,
     * @param b ,
     * @param c ,
     * @return the minimum number
     */
    public int ifTask(int a, int b, int c) {
        if (a < b){
            if (a < c) return a;
            else return c;
        }
        else if (b < c) return b;
        else return c;
    }
    /**
     *
     * @param number is the index of the circle's value: 1 - radius, 2 - diameter, 3 - length of circumference, 4 - area
     * @param value is the required value
     * @return every value in order
     */
    public double[] switchTask(int number, double value) {
        assert value >= 0: "The value is geometrical, no negatives";
        double[] circle = new double[4];
        switch (number) {
            case 1 -> {
                circle[0] = value;
                circle[1] = 2 * value;
                circle[2] = 2 * 3.14 * value;
                circle[3] = 3.14 * value * value;
                return circle;
            }
            case 2 -> {
                circle[0] = value / 2;
                circle[1] = value;
                circle[2] = 3.14 * value;
                circle[3] = 3.14 * value * value / 4;
                return circle;
            }
            case 3 -> {
                circle[0] = value / 2 / 3.14;
                circle[1] = value / 3.14;
                circle[2] = value;
                circle[3] = circle[0] * circle[0] * 3.14;
                return circle;
            }
            case 4 -> {
                circle[0] = sqrt(value / 3.14);
                circle[1] = 2 * circle[0];
                circle[2] = 2 * 3.14 * circle[0];
                circle[3] = value;
                return circle;
            }
            default -> {
            }
        }
        return circle;
    }
    /**
     *
     * @param n is an integer
     * @return the product: 1.1 * 1.2 * ... * (1 + n * 0.1) for i: 1 to n
     */
    public double forTask(int n) {
        assert n > 0: "Argument should be more than zero";
        double increment = 1.1;
        double product = 1.1;
        for(int i = 0; i < n - 1; i++){
            increment += 0.1;
            product *= increment;
        }
        return product;
    }
    /**
     *
     * @param n is an integer bigger than 1
     * @return the sum and the smallest k such that: sum = 1 + 2 +...+ k >= n
     */
    public int[] whileTask(int n) {
        assert n > 1: "Input should be more than 1";
        int k = 1;
        int sum = 0;
        while (sum < n){
            sum += k;
            k++;
        }
        return new int[] {k - 1, sum};
    }
    /**
     *
     * @param array ,
     * @return the smallest positive integer, if there are none ,return 0
     */
    public int minMaxTask(int[] array){
        int n = array.length;
        int min = 0;
        int j = 0;
        for(;j < n; j++){
            if (array[j] > 0){
                min = array[j];
                break;
            }
        }
        for(int i = j; i < n; i++){
            if (array[i] <= 0);
            else if (array[i] < min){
                min = array[i];
            }
        }
        return min;
    }
    /**
     *
     * @param array with an even length
     * @return all elements from array with even indexes
     */

    public double[] arrayTask(double[] array) {
        int n = array.length;
        assert n % 2 == 0: "The array should have an even amount of numbers";

        double[] res = new double[n / 2];
        int j = 0;
        for(int i = 1; i < n; i += 2){
            res[j] = array[i];
            j++;
        }
        return res;
    }
    /**
     *
     * @param array is the matrix
     * @return a matrix where every even column is backwards
     */
    public int[][] matrixTask(int[][] array){
        int n = array.length;
        int m = array[0].length;
        for(int i = 1; i < n; i++){
            assert array[i].length == m: "The 2D array should be a matrix";
        }

        int temp;
        for(int j = 0; j < m; j++){
            if(j % 2 == 1){
                for(int i = 0; i < n / 2; i++){
                    temp = array[n - i - 1][j];
                    array[n - i - 1][j] = array[i][j];
                    array[i][j] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String... strings) {
        System.out.println("Start of zero lab");
        System.out.println("Done!!!");
    }

}
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
        return new Object[][]{{110, 11}, {374, 473}, {808, 808}};
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
        return new Object[][]{{1, 2, 3, 1}, {25, 25, 25, 25}, {-23, -69, -10, -69}};
    }

    //////////////////////////////////////////////////

    @Test(dataProvider = "booleanProvider")
    public void booleanTest(int p1, int p2, int p3, boolean p4) {
        assertEquals(new Variant12().booleanTask(p1, p2, p3), p4);
    }

    @DataProvider
    public Object[][] booleanProvider() {
        return new Object[][]{{1, 1, 1, true}, {0, 17, 42, false}, {-3, 57000, 69, false}};
    }

    //////////////////////////////////////////////////

    @Test(dataProvider = "switchProvider")
    public void switchTest(int p1, double p2, double[] arr) {
        assertEquals(new Variant12().switchTask(p1, p2), arr);
    }

    @DataProvider
    public Object[][] switchProvider() {
        return new Object[][]  {{1, 1, new double[] {1, 2, 6.28, 3.14}},
                                {2, 6, new double[] {3, 6, 6.28 * 3, 3.14 * 3 * 3}},
                                {3, 6.28 * 4, new double[] {4, 8, 6.28 * 4, 3.14 * 4 * 4}},
                                {4, 3.14 * 10.1 * 10.1, new double[] {10.1, 20.2, 6.28 * 10.1, 3.14 * 10.1 * 10.1}}};
    }

    @Test(expectedExceptions = AssertionError.class)
    public void switchNegativeTest() {
        new Variant12().switchTask(9, -1);
    }

    ///////////////////////////////////////////////////

    @Test(dataProvider = "forProvider")
    public void forTest(int n, double p2) {
        assertEquals(new Variant12().forTask(n), p2, EPS);
    }

    @DataProvider
    public Object[][] forProvider() {
        return new Object[][]{{3, 1.716}, {7, 9.801792}, {12, 309.744468}};
    }

    @Test(expectedExceptions = AssertionError.class)
    public void negativeForTest(){
        new Variant12().forTask(-3);
    }

    ///////////////////////////////////////////////////

    @Test(dataProvider = "whileProvider")
    public void whileTest(int n, int[] res) {
        assertEquals(new Variant12().whileTask(n), res);
    }

    @DataProvider
    public Object[][] whileProvider() {
        return new Object[][]  {{5, new int[]{3, 6}},
                                {10, new int[]{4, 10}},
                                {100, new int[]{14, 105}}};
    }

    @Test(expectedExceptions = AssertionError.class)
    public void negativeWhileTest() {
        new Variant12().whileTask(0);
    }

    ///////////////////////////////////////////////////

    @Test(dataProvider = "minMaxProvider")
    public void minMaxTest(int[] arr, int min) {
        assertEquals(new Variant12().minMaxTask(arr), min);
    }

    @DataProvider
    public Object[][] minMaxProvider() {
        return new Object[][]  {{new int[]{1, 2, 3, 4, 5, 0, 10}, 1},
                                {new int[]{-1, -2, -69}, 0},
                                {new int[]{0}, 0}};
    }

    //////////////////////////////////////////

    @Test(dataProvider = "arrayProvider")
    public void arrayTest(double[] array, double[] value) {
        assertEquals(new Variant12().arrayTask(array), value);
    }

    @DataProvider
    public Object[][] arrayProvider() {
        return new Object[][]  {{new double[]{10.5, 11.6, 3.7, 21.21}, new double[] {11.6, 21.21}},
                                {new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, new double[] {2, 4, 6, 8, 10}},
                                {new double[]{-4, 3.14, 5, -4, 9.9999999, -2.71828}, new double[] {3.14, -4, -2.71828}}};
    }

    @Test(expectedExceptions = AssertionError.class)
    public void negativeArrayTest(){
        new Variant12().arrayTask(new double[] {0, 1, 2});
    }

    //////////////////////////////////////////

    @Test(dataProvider = "matrixProvider")
    public void matrixTest(int[][] input, int[][] output) {
        assertEquals(new Variant12().matrixTask(input), output);
    }

    @DataProvider
    public Object[][] matrixProvider() {
        int[][] input1 = {{1, 2},
                          {3, 4}};

        int[][] input2 = {{0, -10, -9, 1, 2, -8},
                          {6,   6, -6, 6, 6, -6},
                          {-9, 98,  9, 5, 5,  4}};

        int[][] output1 = {{1, 4},
                           {3, 2}};

        int[][] output2 = {{ 0,  98, -9, 5, 2,  4},
                           { 6,   6, -6, 6, 6, -6},
                           {-9, -10,  9, 1, 5, -8}};

        return new Object[][]{{input1, output1}, {input2, output2}};
    }

    @Test(expectedExceptions = AssertionError.class)
    public void negativeMatrixTest(){
        new Variant12().matrixTask(new int[][] {{7},
                                                {7, 7},
                                                {7, 7, 7}});
    }
}
