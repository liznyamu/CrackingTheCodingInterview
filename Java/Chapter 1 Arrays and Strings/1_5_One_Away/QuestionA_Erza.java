/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1_5_one_away;

/**
 *
 * @author erza
 */
public class QuestionA_Erza {

    public static boolean oneEdit(String first, String second) {
        if (first.length() == second.length()) {
            return oneEditReplace(first, second);
        } else if (first.length() + 1 == second.length()) {
            return oneEditInsert(first, second);
        } else if (first.length() - 1 == second.length()) {
            return oneEditInsert(first, second);
        }

        return false;

    }

    public static boolean oneEditInsert(String first, String second) {
        int index1 = 0, index2 = 0;

        while (index1 < first.length() && index2 < second.length()) {
            if (first.charAt(index1) != second.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                //increment one index only
                index1++;

            } else {
                //increment index on both Phrases
                index1++;
                index2++;
            }

        }

        return true;

    }

    public static boolean oneEditReplace(String s1, String s2) {
        boolean foundDiff = false;

        for (int index = 0; index < s1.length(); index++) {
            if (s1.charAt(index) != s2.charAt(index)) {

                if (foundDiff) {
                    return false;
                }

                // indicate found difference
                foundDiff = true;
            }
            //else proceed to check next char
        }

        //found only one replace
        return true;
    }

    public static void main(String[] args) {
        boolean isOneEdit;

        String a = "ABCDE";
        String b = "AABCDE";
        isOneEdit = oneEdit(a, b);
        System.out.println("First : " + a + " Second : " + b
                + " is : " + isOneEdit);

        a = "pse";
        b = "pale";
        isOneEdit = oneEdit(a, b);
        System.out.println("First : " + a + " Second : " + b
                + " is : " + isOneEdit);

        a = "ABCD";
        b = "ABCE";
        isOneEdit = oneEdit(a, b);
        System.out.println("First : " + a + " Second : " + b
                + " is : " + isOneEdit);

        a = "ABCD";
        b = "ABFE";
        isOneEdit = oneEdit(a, b);
        System.out.println("First : " + a + " Second : " + b
                + " is : " + isOneEdit);

        a = "ABCDEG";
        b = "ABFE";
        isOneEdit = oneEdit(a, b);
        System.out.println("First : " + a + " Second : " + b
                + " is : " + isOneEdit);

    }

}
