package erza;

import CtCLibrary_erza.AssortedMethods;
import CtCLibrary_erza.LinkedListNode;

public class QuestionC_erza {

	public static class Index {
		public int value = 0;
	}

	private static LinkedListNode kthToLast(LinkedListNode head, int k) {
		Index idx = new Index();
		return kthToLast(head, k, idx);
	}

	private static LinkedListNode kthToLast(LinkedListNode head, int k, Index idx) {
		if (head == null) {
			return null;
		}

		LinkedListNode node = kthToLast(head.next, k, idx);
		idx.value = idx.value + 1;

		if (idx.value == k) {
			return head;
		}

		return node;
	}

	public static void main(String[] args) {
		int[] array = { 0, 1, 2, 3, 4, 5, 6 };

		LinkedListNode head = AssortedMethods.createLinkedListFromArray(array);

		for (int i = 0; i <= array.length; i++) {
			LinkedListNode node = kthToLast(head, i);

			String nodeValue = node == null ? "null" : "" + node.data;
			System.out.println(i + ": " + nodeValue);
		}

	}

}
