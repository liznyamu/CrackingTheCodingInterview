/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1_9_string_rotation;

/**
 *
 * Question 9 : String Rotation Assume you have a method isSubstring which
 * checks if one word is a substring of another. Given two strings, s1 and s2,
 * write code to check if s2 is a rotation of s1 using only once call to
 * isSubstring (e.g., "waterbottle" is a rotation of "erbottlewat").
 *
 * @author erza
 */
public class Question_Erza {
    
    private static boolean isSubstring(String word1, String word2) {
        
        System.out.println("Long Word: " + word1);
        
        if(word1.indexOf(word2) >= 0){
            return true;
        }
        
        return false;
        
    }

    /**
     * Check if word1 isRotation of word2
     * @param word1
     * @param word2
     * @return 
     */
    private static boolean isRotation(String word1, String word2) {

        //Check length
        if(word1.length() == word2.length() && word1.length() > 0){
            return isSubstring(word1+word1, word2);
            
        }
        
        return false;
    }

    public static void main(String[] args) {
        //Create a pair of strings
        String[][] pairs = {
            {"waterbottle", "erbottlewat"},
            {"top", "opt"},
            {"bank", "nkba"},
            {"harrypotter", "potterharry"}
        };

        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            
            boolean is_Rotation = isRotation(word1, word2);
            System.out.println("{ " + word1 + " , " + word2 + " } : " + is_Rotation);
        }
    }


}
