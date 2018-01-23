/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2_1_remove_dups;

/**
 * Question 2.1 
 * Write code to remove duplicates from an unsorted linked list.
 * 
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 * 
 * 
 * Break :
 * - leaves or exit a loop 
 * ie completely exit the loop
 * 
 * Continue :
 * - jumps to next iteration 
 * ie skips statements after 'continue' statement and keeps looping
 * 
 * Return : 
 * - return is used to go back to the step where it was called 
 * or to stop further execution
 * 
 * @author erza
 */


public class QuestionC_erza {
    
    public static void main(String[] args) {
        //Create a Linked List
        LinkedListNode first = new LinkedListNode(0, null, null);
        LinkedListNode head = first;
        LinkedListNode second ;
        
        for(int i = 0; i < 8; i++){
            second = new LinkedListNode(i % 2, null, null);
            first.setNextNode(second);
            second.setPreviousNode(first);
            first = second;
        }
        
        System.out.println(head.printForward());
    }
    
}
