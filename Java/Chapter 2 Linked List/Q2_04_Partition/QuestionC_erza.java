package Q2_04_Partition;

import CtCLibrary_erza.LinkedListNode;

/**
 * Partition the LinkedList using 2 LinkedList -- based on whether data is (> or
 * =) to partValue Using 2 pointers one for the start of the left / start
 * partition and one for the start of the right / After partition
 * 
 * @param current
 * @param partValue
 * 
 * @author erza
 */
public class QuestionC_erza {
	
	
	/**
	 * Proposed solution -- use 2 pointers (Head, Tail)-- which initially refer to the first node on the list (ie only one list is maintained)
	 * 
	 * Head moves forward while Tail moves Back
	 * 
	 * Return Head
	 * 
	 * @param node
	 * @param partValue
	 * @return
	 */
	public static LinkedListNode partition(LinkedListNode node, int partValue) {
		
		LinkedListNode head = node;
		LinkedListNode tail = node;
		
		while(node != null) {
			LinkedListNode next = node.next;
			
			if(node.data < partValue) {
				node.next = head;
				head = node;
			}else {
				tail.next = node;
				tail = node;
			}
			
			node = next;
			}
		
		// set next on tail -ie to null
		tail.next = null;
		
		//return the linkedList
		return head;
		
	}
	
	
	public static void main(String[] args) {
		/*
		 * Generate a LinkedListNode with 20 nodes 
		 */
		
		int listLength = 20;
		
		LinkedListNode[] nodes = new LinkedListNode[listLength];
		for(int i = 0; i < listLength; i++) {
			nodes[i] = new LinkedListNode(i >= listLength / 2 ? listLength - i - 1 : i, null, null);
		}
		
		for(int i = 0; i < listLength; i++) {
			if( i < listLength - 1) {
				nodes[i].setNext(nodes[i + 1]);
			}
			
			if( i > 0) {
				nodes[i].setPrev(nodes[i - 1]);
			}
		}
		
		LinkedListNode head = nodes[0];
		System.out.println(head.printForward());
		int partValue = 8;
		
		LinkedListNode h = partition(head, partValue);
		System.out.println(h.printForward());
		
		
		
	}

}
