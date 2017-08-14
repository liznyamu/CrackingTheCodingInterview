/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1_6_string_compression;

/**
 * 1.6 String Compression
 * Implement a method to perform basic string compression using the counts 
 * of repeated characters.
 * Example : aabcccccaaa would become a2b1c5a3. 
 * If the compressed string would not become smaller than the original string. 
 * Your method should return the original string. 
 * You can assume the string has only uppercase and lowercase letters (a - z)
 * 
 * @author erza
 */
public class Tester {

	public static void main(String[] args) {
		String str = "aaaaabbbbaaaabbddc";
		System.out.println(str);
		System.out.println(QuestionA.compressBad(str));
		System.out.println(QuestionB_Erza.compress(str));
		System.out.println(QuestionC_Erza.compress(str));
	}

}