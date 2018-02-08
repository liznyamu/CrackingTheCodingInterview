package Q2_06_Palindrome;

import java.util.Stack;

import CtCLibrary_erza.LinkedListNode;

/**
 * 2.6 Palindrome
 * 
 * Implement a function to check if a linked list is a palindrome
 * 
 * @author erza
 *
 */
public class QuestionB_erza {

	/**
	 * - Using Stack (LIFO) - http://bit.ly/2nPF2WI
	 * 
	 * - Instead of creating a new Linked-List-Node(s) - use a stack and 2 pointers
	 * ( slow - moves 1 node, fast - moves 2 nodes) *
	 * 
	 * CASE Alpha : ODD 'm-a-D-a-m' - separate Palindrome at middle ie ma-D-am -null
	 * 
	 * - 'slow' - moves as 'm-a-D'
	 * 
	 * - 'fast' - moves as 'm-D-m'
	 * 
	 * - compare 'a-m' to stack values (m-a)(pop - LIFO)
	 * 
	 * 
	 * CASE Beta : EVEN 'r-e-D-D-e-r' - separate Palindrome at middle ie reD-Der -
	 * null - use stack to push 'r-e-D'
	 * 
	 * - 'slow' - moves as 'r-e-D'
	 * 
	 * - 'fast' - moves as 'r-D-e-null'
	 * 
	 * - compare 'D-e-r' to stack values (r-e-D)(pop - LIFO)
	 * 
	 */

	public static Boolean isPalindrome(LinkedListNode head) {
		// Pointers - oneStep ie slow, twoSteps ie fast

		LinkedListNode slow = head;
		LinkedListNode fast = head;

		Stack stack = new Stack(); // LIFO

		while (fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}

		// Case Alpha - ODD length on palindrome - ignore middle value
		if (fast != null) {
			slow = slow.next;
		}

		// Section that checks values on stock and on pointers
		// while (!stack.isEmpty()) {
		// System.out.print(stack.pop() + " - ");
		// }
		// System.out.println();
		//
		// System.out.println("Slow is at: " + slow.printForward());
		// System.out.println("Fast is at: " + (fast != null ? fast.printForward() :
		// "null"));

		while (slow != null) {
			if (slow.data != (int) stack.pop()) {
				return false;
			}
			slow = slow.next;
		}

		return true;

	}

	/**
	 * Create a LinkedListNode with :
	 * 
	 * CASE Alpha - ODD length palindrome : compare stack (first half in reverse -
	 * before middle node) with nodes after middle-node (ie second half)
	 * 
	 * CASE Beta - EVEN length palindrome : compare stack (first half) with nodes on
	 * second half
	 * 
	 * CASE Gammma - Linked-List-Node(s) are not a Palindrome
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// CASE Alpha - Palindrome w/ ODD length 1-2-3-2-1
		int[] isp_ODD = new int[] { 1, 2, 3, 2, 1 }; // TODO change this to -- array of LinkedListNodes

		// CASE Beta - Palindrome w/ EVEN length 1-2-3-3-2-1
		int[] isp_EVEN = new int[] { 1, 2, 3, 3, 2, 1 }; // TODO change this to -- array of LinkedListNodes

		// CASE Gamma - Not a Palindrome w/ ODD length
		int[] np_ODD = new int[] { 1, 3, 4, 2, 1 };

		// CASE Gamma - Not a Palindrome w/ EVEN length
		int[] np_EVEN = new int[] { 1, 2, 3, 4, 2, 1 };

		// chose option to process
		// int[] values = isp_EVEN;
		// int[] values = isp_ODD;
		// int[] values = np_ODD;
		int[] values = np_EVEN;

		LinkedListNode head = new LinkedListNode(values[0], null, null);
		for (int i = 1; i < values.length; i++) {
			LinkedListNode node = new LinkedListNode(values[i], null, null);
			node.next = head;
			head = node;
		}

		System.out.println(head.printForward());
		System.out.println(isPalindrome(head));

	}

}
