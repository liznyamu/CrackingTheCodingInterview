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
 * Using Nested For Loop -- O(n^2) URL : http://bit.ly/2vW7yc0
 *
 * @author erza
 */
public class QuestionA_Erza {

    /**
     * Find Elements, 'elem', with Zeros then nullify its Row and Col
     *
     * @param matrix
     */
    public static void setZeros(int[][] matrix) {

        //Flags to identify row and col to nullify
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];

        //Loop through the matrix
        // if element, elem == 0 set flags row[i] and col[j]
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        //Nullify Matrix Row
        for (int i = 0; i < matrix.length; i++) {
            if (row[i]) {
                nullifyRow(matrix, i);
            }
        }

        //Nullify Matrix Col
        for (int j = 0; j < matrix[0].length; j++) {
            if (col[j]) {
                nullifyCol(matrix, j);
            }
        }
    }

    /**
     * Nullify Row, nrow, on matrix
     *
     * @param matrix
     * @param nrow
     */
    public static void nullifyRow(int[][] matrix, int nrow) {
        for(int j = 0; j < matrix[0].length; j++){
            matrix[nrow][j] = 0;
        }
    }

    /**
     * Nullify Column, ncol, on matrix
     *
     * @param matrix
     * @param ncol
     */
    public static void nullifyCol(int[][] matrix, int ncol) {
        for(int i = 0; i < matrix.length; i++){
            matrix[i][ncol] = 0;
        }

    }

    public static void main(String[] args) {
        //Create a NXN matrix, with atleast 1 element = 0
        int nrow = 10;
        int ncol = 10;
        int[][] matrix = VariousMethods.createMatrix(nrow, ncol, 0, 40);

        //Print Created Matrix 
        VariousMethods.printMatrix(matrix);

        //Set Zero on Rows and Cols
        setZeros(matrix);
        
        System.out.println();
        
        //Print Nullified Matrix
        VariousMethods.printMatrix(matrix);

    }

}
