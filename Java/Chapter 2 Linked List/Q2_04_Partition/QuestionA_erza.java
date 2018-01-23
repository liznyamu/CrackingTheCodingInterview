package Q2_04_Partition;

import CtCLibrary_erza.LinkedListNode;

/**
 * 2.4 Partition :
 * 
 * Write code to partition a linked list around a value x, such that all nodes
 * less than x come before all nodes greater than or equal to x. If x is
 * contained within the list, the values of x only need to after the elements
 * less than x (see below). The partition element x can appear anywhere in the
 * "right partition"; it does not need to appear between the left and right
 * partitions.
 * 
 * EXAMPLE
 * 
 * Input : 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition = 5]
 * 
 * Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 * 
 * @author erza
 * 
 *         Refer to : http://bit.ly/2E1nfU9
 *
 */

public class QuestionA_erza {

	/**
	 * Partition into 2 groups (ie before/left and after/right the Partition) with 2
	 * Pointers each - one at the start of each partition - one at the end of each
	 * partition
	 * 
	 * @param node
	 * @param partitionValue
	 * @return
	 */
	public static LinkedListNode partition(LinkedListNode node, int partitionValue) {

		// pointers for left/before partition
		LinkedListNode leftStart = null;
		LinkedListNode leftEnd = null;

		// pointers for right/after partition
		LinkedListNode rightStart = null;
		LinkedListNode rightEnd = null;

		while (node != null) {
			LinkedListNode next = node.next;

			// set remove pointer to next
			node.next = null;

			// check data on node and determine if node goes BEFORE partitionValue or AFTER
			if (node.data < partitionValue) {
				// set beforeStart and afterStart
				if (leftStart == null) {
					leftStart = node;
					leftEnd = leftStart; // point to same instance of the LinkedListNode
				} else {
					leftEnd.next = node; // set link to next node
					leftEnd = node; // move pointer to last node
				}

			} else {
				// set afterStart and afterEnd
				if (rightStart == null) {
					rightStart = node;
					rightEnd = rightStart;
				} else {
					rightEnd.next = node; // set link to next node
					rightEnd = node; // move pointer to last node

				}

			}

			// Assign instance of 'next' to 'node'
			node = next;
		}

		if (leftStart == null) {
			return rightStart;
		}

		leftEnd.next = rightStart;
		return leftStart;

	}

	public static void main(String[] args) {

		int[] arrayVals = { 3, 5, 8, 5, 10, 2, 1 };
		int partitionValue = 5;

		LinkedListNode head = new LinkedListNode(arrayVals[0], null, null);
		LinkedListNode current = head;

		for (int i = 1; i < arrayVals.length; i++) {
			current = new LinkedListNode(arrayVals[i], null, current);
		}

		System.out.println(head.printForward());

		LinkedListNode parted  = partition(head, partitionValue);
		
		System.out.println(parted.printForward());

	}

}
