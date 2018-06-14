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


public class LinkedListDemo{
	private Node head;
	int count;
	
	public LinkedListDemo(){
		head=null;
	}
	public LinkedListDemo(Node head, int count){
		this.head=head;
		this.count=count;
	}
	
	 public boolean isEmpty() {
	   return head == null;
    }
	 
	 public Node getHead(){
		 return head;
	 }
	 
	 public void insertNode(int data){
		 
		Node newNode = new Node(data);
		if(isEmpty())
			head = newNode;
		else{
			newNode.next=head;
			head=newNode;
		}
	}
	 
	 public void insertNodeAfter(int data){
		 
			Node newNode = new Node(data);
			if(isEmpty()){
				head = newNode;
			}
			else{
				Node temp=head;
				for(int i=0;temp.next != null;i++){
					System.out.print("i -"+i);
					System.out.println(" temp.data "+temp.data);
					temp=temp.next;
				}
				temp.next=newNode;
			}
		}
	 
	 public void printList(){
		Node node=head;
		System.out.print("LinkedList -> ");
		for(;node != null;node=node.next)
			if(node.next != null)
				System.out.print(node.data+":");
			else
				System.out.print(node.data);
		 	System.out.println();
	 }
	 
	 public void printCircularList(){
		 Node node=head;
		 System.out.print("LinkedList -> ");
		 for(int i=count;i > 0;i--){
			System.out.print(node.data+":");
			node=node.next;	
		 }
		 System.out.println();
	 }
	 public LinkedListDemo getCircularList(){
		 Node first,last,temp = null;
		 first=head;
		 last=head;
		 head=head.next;
		 // for last iteration no swapping needed
		 if(first.next.next == null)
			 return new LinkedListDemo(first,2); 
		 //set last node
		 for(;last.next != null;last=last.next){
			 temp=last;
		 }
		 
		 
		 first.next=temp.next;
		 last.next=first;
		 temp.next=null;
		 
		 
		 return new LinkedListDemo(first,2); 
	 }
	 
	public void reverseList() {
		if (head == null || head.next == null)
			return;

		Node prev = null;
		Node next = null;
		while (head != null) {
			// swap nodes
			next = head.next;
			head.next = prev;
			prev=head;
			// move the pointer to next node
			head = next;
		}
		head = prev;
	}
	 
	 public void reverseListwithRecursion(){
		 
		 if(head==null || head.next == null)
		        return;
		 Node prev = head;;
		 Node next = head.next;;
		 head.next= null;
		 head=next;
		 reverseListwithRecursion();
		 next.next=prev;
		 
			
	 }
	 
	 public static void main(String[] args) {
		    LinkedListDemo dlist = new LinkedListDemo();
		    
		    for(int i=0;i<10;i++)
		    	dlist.insertNodeAfter(i+1);
		    
		    //dlist.printList();
		    ListUtil.printList(dlist.getHead());
		    
		    dlist.reverseList();
		    //dlist.reverseListwithRecursion();
		    
		    
		    //dlist.printList();
		    ListUtil.printList(dlist.getHead());
		    //List<DemoLinkedList> circularLists ;
		   /* while(dlist.getHead().next != null){
		    	LinkedListDemo circularList = dlist.getCircularList();
		    	circularList.printCircularList();
		    }*/
	    }
}


