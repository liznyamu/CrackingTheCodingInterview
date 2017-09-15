/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1_8_zero_matrix;

import ErzaLibrary.VariousMethods;

/**
 * Question 1.8 - Zero Matrix Write an algorithm such that if an element in an
 * NxN matrix is 0, its entire row and column are set to 0
 *
 * @author erza
 */
public class QuestionB_Erza {

    /**
     * Nullify Row number nrow
     *
     * @param matrix
     * @param nrow
     */
    public static void nullifyonRow(int[][] matrix, int nrow) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[nrow][j] = 0;
        }

    }

    /**
     * Nullify Cols based on zeros on First Column
     *
     * @param matrix
     * @param ncol
     */
    public static void nullifyonCol(int[][] matrix, int ncol) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][ncol] = 0;
        }
    }

    /**
     * Set Zeros on Rows and Cols with 0 Elements, elem
     *
     * @param matrix
     */
    public static void setZeros(int[][] matrix) {

        /**
         * For First Column and First Row Check if first Row has at least 1
         * element == Zero Check if first Column at least 1 element == Zero
         */
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        /**
         * For other Columns and other Rows
         * If elem (a, b) == 0 : given matrix.length > a > 0 AND
         * matrix[0].length > b > 0 Then : set first colum elem to Zero : (a, 0)
         * = 0 set first row elem to Zero (0, b) = 0
         */
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //nullify Rows greater than 0
        for (int nrow = 1; nrow < matrix.length; nrow++) {
            if (matrix[nrow][0] == 0) {
                nullifyonRow(matrix, nrow);
            }
        }

        //nullify greater than 0
        for (int ncol = 1; ncol < matrix[0].length; ncol++) {
            if (matrix[0][ncol] == 0) {
                nullifyonCol(matrix, ncol);
            }
        }

        //nullify First Row
        if (firstRowHasZero) {
            nullifyonRow(matrix, 0);
        }

        //nullify First Col
        if (firstColHasZero) {
            nullifyonCol(matrix, 0);
        }

    }

    public static void main(String[] args) {
        /**
         * For Erza Tests : 
         * Create matrix with (0, 0) == 0 
         * Create matrix with (0, n) == 0
         * Create matrix with (n, 0) == 0
         * Create matrix with (n, n) == 0
         * 
         * int[][] matrix = new int[][]{
            {1, 8, 8, 5},
            {8, 9, 10, 11},
            {12, 13, 14, 15},
            {0, 17, 9, 19}
        };
         * 
         */
        
        // create a matrix  
        int nrow = 10;
        int ncol = 10;
        int minValue = 0;
        int maxValue = 27;
        int [][] matrix = VariousMethods.createMatrix(nrow, ncol, minValue, maxValue);

        //Print Created Matrix
        VariousMethods.printMatrix(matrix);
        System.out.println();

        setZeros(matrix);

        //Print Nullified Matrix
        VariousMethods.printMatrix(matrix);
    }
}
