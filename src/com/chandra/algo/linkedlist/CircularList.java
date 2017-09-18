package com.chandra.algo.linkedlist;
/*
 * Problem : Given a linked list of n elements produce a collection of circular linked lists
 * such that - 
 * 1. firstNode.next = nthNode and nthNode.next = first node
 * 2. 2ndNode.next = (n-1)thNode and (n-1)thNode = 2ndNode
 * and so on...
 * 
 * Assumptions
 * 
 * 1 - n is very large
 * 2 - n%2=0 i.e. n is even
 * 
 * Restrictions
 * 
 * 1 - No recursion 
 * 2 - No extra memory
 * 
 */
		
public class CircularList {

	public static void main(String[] args) {
	    LinkedListDemo dlist = new LinkedListDemo();
	    
	    for(int i=1;i<11;i++)
	    	dlist.insertNode(i);
	    
	    dlist.printList();
	    //List<DemoLinkedList> circularLists ;
	    while(dlist.getHead().next != null){
	    	LinkedListDemo circularList = dlist.getCircularList();
	    	circularList.printCircularList();
	    }
    }
	
}

