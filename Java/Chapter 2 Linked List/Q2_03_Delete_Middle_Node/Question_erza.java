package Q2_03_Delete_Middle_Node;

import CtCLibrary_erza.AssortedMethods;
import CtCLibrary_erza.LinkedListNode;

/**
 * Question 2.3 : Delete Middle Node
 * 
 * Implement an algorithm to delete a node in the middle (i.e, any node but the
 * first or last node, not necessarily the exact middle) of a SINGLY LINKED
 * LIST, given only access to that node.
 * 
 * EXAMPLE Input : the node c from the linked list
 * 
 *  a -> b -> c -> d -> e -> f
 *  
 * Result: nothing is returned, but the new linked list looks like
 * 
 *  a -> b -> d -> e -> f
 * 
 * @author erza
 *
 */
public class Question_erza {
	
	private static boolean deleteNode(LinkedListNode n) {
		
	/* Delete node if node is not null OR not last  OR not first ?? */
		if( n == null || n.next == null ) {
			return false;
		}
		
		LinkedListNode next = n.next;
		n.data = next.data;
		n.next = next.next;
		return true;
	}

	
	public static void main(String[] args) {
		//TODO create AssortedMethods.randomLinkedList()
		
		/* Create Linked List from an array */
		int[] array = {0, 1, 2, 3, 4, 5};
		LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
		System.out.println(head.printForward());
		deleteNode(head.next.next.next);
		System.out.println(head.printForward());
	}


	
	
	
}
