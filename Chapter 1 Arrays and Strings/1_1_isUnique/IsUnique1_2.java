/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isunique1_1;

/**
 * Cracking The Coding Interview Question 1.1 Implement an algorithm to
 * determine if a string has all unique characters What if you can not use
 * additional dataStructure
 *
 * @author erza
 */
public class IsUnique1_2 {

    /**
     * Assuming string has lower case 'a' through to 'z' - using a bitVector /
     * bitSet - Reducing Space used
     * 
     * Stack overflow : http://bit.ly/2rGicSY
     * Note (1 << val) - bit representation on index val
     * (checker & (1 << val)) > 0 bit check on the index val on int checker (8 * 4 bits/flags)
     *
     * @param str
     * @return
     */
    public static boolean isUniqueChars_BitVector(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); ++i) {
            int val = str.charAt(i) - 'a';
//            System.out.println("Bit wise check : " + (checker & (1 << val)));
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
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
        //String[] words = {"abcda"};

        for (String word : words) {
            System.out.println(word + ": " + isUniqueChars_BitVector(word));
        }
    }

}
