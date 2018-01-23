/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2_1_remove_dups;

import java.util.HashSet;

/**
 *
 * @author erza
 */
public class QuestionA_erza {

    public static void main(String[] args) {
        //create a linked list with n nodes
        LinkedListNode first = new LinkedListNode(0, null, null);
        LinkedListNode head = first;
        LinkedListNode second;

        for (int i = 1; i < 8; i++) {

            //Create second node ie 
            // - first.next = second
            // - second.previous = first
            second = new LinkedListNode(i % 2, null, null);
            first.setNextNode(second);
            second.setPreviousNode(first);

            //set first to second
            first = second;
        }

        //Print Created Linked List
        System.out.println(head.printForward());

        //Remove duplicates
        removeDuplicates(head);
        
        //Print Linked List without duplicates
        System.out.println(head.printForward());

    }

    private static void removeDuplicates(LinkedListNode n) {

        // HashSet
        // Java 8 Oracle Doc : http://bit.ly/2hDjUjj
        // HashSet Vs HashMap : http://bit.ly/2yjiVyf
        HashSet<Integer> set = new HashSet<Integer>();
        LinkedListNode previous = null;

        while (n != null) {

            if (set.contains(n.data)) {
                //skip n to next node
                previous.next = n.next;
            } else {
                // set value on set  
                set.add(n.data);
                // set previous node to n ie include n on LinkedList
                previous = n;
            }

            n = n.next;
        }

    }

}
