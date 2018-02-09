package Q2_06_Palindrome;

import CtCLibrary_erza.LinkedListNode;

public class QuestionC_erza {

	public static class Results {
		public LinkedListNode node;
		public boolean result;

		public Results(LinkedListNode resultNode, boolean resStatus) {
			node = resultNode;
			result = resStatus;
		}

	}

	public static Results palinRecursive(LinkedListNode current, int length) {

		// stop when
		if (length == 0 || current == null) { // case odd palindrome
			return new Results(current, true);
		} else if (length == 1) { // case even palindrome
			return new Results(current.next, true);
		}

		// go to the middle
		Results pResult = palinRecursive(current.next, length - 2);

		if (pResult.node == null || !pResult.result) {
			return pResult;
		}

		pResult.result = (pResult.node.data == current.data);

		pResult.node = pResult.node.next;

		// TODO modify this - after comparison
		return pResult;

	}

	/**
	 * Recursively calculate length of Linked-List-Node
	 * 
	 * @param node
	 * @return
	 */
	public static int listLength(LinkedListNode node) {
		if (node == null) {
			return 0;
		}
		return 1 + listLength(node.next);
	}

	/**
	 * Go to the middle of the Palindrome and then compare remaining node data with
	 * previous nodes - recursively (will need to get the length of the
	 * linked-list-node)
	 * 
	 * @param node
	 */
	public static boolean isPalindrome(LinkedListNode node) {
		int length = listLength(node);
		Results pResult = palinRecursive(node, length);
		return pResult.result;

	}

	public static void main(String[] args) {
		// create a palindrome with length n

		int listLength = 11;
		LinkedListNode[] nodes = new LinkedListNode[listLength];

		for (int i = 0; i < listLength; i++) {
			nodes[i] = new LinkedListNode(i < listLength / 2 ? i : listLength - i - 1, null, null);
		}

		for (int i = 0; i < listLength; i++) {
			// set next node
			if (i < listLength - 1) {
				nodes[i].setNext(nodes[i + 1]);
			}

			// set previous node
			if (i > 0) {
				nodes[i].setPrev(nodes[i - 1]);
			}
		}

		// nodes[listLength - 2].data = 10; // ruin palindrome

		// print current list of Linked-nodes
		LinkedListNode head = nodes[0];
		System.out.println(head.printForward());
		// check if list of Linked-nodes is a Palindrome
		System.out.println(isPalindrome(head));

	}
}
