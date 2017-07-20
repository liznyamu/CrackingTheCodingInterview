/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isunique1_1;

/**
 * Cracking The Coding Interview
 * Question 1.1
 * Implement an algorithm to determine if a string has all unique characters
    What if you can not use additional dataStructure
 * @author erza
 */
public class IsUnique1_1 {

    /**
     * Assuming an ASCII character set 128 chars
     *
     * @param str
     * @return
     */
    public static boolean isUniqueChars(String str) {
        if (str.length() > 128) {
            return false;
        }
        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            System.out.println("Val is : " + val);
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

    /**
     * Run Program
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.println(word + ": " + isUniqueChars(word));
                    }
    }

}
