package Q2_04_Partition;

import CtCLibrary_erza.LinkedListNode;

public class QuestionB_erza {

	/**
	 * Partition the LinkedList using 2 LinkedList -- based on whether data is (> or
	 * =) to partValue Using 2 pointers one for the start of the left / start
	 * partition and one for the start of the right / After partition
	 * 
	 * @param current
	 * @param partValue
	 */
	public static LinkedListNode partition(LinkedListNode current, int partValue) {
		
		LinkedListNode beforeStart = null;
		LinkedListNode afterStart = null;
		
		LinkedListNode next = null;
		
		while(current != null) {
			
			next = current.next;
			
			if(current.data < partValue) {
				current.next = beforeStart;
				beforeStart = current;
			}else {
				current.next = afterStart;
				afterStart = current;				
			}
			
			current = next;
			
		}
		
		/*
		 * After above iteration w'll have below partitions
		 * [1] (beforeStart) -> [2] -> [3] -> [null]
		 * [10] (afterStart) -> [5] -> 8 -> [5] -> [null]
		 */
		
		// if all data is less than partValue then
		if(afterStart == null) {
			return beforeStart;
		}

		// else if theres data equal or greater than partValue then
		// move the pointer beforeStart to last node on the List
		// create a variable with same instance as beforeStart
		LinkedListNode head = beforeStart;
		while(beforeStart.next != null) {
			beforeStart = beforeStart.next;
		}
		
		// merge the 2 partitions
		beforeStart.next = afterStart;
		return head;
		
	}

	public static void main(String[] args) {
		// TODO -- recreate the LinkedList created by gayle

		int[] arrayValues = { 3, 5, 8, 5, 10, 2, 1 };
		int partValue = 5;

		LinkedListNode head = new LinkedListNode(arrayValues[0], null, null);
		LinkedListNode current = head;

		for (int i = 1; i < arrayValues.length; i++) {
			current = new LinkedListNode(arrayValues[i], null, current);
		}

		System.out.println(head.printForward());

		LinkedListNode partedList = partition(head, partValue);
		
		System.out.println(partedList.printForward());

	}

}
