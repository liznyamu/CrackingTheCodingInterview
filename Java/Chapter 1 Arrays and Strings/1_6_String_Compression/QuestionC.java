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
 * @author gayle
 */
public class QuestionC {

    public static String compress(String str) {
        int finalLength = countCompression(str);
        if (finalLength >= str.length()) {
            return str;
        }

        StringBuffer compressed = new StringBuffer(finalLength); // initialize capacity
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            /* If next character is different than current, append this char to result.*/
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.toString();
    }

    public static int countCompression(String str) {
        int compressedLength = 0;
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            /* If next character is different than current, append this char to result.*/
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedLength += 1 + String.valueOf(countConsecutive).length();
                countConsecutive = 0;
            }
        }
        return compressedLength;
    }

    public static void main(String[] args) {
        String str = "aa";
        System.out.println(str);
        System.out.println(compress(str));
    }

}
