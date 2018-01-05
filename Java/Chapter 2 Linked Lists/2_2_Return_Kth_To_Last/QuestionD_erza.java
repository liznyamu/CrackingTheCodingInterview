package erza;

import CtCLibrary_erza.AssortedMethods;
import CtCLibrary_erza.LinkedListNode;

public class QuestionD_erza {
	
	private static LinkedListNode kthToLast(LinkedListNode head, int k) {
		LinkedListNode p1 = head;
		LinkedListNode p2 = head;
		
		/* Move p1 - k nodes into the List */
		for (int i = 0; i < k; i++) {
			if (p1 == null) {
				return null; //Out of bounds -- do not proceed to moving to next node
			}
			
			p1 = p1.next;
		}
		

		/* Move p1 and p2 together -- until p1 get to last ie is null then 
		 * p2 will be on the right node */
		while(p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		
		
		return p2;
	}

	public static void main(String[] args) {
		// create list from array
		int[] array = {0, 1, 2, 3, 4};
		LinkedListNode head = AssortedMethods.createLinkedListFromArray(array);
		
		for(int i = 0; i <= array.length + 1; i++) {
			LinkedListNode node  = kthToLast(head, i);
			String nodeValue = node == null ? " null" : "" + node.data;
			System.out.println( i + ": " + nodeValue);
		}
	}

	
}
