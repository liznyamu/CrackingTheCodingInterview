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
 * @author erza
 */
public class QuestionB_Erza {

    public static void main(String[] args) {
        String[] str1 = {"aa", "bbbccctrry", "sssrrrgghhcc"};
        for (String origi : str1) {
            System.out.println("");
            System.out.println("Uncompressed String : " + origi);
            System.out.println("Compressed String : " + compress(origi));

        }

//        String str = "aa";
//        System.out.println("Uncompressed String : " + str);
//        System.out.println("Compressed String : " + compress(str));
    }

    public static String compress(String str) {
        StringBuilder compressedString = new StringBuilder();
        int countOccurrence = 0;

        for (int i = 0; i < str.length(); i++) {
            countOccurrence++;

            //if i+1 == str.length() - if on last char 
            // OR 
            //if str.charAt i != str.charAt i+1 then 
            //  append str.charAt i , countOccurrence
            //  reset countOccurence =1
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedString.append(str.charAt(i));
                compressedString.append(countOccurrence);
                countOccurrence = 0;
            }

        }

        // check return string with shorter length
       // System.out.println("Compressed String : " + compressedString.toString());
        return compressedString.length() < str.length() ? compressedString.toString() : str;
    }

}
