/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1_2_checkpermutation;

/**
 * Question 1.2 Check Permutation : Given two strings, write a method to decide
 * if one is a permutation of the other.
 * 
 * Permutation : 
 * a way, especially one of several possible variations, in which a set or 
 * number of things can be ordered or arranged.
 *
 * @author erza
 */
public class Solution1 {

    /**
     * sort word characters numerically
     *
     * @param s to sort
     * @return
     */
    public static String sort(String s) {
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    /**
     * Check if the sorted string s and string t are equal
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean permutation(String s, String t) {
        return sort(s).equals(sort(t));
    }

    /**
     * Execute
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];

            boolean anagram = permutation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }
    }

}
