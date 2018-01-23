/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2_1_remove_dups;

import CtCILibrary.LinkedListNode;

/**
 * Question 2.1 
 * Write code to remove duplicates from an unsorted linked list.
 * 
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 *
 * @author gayle
 */
public class QuestionC {

    public static void deleteDups(LinkedListNode head) {
        if (head == null) {
            return;
        }
        LinkedListNode previous = head;
        LinkedListNode current = previous.next;
        while (current != null) {
            // Look backwards for dups, and remove any that you see.
            LinkedListNode runner = head;
            while (runner != current) {
                if (runner.data == current.data) {
                    LinkedListNode tmp = current.next;
                    previous.next = tmp;
                    current = tmp;
                    /* We know we can't have more than one dup preceding
                     * our element since it would have been removed 
                     * earlier. */
                    break;
                }
                runner = runner.next;
            }

            /* If runner == current, then we didn't find any duplicate 
             * elements in the previous for loop.  We then need to 
             * increment current.  
             * If runner != current, then we must have hit the �break� 
             * condition, in which case we found a dup and current has
             * already been incremented.*/
            if (runner == current) {
                previous = current;
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
        LinkedListNode head = first;
        LinkedListNode second = first;
        for (int i = 1; i < 8; i++) {
            second = new LinkedListNode(i % 2, null, null);
            first.setNext(second);
            second.setPrevious(first);
            first = second;
        }
        System.out.println(head.printForward());
        deleteDups(head);
    }
}
