/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1_5_one_away;

/**
 *
 * [1:5]. One Away: There are three types of edits that can be 
 * performed on strings: insert a character, remove a character, 
 * or replace a character. Given two strings, write a function
 * to check if they are one edit (or zero edits) away.
 * 
 * Time complexity: O(n). Where n is the shorter string
 * Space complexity: O(1). only creating pointers and a counter 
 * 
 * @author erza
 */

public class QuestionA {

    /* Check if more than 1 characters has been replaced*/
    public static boolean oneEditReplace(String s1, String s2) {
        boolean foundDifference = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (foundDifference) {
                    return false;
                }

                foundDifference = true;
            }
        }
        return true;
    }
    

    /* Check if you can insert a character into s1 to make s2. */
    public static boolean oneEditInsert(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;
        
        //Zero based counting in Java ie index < s.length
        while (index2 < s2.length() && index1 < s1.length()) { 
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                //increment one index only
                index2++;
            } else {
                //increment index on both Phrases
                index1++;
                index2++;
            }
        }
        return true;
    }

    public static boolean oneEditAway(String first, String second) {
        if (first.length() == second.length()) {
            return oneEditReplace(first, second);
        } else if (first.length() + 1 == second.length()) {
            return oneEditInsert(first, second);
        } else if (first.length() - 1 == second.length()) {
            return oneEditInsert(second, first);
        }
        return false;
    }

    public static void main(String[] args) {
        String a = "pse";
        String b = "pale";
        
        boolean isOneEdit = oneEditAway(a, b);
        System.out.println(a + ", " + b + ": " + isOneEdit);
    }

}
