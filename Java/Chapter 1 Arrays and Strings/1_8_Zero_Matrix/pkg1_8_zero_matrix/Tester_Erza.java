/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1_8_zero_matrix;

import ErzaLibrary.VariousMethods;

/**
 *
 * @author erza
 */
public class Tester_Erza {

    public static void main(String[] args) {
        //Create a matrix and clone it
        int nrows = 10;
        int ncols = 15;
        
        int [][] matrixA = VariousMethods.createMatrix(nrows, ncols, -10, 10);
        int [][] matrixB = VariousMethods.cloneMatrix(matrixA);
        
        //Print the created and cloned Matrix
        VariousMethods.printMatrix(matrixA);
        System.out.println();
        
        //Set Zeros
        QuestionA_Erza.setZeros(matrixA);
        QuestionB_Erza.setZeros(matrixB);
        
        //Print the Matrix with Zeros
        VariousMethods.printMatrix(matrixA);
        System.out.println();
        
        VariousMethods.printMatrix(matrixB);
        System.out.println();
        
        //Compare if setZeros() on QuestionA_Erza is similar to QuestionB_Erza
        if(VariousMethods.matrixesAreEqual(matrixA, matrixB)){
            System.out.println("Erza ... They are Equal");
        }else{
            System.out.println("Erza ... They are Not Equal");
        }
        

    }

}
