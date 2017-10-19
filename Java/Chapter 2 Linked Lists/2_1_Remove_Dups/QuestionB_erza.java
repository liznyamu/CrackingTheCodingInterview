/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2_1_remove_dups;

/**
 *
 * @author erza
 */
public class QuestionB_erza {

    private static void removeDuplicates(LinkedListNode head) {
        //Remove duplicates 
        LinkedListNode current = head;
        
        LinkedListNode runner = null;

        //Compare with every node on Linked List
        while (current != null) {

            //Run through Linked List - in a loop
            runner = current;

            while (runner.next != null) {
                if (runner.next.data == current.data) {
                //do not move runner 
                    //move runner.next to runner.next.next
                    runner.next = runner.next.next;
                } else {
                    //move runner
                    runner = runner.next;
                }
            }
        }
        
        //set head to runner without duplicates
        head = runner;

    }

    public static void main(String[] args) {
        //Create LinkedList
        LinkedListNode head = new LinkedListNode(0, null, null);
        LinkedListNode current = head;
        LinkedListNode next = null;

        //Create LinkedList with 8 nodes and duplicate values of 0's and 1's
        for (int i = 0; i <= 8; i++) {
            next = new LinkedListNode(i % 2, null, null);
            current.setNextNode(next);
            next.setPreviousNode(current);

            // set new current node as next node
            current = next;
        }

        //Print created Linked List
        System.out.println(head.printForward());

        //Remove duplicates
        removeDuplicates(head);
        
        //Print list without Duplicates
        System.out.println(head.printForward());

    }

}
