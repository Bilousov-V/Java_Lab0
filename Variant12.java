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
