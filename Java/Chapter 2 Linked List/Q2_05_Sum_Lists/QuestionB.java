package Q2_05_Sum_Lists;

import CtCILibrary.LinkedListNode;

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
 * @author gayle
 * 
 */
public class QuestionB {
	private static int length(LinkedListNode l) {
		if (l == null) {
			return 0;
		} else {
			return 1 + length(l.next);
		}
	}

	private static PartialSum addListsHelper(LinkedListNode l1, LinkedListNode l2) {
		if (l1 == null && l2 == null) {
			PartialSum sum = new PartialSum();
			return sum;
		}
		PartialSum sum = addListsHelper(l1.next, l2.next);
		int val = sum.carry + l1.data + l2.data;

		System.out.println("Previous : sum.sum.data : " + sum == null || sum.sum == null ? "null" : sum.sum.data);
		System.out.println("Previous sum.carry : " + sum.carry);
		System.out.println("l1.data : " + l1.data);
		System.out.println("l2.data : " + l2.data);
		System.out.println("Current : sum.sum.data : " + (val % 10));
		System.out.println("Current : sum.carry : " + (val / 10));
		System.out.println();

		LinkedListNode full_result = insertBefore(sum.sum, val % 10);
		sum.sum = full_result;
		sum.carry = val / 10;
		return sum;
	}

	private static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2) {
		int len1 = length(l1);
		int len2 = length(l2);
		if (len1 < len2) {
			l1 = padList(l1, len2 - len1);
		} else {
			l2 = padList(l2, len1 - len2);
		}
		PartialSum sum = addListsHelper(l1, l2);
		if (sum.carry == 0) {
			System.out.println("Return Node with : " + sum.sum.data);
			System.out.println("Return Carry Value : " + sum.carry);
			return sum.sum;
		} else {
			LinkedListNode result = insertBefore(sum.sum, sum.carry);
			System.out.println("Return Node with : " + sum.sum.data);
			System.out.println("Return Carry Value : " + sum.carry);
			return result;
		}
	}

	private static LinkedListNode padList(LinkedListNode l, int padding) {
		LinkedListNode head = l;
		for (int i = 0; i < padding; i++) {
			head = insertBefore(head, 0);
		}
		return head;
	}

	private static LinkedListNode insertBefore(LinkedListNode list, int data) {
		LinkedListNode node = new LinkedListNode(data);
		// LinkedListNode node = new LinkedListNode(data, null, null);
		if (list != null) {
			node.next = list;
		}
		return node;
	}

	public static int linkedListToInt(LinkedListNode node) {
		int value = 0;
		while (node != null) {
			value = value * 10 + node.data;
			node = node.next;
		}
		return value;
	}

	public static void main(String[] args) {
		LinkedListNode lA1 = new LinkedListNode(3, null, null);
		LinkedListNode lA2 = new LinkedListNode(1, null, lA1);

		LinkedListNode lB1 = new LinkedListNode(5, null, null);
		LinkedListNode lB2 = new LinkedListNode(9, null, lB1);
		LinkedListNode lB3 = new LinkedListNode(1, null, lB2);

		LinkedListNode list3 = addLists(lA1, lB1);

		System.out.println("  " + lA1.printForward());
		System.out.println("+ " + lB1.printForward());
		System.out.println("= " + list3.printForward());

		int l1 = linkedListToInt(lA1);
		int l2 = linkedListToInt(lB1);
		int l3 = linkedListToInt(list3);

		System.out.print(l1 + " + " + l2 + " = " + l3 + "\n");
		System.out.print(l1 + " + " + l2 + " = " + (l1 + l2));
	}
}
