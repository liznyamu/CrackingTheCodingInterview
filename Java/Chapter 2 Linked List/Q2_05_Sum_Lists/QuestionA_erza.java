package Q2_05_Sum_Lists;

import CtCLibrary_erza.LinkedListNode;

/**
 * Q 2.5 - Sum Lists
 * 
 * You have two numbers represented by a linked list, where each node contains a
 * single digit. The digits are stored in reverse order, such that the 1's
 * digits is at the head of the list. Write a function that adds the two numbers
 * and returns the sum as a linked list.
 * 
 * EXAMPLE
 * 
 * Input: (7 -> 1 -> 6) + (5 -> 9 -> 2). That is 617 + 295.
 * 
 * Output: 2 -> 1 -> 9. That is, 912.
 * 
 * 
 * FOLLOW UP
 * 
 * Suppose the digits are stored in forward order. Repeat the above problem.
 * 
 * EXAMPLE
 * 
 * Input: (6 -> 1 -> 7) + (2 -> 9 -> 5). That is, 617 + 295. Output: 9 -> 1 ->
 * 2. That is, 912
 * 
 * @author erza
 * 
 */

public class QuestionA_erza {

	/**
	 * The method is recursive as :
	 * 
	 * 617 = (((6 *10) + 1 ) * 10 ) + 7
	 * 
	 * 7 -> 1 -> 7
	 * 
	 * value | node.data | return
	 * 
	 * 0 ----| 6 ------- | 6
	 * 
	 * 60 ---| 1 ------- | 61
	 * 
	 * 610 -- | 7 ------ | 617
	 * 
	 * 
	 * @param node
	 * @return
	 */
	public static int linkedListToInt(LinkedListNode node) {
		int value = 0;

		if (node.next != null) {
			value = 10 * linkedListToInt(node.next);
		}

		/*
		 * System.out.println("Value heres is : " + value);
		 * System.out.println("Node Data is: " + node.data);
		 * 
		 * System.out.println("Value + Node Data is: " + (value + node.data));
		 * System.out.println();
		 */

		return value + node.data;

	}

	private static LinkedListNode sumLists(LinkedListNode node1, LinkedListNode node2, int carry) {

		// stop execution if both nodes are null and no carry value
		if (node1 == null && node2 == null && carry == 0) {
			return null;
		}

		// resulting value per digit in place
		LinkedListNode result = new LinkedListNode(0, null, null);

		// added value per digit in place
		int value = carry;

		if (node1 != null) {
			value += node1.data;
		}

		if (node2 != null) {
			value += node2.data;
		}

		// set digit on result in place
		result.data = value % 10;

		// recurse and set next node -- PS node1 and node2 dont have to have same length
		// ie avoid cases of (null -> next)
		LinkedListNode moreResults = sumLists(node1 == null ? null : node1.next, node2 == null ? null : node2.next,
				value > 10 ? 1 : 0);
		result.setNext(moreResults);

		return result;
	}

	public static void main(String[] args) {
		LinkedListNode nodeA1 = new LinkedListNode(7, null, null);
		LinkedListNode nodeB1 = new LinkedListNode(1, null, nodeA1);
		LinkedListNode nodeC1 = new LinkedListNode(6, null, nodeB1);

		LinkedListNode nodeA2 = new LinkedListNode(7, null, null); // 5
		LinkedListNode nodeB2 = new LinkedListNode(1, null, nodeA2); // 9
		LinkedListNode nodeC2 = new LinkedListNode(6, null, nodeB2); // 2

		// Create summed list
		LinkedListNode sumedList = sumLists(nodeA1, nodeA2, 0);

		System.out.println("  " + nodeA1.printForward());
		System.out.println("+ " + nodeA2.printForward());
		System.out.println("= " + sumedList.printForward());

		int intValue1 = linkedListToInt(nodeA1);
		int intValue2 = linkedListToInt(nodeA2);
		int intValueSum = linkedListToInt(sumedList);

		System.out.println(intValue1 + " + " + intValue2 + " = " + intValueSum);
		System.out.println(intValue1 + " + " + intValue2 + " = " + (intValue1 + intValue2));

	}

}
