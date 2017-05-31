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
 * @author erza
 */
public class Solution2 {

    public static boolean permutation(String s, String t) {
        // Permutations must be same length
        if (s.length() != t.length()) {
            return false;
        }

        //assumming ASCII
        int[] letters = new int[128];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i)]++;
        }

        for (int i = 0; i < t.length(); i++) {
            letters[t.charAt(i)]--;
            if (letters[t.charAt(i)] < 0) {
                // letters array has negative(-1) values
                return false;
            }
        }

        // letters array has no negative values, and therefore no positive values
        return true;
    }

    public static void main(String[] args) {
        String[][] pairs = {{"hello", "llohl"}, {"green","ngreee"}, 
            {"orange","rgenao"}};
        for(String [] pair : pairs){
            String word1 = pair[0];
            String word2 = pair[1];
            
            boolean anagram = permutation(word1, word2);
            System.out.println(word1 + ", " + word2 + " : " + anagram);
        }
    }
}
