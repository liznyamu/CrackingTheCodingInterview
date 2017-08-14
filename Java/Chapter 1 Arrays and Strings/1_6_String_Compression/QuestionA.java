/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1_6_string_compression;

/**
 * 1.6 String Compression Implement a method to perform basic string compression
 * using the counts of repeated characters. Example : aabcccccaaa would become
 * a2b1c5a3. If the compressed string would not become smaller than the original
 * string. Your method should return the original string. You can assume the
 * string has only uppercase and lowercase letters (a - z)
 * 
 * String is immutable ; attempting to change it creates a new string
 * StringBuilder - better choice in cases where string is to be modified multiple times
 *               - but is not synchronized ie 1 thread running it is okay
 *               - overloaded methods append() and insert()
 * 
 * StringBuffer - similar to StringBuilder and is synchronized ie used where there are multiple
 *              threads
 * 
 * URL Refer : http://bit.ly/2u43REa
 *
 * @author gayle
 */
public class QuestionA {

    public static String compressBad(String str) {
        String compressedString = "";
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            /* If next character is different than current, 
            append this char to result.*/
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedString += "" + str.charAt(i) + countConsecutive;
                countConsecutive = 0;
            }
        }
        
       // System.out.println("Compressed String is : " + compressedString);
        return compressedString.length() < str.length() ? compressedString : str;
    }

    public static void main(String[] args) {
        String [] originalString = {"aa", "aab", "aaabb"};
        for (String origi : originalString){
            System.out.println("");
            System.out.println(origi);
            System.out.println(compressBad(origi));
        }
        
//        String str = "aa";
//        System.out.println(str);
//        System.out.println(compressBad(str));
    }
}
