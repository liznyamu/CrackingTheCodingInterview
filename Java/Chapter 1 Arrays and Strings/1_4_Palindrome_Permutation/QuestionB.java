/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1_4_palindrome_permutation;

/**
 *
 * @author erza
 */
public class QuestionB {

    public static boolean isPermutationOfPalindrome(String phrase) {
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z') 
                - Character.getNumericValue('a') + 1];
        
        for (char c : phrase.toCharArray()) {
            int x = Common.getCharNumber(c);
            
            if (x != -1) {
                table[x]++;

                if (table[x] % 2 == 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
            
        }
        
        //System.out.println("Count Odd : " + countOdd);
        return countOdd <= 1;
    }

    public static void main(String[] args) {
        String pali = "Ratzs live on no evil starz";
        System.out.println("Phrase : " + pali);
        System.out.println(isPermutationOfPalindrome(pali));
        
        String pali2 = "Zeus was deified, saw Suez";
        System.out.println("Phrase : " + pali2);
        System.out.println(isPermutationOfPalindrome(pali2));
    }

}
 