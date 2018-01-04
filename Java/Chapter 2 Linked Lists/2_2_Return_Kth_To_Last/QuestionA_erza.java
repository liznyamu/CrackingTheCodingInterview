package erza;

import CtCLibrary_erza.AssortedMethods;
import CtCLibrary_erza.LinkedListNode;

/**
 * Question 2.2 : Return Kth to Last 
 * 
 * Implement an algorithm to find the kth to
 * last element of a singly linked list
 * 
 * 
 * 
 * @author erza
 *
 */
public class QuestionA_erza {
	
	public static void main(String[] args) {
		// Create Singly linked List from Array
		int[] array = {0, 1, 2, 3, 4, 5, 6};
		LinkedListNode head = AssortedMethods.createLinkedListFromArray(array);
		
		for(int i = 0; i <= array.length ; i ++) {
		printKthToLast(head, i);
		}
		
	}

	private static int printKthToLast(LinkedListNode head, int k) {
		if(head == null) {
			return 0;
		}
		
		int index = printKthToLast(head.next, k) + 1;
		if(index == k) {
			System.out.println(k + " th to last node is " + head.data);
		}
		return index;
		
		
		
	}

	

}
