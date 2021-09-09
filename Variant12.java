package lab0;

import static java.lang.Math.sqrt;

public class Variant12 {

    /**
     *
     * @param k is square side
     * @return perimeter
     */
    public int inputOutputTask(int k) {
        return 0;
    }

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
     * @return every possible value in order
     */
    public double[] switchTask(int number, double value) {
        double[] circle = new double[4];
        switch (number) {
            case 1:
                circle[0] = value;
                circle[1] = 2 * value;
                circle[2] = 2 * 3.14 * value;
                circle[3] = 3.14 * value * value;
                return circle;
            case 2:
                circle[0] = value / 2;
                circle[1] = value;
                circle[2] = 3.14 * value;
                circle[3] = 3.14 * value * value / 4;
                return circle;
            case 3:
                circle[0] = value / 2 / 3.14;
                circle[1] = value / 3.14;
                circle[2] = value;
                circle[3] = value * value / 2;
                return circle;
            case 4:
                circle[0] = sqrt(value / 3.14);
                circle[1] = 2 * circle[0];
                circle[2] = 2 * 3.14 * circle[0];
                circle[3] = value;
                return circle;
            default:
                break;
        }
        return null;
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


    public int whileTask(int a, int b) {
        assert (a >0 && b > 0): "Argument should be more than zero";
        return 0;
    }

    public double arrayTask(double[] array) {
        return 0;
    }

    /**
     *
     * @param array
     * @param k1
     * @param k2
     * @return transformed array where row with indexes k1 and k2 was changed
     */
    public int[][]  twoDimensionArrayTask(int[][] array, int k1, int k2) {
        //return null;
        return array;
    }

    public static void main(String... strings) {
        System.out.println("Start of zero lab");
        System.out.println("Done!!!");
    }

}
