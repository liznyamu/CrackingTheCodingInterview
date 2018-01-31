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

		//create an array of LinkedListNode(s)
		int length = 20;
		LinkedListNode[] nodes = new LinkedListNode[length];
		
		//assign data to nodes
		for(int i= 0; i < length; i++) {
			nodes[i] = new LinkedListNode( i >= length / 2 ? length - i - 1 : i , null, null);
		}
		
		for(int i = 0; i < length; i++) {
			if(i < length - 1) {
				nodes[i].setNext(nodes[i + 1]);
			}
			if(i > 0) {
				nodes[i].setPrev(nodes[i - 1]);
			}
		}
		
		LinkedListNode head = nodes[0];
		int partValue = 7;
		System.out.println(head.printForward());

		LinkedListNode partedList = partition(head, partValue);
		
		System.out.println(partedList.printForward());

	}

}
