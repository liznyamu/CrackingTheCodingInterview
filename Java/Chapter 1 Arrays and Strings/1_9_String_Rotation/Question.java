/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1_9_string_rotation;

/**
 * Question 9 : String Rotation
 * Assume you have a method isSubstring which checks if one word is a substring
 * of another. 
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of 
 * s1 using only once call to isSubstring 
 * (e.g., "waterbottle" is a rotation of "erbottlewat").
 * 
 * @author gayle
 */
public class Question {
	public static boolean isSubstring(String big, String small) {
		if (big.indexOf(small) >= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isRotation(String s1, String s2) {
	    int len = s1.length();
	    /* check that s1 and s2 are equal length and not empty */
	    if (len == s2.length() && len > 0) { 
	    	/* concatenate s1 and s1 within new buffer */
	    	String s1s1 = s1 + s1;
	    	return isSubstring(s1s1, s2);
	    }
	    return false;
	}
	
	public static void main(String[] args) {
		String[][] pairs = {
                    {"apple", "pleap"}, 
                    {"waterbottle", "erbottlewat"}, 
                    {"camera", "macera"}};
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean is_rotation = isRotation(word1, word2);
			System.out.println(word1 + ", " + word2 + ": " + is_rotation);
		}
	}

}
