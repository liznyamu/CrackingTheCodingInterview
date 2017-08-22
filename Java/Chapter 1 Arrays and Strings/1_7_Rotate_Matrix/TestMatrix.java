/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1_7_rotate_matrix;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author erza
 */
public class TestMatrix {

    public static void main(String[] args) {
        
        System.out.println("Erza");
        
        //Create a nXn matrix
        int[][] matrix = createMatrix(4, 4, 10, 100);

        //print created matrix
        printMatrix(matrix);

        //rotate matrix
        rotate(matrix);

        System.out.println();

        // print rotated matrix
        printMatrix(matrix);
    }

    /**
     * Create a (row * col) matrix with range(min, max) incusive
     *
     * @param row - row count
     * @param col - column count
     * @param min - minimum value
     * @param max - maximum value
     * @return
     */
    private static int[][] createMatrix(int row, int col, int min, int max) {
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = randomIntInRange(min, max);
            }
        }

        return matrix;
    }

    /**
     * Generates a random integer on the range 'min' to 'max' inclusive Refer to
     * http://bit.ly/2vkkhE9
     *
     */
    private static int randomIntInRange(int min, int max) {

        //Method for >= Java 1.7
        return ThreadLocalRandom.current().nextInt(min, max + 1);

        /**
         * // Method used before Java 1.7 Random rand = new Random(); return
         * rand.nextInt((max - min) + 1) + min; // +1 range inclusive of max
         */
    }

    /**
     * Padding as 00001 OR 000-1 00011 OR 00-11 00111 OR 0-111
     *
     * @param matrix
     */
    private static void printMatrix(int[][] matrix) {
        for (int[] rowVector : matrix) {
            for (int j = 0; j < rowVector.length; j++) {

                //Padding 2 digits
                if (rowVector[j] < 100 && rowVector[j] > -100) {
                    System.out.print(" ");
                }

                //Padding 2 1 digit
                if (rowVector[j] < 10 && rowVector[j] > -10) {
                    System.out.print(" ");
                }

                //Padding for negative sign
                if (rowVector[j] >= 0) {
                    System.out.print(" ");
                }

                //Pad and Print the number
                System.out.print(" " + rowVector[j]);
            }
            //New Row
            System.out.println();
        }
    }

    /**
     * Check solution explained on http://bit.ly/2iogwfV
     * @param matrix
     * @return 
     */
    private static boolean rotate(int[][] matrix) {
        // Check if matrix is n*n AND n > 1 ie Square Matrix
        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            return false;
        }

        int n = matrix.length;

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - first;

            for (int i = first; i < last; i++) {

                int offset = i - first;
                //save top
                int top = matrix[first][i];

                // move left top
                matrix[first][i] = matrix[last - offset][i];

                // move bottom to left
                matrix[last - offset][i] = matrix[last][last - offset];

                // move right to bottom
                matrix[last][last - offset] = matrix[i][last];

                // move top to right
                matrix[i][last] = top;

            }
        }

        return true;
    }

}
