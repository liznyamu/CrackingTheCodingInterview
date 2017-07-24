/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1_4_palindrome_permutation;

import java.util.Arrays;

/**
 *
 * @author erza
 */
public class QuestionA {

    public static boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        
        return true;
    }

    public static boolean isPermutationOfPalindrome(String phrase) {
        int[] table = Common.buildCharFrequencyTable(phrase);
        
        //System.out.println("Table Created : " + Arrays.toString(table));
        return checkMaxOneOdd(table);
    }

    public static void main(String[] args) {
        String pali = "Rats live on no evil star";
        System.out.println("Phrase : " + pali);
        System.out.println(isPermutationOfPalindrome(pali));
        
        String pali2 = "Zeus was deified, saw Suez";
        System.out.println("Phrase : " + pali2);
        System.out.println(isPermutationOfPalindrome(pali2));
    }

}
