/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1_6_string_compression;

/**
 *
 * @author erza
 */
public class QuestionC_Erza {

    public static void main(String[] args) {
        String[] str1 = {"aa", "bbbccctrry", "sssrrrgghhcc"};
        for (String origi : str1) {
            System.out.println("");
            System.out.println("Uncompressed String : " + origi);
            System.out.println("Compressed String : " + compress(origi));

        }
    }

    public static String compress(String origi) {
        // check if the compressed length would be longer than origi
        if (compressLength(origi) >= origi.length()) {
            return origi;
        }

        StringBuffer compressed = new StringBuffer(origi.length());
        int consecutiveLength = 0;
        
        for(int i = 0; i < origi.length(); i++){
           consecutiveLength ++;
           
           if(i+1 >= origi.length() || origi.charAt(i) != origi.charAt(i + 1)){
               compressed.append(origi.charAt(i));
               compressed.append(consecutiveLength);
               consecutiveLength = 0;
           }
        }
        
        return compressed.toString();
    }

    /**
     * Returns the expected length of the Original string when compressed
     * @param origi
     * @return 
     */
    private static int compressLength(String origi) {
        int compresLength = 0;
        int consecutiveLength = 0;

        for (int i = 0; i < origi.length(); i++) {
            consecutiveLength++;

            if (i + 1 >= origi.length() || origi.charAt(i) != origi.charAt(i + 1)) {
                // count 1 ie the charAt(i) PLUS length of the con
                compresLength += 1 + String.valueOf(consecutiveLength).length();
                consecutiveLength = 0;
            }
        }
        return compresLength; 
    }

}
