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
public class QuestionB_Erza {

    public static void main(String[] args) {
        
        String [][] pairs = {{"pale", "pilsi"}, {"pale", "pils"},
            {"pale", "pase"}, {"pale", "paler"}};
        
        for(String[] pair : pairs){
            String a = pair[0];
            String b = pair[1];
            boolean isOneEdit1 = oneEditAway(a, b);
            System.out.println(a + ", "+ b + ": " + isOneEdit1);
        }
       
    }

    public static boolean oneEditAway(String first, String second) {

        // check if diffrence in length is 1
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

        //s1 <= s2
        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : first;

//        System.out.println("S1 :  "+ s1);
//        System.out.println("S2 :  "+ s2);
        
        int index1 = 0;//Zero-based indexing
        int index2 = 0;
        
        boolean foundDiff = false;
        boolean diffChar;
        boolean sameLength = s1.length() == s2.length();
        
        
        while(index1 < s1.length() && index2 < s2.length()){
                
            diffChar = s1.charAt(index1) != s2.charAt(index2);
            if(diffChar){
                
                if(foundDiff){
                    return false; // diff occurred again
                }
                
                foundDiff = true;
                
            }
            
            if(sameLength || !diffChar){
                index1++; // then increment index1 if length same or same char on indexes
            }
            
            index2++; // always increment for longer string 2
        }
        
        return true;
    }

}
