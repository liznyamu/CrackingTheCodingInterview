/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1_4_palindrome_permutation;

/**
 * Problem 1.4 Palindrome Permutation: Given a string, write a function to check
 * if it is a permutation of a palindrome. A palindrome is a word or phrase that
 * is the same forwards and backwards. A permutation is a rearrangement of
 * letters. The palindrome does not need to be limited to just dictionary words.
 *
 * Example : Input : Tact Coa 
 *           Output : True (permutations: "taco cat", "atco cta", etc.)
 *
 * @author erza
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] strings = {"Rats live on no evil star",
            "A man, a plan, a canal, panama",
            "Lleve",
            "Tacotac",
            "asda"};
        for (String s : strings) {
            boolean a = QuestionA.isPermutationOfPalindrome(s);
            boolean b = QuestionB.isPermutationOfPalindrome(s);
            boolean c = QuestionC.isPermutationOfPalindrome(s);
            
            System.out.println(s);
            
            if (a == b && b == c) {
                System.out.println("Agree: " + a);
            } else {
                System.out.println("Disagree: " + a + ", " 
                        + b + ", " + c);
            }
            
            System.out.println();
        }

    }

}
