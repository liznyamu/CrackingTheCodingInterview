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
public class Tester {

    public static void test(String a, String b, boolean expected) {
        boolean resultA = QuestionA.oneEditAway(a, b);
        boolean resultB = QuestionB.oneEditAway(a, b);

        if (resultA == expected && resultB == expected) {
            System.out.println(a + ", " + b + ": success");
        } else {
            System.out.println(a + ", " + b + ": error");
        }
    }

    public static void main(String[] args) {
        String[][] tests = {{"a", "b", "true"},
        {"", "d", "true"},
        {"d", "de", "true"},
        {"pale", "pse", "false"},
        {"acdsfdsfadsf", "acdsgdsfadsf", "true"},
        {"acdsfdsfadsf", "acdsfdfadsf", "true"},
        {"acdsfdsfadsf", "acdsfdsfads", "true"},
        {"acdsfdsfadsf", "cdsfdsfadsf", "true"},
        {"adfdsfadsf", "acdfdsfdsf", "false"},
        {"adfdsfadsf", "bdfdsfadsg", "false"},
        {"adfdsfadsf", "affdsfads", "false"},
        {"pale", "pkle", "true"},
        {"pkle", "pable", "false"}};
        for (int i = 0; i < tests.length; i++) {
            String[] test = tests[i];
            String a = test[0];
            String b = test[1];
            boolean expected = test[2].equals("true");

            test(a, b, expected);
            test(b, a, expected);
        }

    }

}
