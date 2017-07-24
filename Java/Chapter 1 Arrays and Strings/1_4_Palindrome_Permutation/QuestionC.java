/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1_4_palindrome_permutation;

/**
 *
 * @author erza
 */
public class QuestionC {
    /* Toggle the ith bit in the integer. */
    /**
     * Refer to : http://www.vipan.com/htdocs/bitwisehelp.html
     * Refer to : http://bit.ly/2rGicSY
     * @param bitVector
     * @param index
     * @return 
     */

    public static int toggle(int bitVector, int index) {
        if (index < 0) {
            return bitVector;
        }

        int mask = 1 << index;
        if ((bitVector & mask) == 0) { //check if mask has been set
            bitVector |= mask; // Set Mask on index
        } else {
            bitVector &= ~mask; // un-Set Mask on index
        }
        return bitVector;
    }

    /* Create bit vector for string. For each letter with value i,
     * toggle the ith bit. */
    public static int createBitVector(String phrase) {
        int bitVector = 0;
        
        for (char c : phrase.toCharArray()) {
            int x = Common.getCharNumber(c);
            bitVector = toggle(bitVector, x);
        }
        
        return bitVector;
    }

    /* Check that exactly one bit is set by subtracting one from the 
     * integer and ANDing it with the original integer. */
    public static boolean checkExactlyOneBitSet(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }

    public static boolean isPermutationOfPalindrome(String phrase) {
        int bitVector = createBitVector(phrase);
//        System.out.println("Check that exactly one bit is set by subtracting"
//                + " one from the integer and ANDing it with the original interger" 
//                + " : "  + checkExactlyOneBitSet(bitVector) );
        return bitVector == 0 || checkExactlyOneBitSet(bitVector);
    }

    public static void main(String[] args) {
        String pali = "Rats live on no evil star";
        System.out.println("Phrase : " + pali);
        System.out.println(isPermutationOfPalindrome(pali));
        
        String pali2 = "Zeus was deified, saw Suez";
        System.out.println("Phrase : " + pali2);
        System.out.println(isPermutationOfPalindrome(pali2));
    }
}
