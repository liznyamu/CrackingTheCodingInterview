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
public class QuestionB_erza {

	private static LinkedListNode insertBefore(LinkedListNode partialResult, int data) {
		// create new node
		LinkedListNode node = new LinkedListNode(data);
		if (partialResult != null) {
			node.next = partialResult;
		}
		return node;

	}

	/**
	 * Perform partial sums of the nodes and record if sum has carryOne or not
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	private static PartialResults sumListsPartial(LinkedListNode l1, LinkedListNode l2) {

		/*
		 * Stop recursion - when both l1 and l2 are at last node ie are null - issue on
		 * same length was sorted by padding with 0's
		 */
		if (l1 == null && l2 == null) {
			PartialResults partialR = new PartialResults();
			return partialR;
		}

		// Recursively perform sums
		PartialResults partialR = sumListsPartial(l1.next, l2.next);
		int val = partialR.carryOne + l1.data + l2.data;
		LinkedListNode node = insertBefore(partialR.pSum, val % 10); // link the partialR.pSum together
		partialR.pSum = node;
		partialR.carryOne = val >= 10 ? 1 : 0;

		return partialR;
	}

	/**
	 * Sum LinkedListNodes l1 and l2 . Return sum-med list
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	private static LinkedListNode sumLists(LinkedListNode l1, LinkedListNode l2) {
		// check if length is same -- else add padding or placeholders
		int len1 = length(l1);
		int len2 = length(l2);
		if (len1 < len2) {
			l1 = padList(l1, len2 - len1);
		} else {
			l2 = padList(l2, len1 - len2);
		}

		// CASE Gamma - 2 no.s - w/ 2 or more digits EA ==> sum w/o carry one ...eg 45 +
		// 33 = 78
		// CASE Delta - 2 no.s - w/ 2 or more digits EA ==> sum w/ carry one ....eg 49 +
		// 33 = 82
		// CASE Alpha - 2 no.s - w/ 1 digit EA ==> sum w/o carry one .....eg 1 + 1 = 2
		// CASE Beta - 2 no.s - w/ 1 digit EA ==> sum w/ carry one .......eg 9 + 2 = 11

		// use PartialResults DAO -- with partial sum and carryOne
		PartialResults partialR = sumListsPartial(l1, l2);
		if (partialR.carryOne == 0) {
			// no carry 1
			return partialR.pSum;
		} else {
			LinkedListNode finalResult = insertBefore(partialR.pSum, partialR.carryOne);
			return finalResult;
		}

	}

	/**
	 * Pad the list OR add Non-significant Zero's as place-holders - for the shorter
	 * list ie 31 to 031
	 * 
	 * @param list
	 * @param padValue
	 * @return
	 */
	private static LinkedListNode padList(LinkedListNode list, int padValue) {
		LinkedListNode head = list;

		// this also handles cases where padValue = 0
		for (int i = 0; i < padValue; i++) {
			LinkedListNode node = new LinkedListNode(0, null, null);
			node.next = head;
			head = node;
		}

		return head;

	}

	/**
	 * Recursively - find length of a LinkedListNode
	 * 
	 * @param node
	 * @return
	 */
	private static int length(LinkedListNode node) {
		// stop when node is null
		if (node == null) {
			return 0;
		}
		// recursively call length
		return 1 + length(node.next);
	}

	/**
	 * Convert LinkedLinkNode to Int
	 * 
	 * @param node
	 * @return
	 */
	private static int linkedLinkToInt(LinkedListNode node) {
		int value = 0;
		while (node != null) {
			value = (value * 10) + node.data;
			node = node.next;
		}

		return value;
	}

	/**
	 * Suppose the digits are stored in forward order.
	 * 
	 * Write a function that adds the two numbers and returns the sum as linked list
	 * 
	 * eg [3 -> 1] + [5 -> 9 -> 1] = [6 -> 2 -> 2]
	 * 
	 * 31 + 591 = 622
	 */
	public static void main(String[] args) {
		// l1 = 31
		LinkedListNode nodeAl1 = new LinkedListNode(3, null, null);
		LinkedListNode nodeBl1 = new LinkedListNode(1, null, nodeAl1);

		// LinkedListNode nodeAl1 = new LinkedListNode(5, null, null);
		// LinkedListNode nodeBl1 = new LinkedListNode(9, null, nodeAl1);
		// LinkedListNode nodeCl1 = new LinkedListNode(1, null, nodeBl1);

		// l2 = 591
		LinkedListNode nodeAl2 = new LinkedListNode(5, null, null);
		LinkedListNode nodeBl2 = new LinkedListNode(9, null, nodeAl2);
		LinkedListNode nodeCl2 = new LinkedListNode(1, null, nodeBl2);

		// sum the lists
		LinkedListNode sumList = sumLists(nodeAl1, nodeAl2);

		System.out.println("  " + nodeAl1.printForward());
		System.out.println("+ " + nodeAl2.printForward());
		System.out.println("= " + sumList.printForward());
		System.out.println();

		int l1 = linkedLinkToInt(nodeAl1);
		int l2 = linkedLinkToInt(nodeAl2);
		int suml3 = linkedLinkToInt(sumList);
		System.out.println(l1 + " + " + l2 + " = " + suml3);
		System.out.println(l1 + " + " + l2 + " = " + (l1 + l2));

	}

}
