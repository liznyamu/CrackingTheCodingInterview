package Q2_06_Palindrome;

import CtCLibrary_erza.LinkedListNode;

/**
 * 2.6 Palindrome
 * 
 * Implement a function to check if a linked list is a palindrome
 * 
 * @author erza
 *
 */
public class QuestionA_erza {

	// Create a new Linked-List-Node as a reversal original Linked-List-Node
	// ... then compare if the node from head are similar or isEqual

	/**
	 * Create a new Linked-List-Node as a reversal original Linked-List-Node ...
	 * then compare if the node from head are similar or isEqual
	 * 
	 * @param node
	 */
	public static boolean isPalindrome(LinkedListNode node) {
		// reverse the Linked-List-Node(s)
		LinkedListNode reversed = reverse(node);

		// check if the two linked-list-nodes are equal
		return isEqual(reversed, node);

	}

	public static boolean isEqual(LinkedListNode nodeA, LinkedListNode nodeB) {

		// CASE Alpha : no. of nodeA(s) == no. of nodeB(s)
		while (nodeA != null && nodeB != null) {
			if (nodeA.data != nodeB.data) {
				// System.out.println("Not a Palindrome");
				return false;
			}
			nodeA = nodeA.next;
			nodeB = nodeB.next;
		}

		// Given the last node.next = null
		// CASE Beta : no. of nodeA(s) != no. of nodeB(s)
		// if(nodeA == null && nodeB == null) {
		// System.out.println("Is a Palindrome");
		// return true;
		// }else {
		// System.out.println("Not a Palindrome");
		// return false;
		// }

		// CASE Beta : no. of nodeA(s) != no. of nodeB(s)
		return (nodeA == null && nodeB == null); // replaces above section
	}

	/**
	 * Reverse the Linked-List-Node(s) - by creating a new Linked-List-Node(s) with
	 * 'next' in reverse
	 * 
	 * @param node
	 * @return
	 */
	public static LinkedListNode reverse(LinkedListNode node) {
		// TODO re-do without creating a new node (n) ie re-using node and next =
		// node.next

		LinkedListNode head = null;
		while (node != null) {
			LinkedListNode n = new LinkedListNode(node.data, null, null);
			n.next = head;
			head = n;
			node = node.next;
		}

		return head;

	}

	public static void main(String[] args) {
		int listLength = 9;
		LinkedListNode nodes[] = new LinkedListNode[listLength];

		// Create nodes with palindrome data : 0 1 2 3 4 3 2 1 0
		for (int i = 0; i < listLength; i++) {
			nodes[i] = new LinkedListNode(i < listLength / 2 ? i : listLength - i - 1, null, null);

		}

		// Link the nodes - PS - there are no null nodes
		for (int i = 0; i < listLength; i++) {
			// set next
			if (i < listLength - 1) { // can be changed to (i != (listLength - 1))
				nodes[i].next = nodes[i + 1];
			}

			// set previous
			if (i > 0) { // PS - can changed to (i != 0)
				nodes[i].prev = nodes[i - 1];
			}
		}

		// nodes[5].data = 5; - used to test if LinkedListNode(s) is not a Palindrome

		LinkedListNode head = nodes[0];

		// print original Linked-List-Node(s)
		System.out.println(head.printForward());

		// print - if the Linked-List-Node is a palindrome
		System.out.println("Is Palindrome : " + isPalindrome(head));
	}

}
