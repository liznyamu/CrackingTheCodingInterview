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
            
            //set next first to first.next
            current = current.next;
        }
        

    }

    public static void main(String[] args) {
        //Create LinkedList
        LinkedListNode head = new LinkedListNode(0, null, null);
        LinkedListNode first = head;
        LinkedListNode second = null;

        //Create LinkedList with 8 nodes and duplicate values of 0's and 1's
        for (int i = 0; i <= 8; i++) {
            second = new LinkedListNode(i % 2, null, null);
            first.setNextNode(second);
            second.setPreviousNode(first);

            // set new first node as next node
            first = second;
        }

        //Print created Linked List
        System.out.println(head.printForward());

        //Remove duplicates
        removeDuplicates(head);
        
        //Print list without Duplicates
        System.out.println(head.printForward());

    }

}
