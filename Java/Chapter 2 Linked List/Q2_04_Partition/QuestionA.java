package Q2_04_Partition;

import CtCILibrary.LinkedListNode;

/**
 * 2.4 Partition :
 * 
 * Write code to partition a linked list around a value x, such that all nodes
 * less than x come before all nodes greater than or equal to x. If x is
 * contained within the list, the values of x only need to be after the elements
 * less x (see below). The partition element x can appear anywhere in the "right
 * partition"; it does not need to appear between the left and right partitions.
 * 
 * EXAMPLE
 * 
 * Input : 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition = 5]
 * 
 * Output : 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 * 
 * @author gayle
 *
 */
public class QuestionA {

	public static LinkedListNode partition(LinkedListNode node, int x) {
		LinkedListNode beforeStart = null;
		LinkedListNode beforeEnd = null;
		LinkedListNode afterStart = null;
		LinkedListNode afterEnd = null;
		
		/* Partition list */
		while (node != null) {
			LinkedListNode next = node.next;
			node.next = null;
			if (node.data < x) {
				if (beforeStart == null) {
					beforeStart = node;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.next = node;
					beforeEnd = node;
				}
			} else {
				if (afterStart == null) {
					afterStart = node;
					afterEnd = afterStart;
				} else {
					afterEnd.next = node;
					afterEnd = node;
				}
			}	
			node = next;
		}
		
		/* Merge before list and after list */
		if (beforeStart == null) {
			return afterStart;
		}
		
		beforeEnd.next = afterStart;
		return beforeStart;
	}
	
	public static void main(String[] args) {
		/* Create linked list */
		//int[] vals = {33,9,2,3,10,10389,838,874578,5};	// partition = 3	
		int[] vals = {3 , 5 , 8 , 5 , 10 , 2 , 1}; 	// partition = 5
		int part = 5;
		
		LinkedListNode head = new LinkedListNode(vals[0], null, null);
		LinkedListNode current = head;
		for (int i = 1; i < vals.length; i++) {
			current = new LinkedListNode(vals[i], null, current);
		}
		System.out.println(head.printForward());
		
		/* Partition */
		LinkedListNode h = partition(head, part);
		
		/* Print Result */
		System.out.println(h.printForward());
	}
}
