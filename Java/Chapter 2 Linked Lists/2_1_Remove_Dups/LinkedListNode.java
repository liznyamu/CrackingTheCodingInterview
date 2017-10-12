/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2_1_remove_dups;

/**
 * Create Data Structure : Linked List Node
 * @author erza
 */
public class LinkedListNode {
    
     //Each Node has :
     public LinkedListNode next; // For Singly- and Doubly- Linked List and 
     public LinkedListNode previous;  // For Doubly Linked List
     public int data;
     
     //Each Linked List has:
     //public LinkedListNode first;
     //public LinkedListNode last;
     
    /**
     * Default Constructor Method
     */
    public LinkedListNode() {}
    
    /**
     * Set this.data = d, this.setNextNode(n), this.setPreviousNode(p)
     * 'this' is the current instance of particular object
     * @param d
     * @param n
     * @param p 
     */
    public LinkedListNode(int d, LinkedListNode n, LinkedListNode p){
        data = d;
        setNextNode(n);
        setPreviousNode(p);        
    }
    
    /**
     * Set this.next = n
     * 'this' is the current instance of particular object
     * 
     * @param n 
     */
    public void setNextNode(LinkedListNode n){
        next = n;
        
        //ERZA still not added Last node
        
        // set this = n.prev 
        // iff n is not null && n.prev is not set this       
        if(n != null && n.previous != this ){
            n.setPreviousNode(this);            
        }
        
    }
 
    /**
     * Set this.previous = p
     * 'this' is the current instance of particular object
     * 
     * @param p 
     */    
    public void setPreviousNode(LinkedListNode p){
        previous = p;
        
        //ERZA still not added First node
        
        // set p.next = this
        // iff p is not null && p.next is not set to this
        if(p != null && p.next != this ){
            p.setNextNode(this);
        }
    }
    
    /**
     * if this.next != null then print this.data , "->" 
     * and recursively call next.printForward
     * 
     * else if this.next == null then print the data 
     * 
     * @return 
     */
    public String printForward(){
        if(next != null){
            return data + " -> " + next.printForward();
        }else{
            return ((Integer)data).toString();
        }
    }
   
    
    
}
