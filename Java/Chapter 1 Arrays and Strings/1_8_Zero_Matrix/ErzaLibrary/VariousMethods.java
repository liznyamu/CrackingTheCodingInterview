/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ErzaLibrary;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author erza
 */
public class VariousMethods {
    
    /**
     * Generate a randomInteger with range minValue to maxValue inclusive
     * @param minValue
     * @param maxValue
     * @return 
     */
    private static int  randomInteger(int minValue, int maxValue) {

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        return ThreadLocalRandom.current().nextInt(minValue, maxValue + 1);
    }

    /**
     * Create Integer NXN matrix, with range minValue to maxValue inclusive
     * @param nrow
     * @param ncol
     * @param minValue
     * @param maxValue
     * @return 
     */
    public static int[][] createMatrix(int nrow, int ncol, int minValue, int maxValue) {
        int[][] matrix = new int[nrow][ncol];

        for (int i = 0; i < nrow; i++) {
            for (int j = 0; j < ncol; j++) {
                matrix[i][j] = randomInteger(minValue, maxValue);
            }
        }

         return matrix;
    }

    /**
     * Print Matrix Elements 'elem' with Padding
     * Print /n for each Row
     * @param matrix 
     */
    public static void printMatrix(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){ 
                
                //Add Padding if elem >= 0
                if(matrix[i][j] >= 0){
                    System.out.print(" ");
                }
                
                //Add Padding if 10 > elem > -10
                if(10 > matrix[i][j] && matrix[i][j] > -10 ){
                    System.out.print(" ");
                }
                
                //Add Padding if 100 > elem > -100
                if (100 > matrix[i][j] && matrix[i][j] > -100 ){
                    System.out.print(" ");
                }
                
                //Print Element elem
                System.out.print(matrix[i][j]);
            }
            
            //Print /n for each Row
            System.out.println();
        }
    }

}
