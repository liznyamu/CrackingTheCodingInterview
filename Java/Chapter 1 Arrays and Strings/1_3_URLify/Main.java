/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1_3_urlify;

import CtCILibrary.AssortedMethods;

/**
 *
 * Problem 1.3 URLify : Write a method to replace all spaces in a string with
 * '%20'. Assume string has sufficient space at end of string to hold additional
 * characters, and that you're given a true length of a string. (Note: If
 * implementing in Java, please use a character array so that you can perform
 * this operation in place)
 *
 * EXAMPLE Input: "Mr John Smith ", 13 Output: "Mr%20John%20Smith"
 *
 * @author erza
 */
public class Main {

    //Assume string has sufficient free space at the end
    public static void replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0, index, i;
        for (i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }

        index = trueLength + spaceCount * 2;
        
        System.out.println("True Length : " + trueLength);
        System.out.println("New Length : " + index);
        
        //str[index] = '\0';
        str[index] = Character.MIN_VALUE; //empty character

        

        for (i = trueLength - 1; i >= 0; i--) {
//           System.out.println("Counter index: " + index
//                    + " - Item at i : " + str[index]);

            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }

    }

    public static int findLastCharacter(char[] str) {
        for (int i = str.length - 1; i >= 0; i--) { //Test with string "", " ", "u  ", " u"
            if (str[i] != ' ') {
                return i;
            }

        }
        return -1;

    }

    public static void main(String[] args) {
        String str = "Mr John Smith     ";
        char[] arr = str.toCharArray();        
        System.out.println("\"" + AssortedMethods.charArrayToString(arr)
                + "\"");
        
        int trueLength = findLastCharacter(arr) + 1;
        replaceSpaces(arr, trueLength); 
        System.out.println("\"" + AssortedMethods.charArrayToString(arr)
                + "\"");
    }

}
