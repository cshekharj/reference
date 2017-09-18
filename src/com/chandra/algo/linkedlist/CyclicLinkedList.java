package com.chandra.algo.linkedlist;

public class CyclicLinkedList {
	
	private static Node head;
	 public void addNode(int data){
		 
			Node newNode = new Node(data);
			if( head == null)
				head = newNode;
			else{
				newNode.next=head;
				head=newNode;
			}
		}
	
	public boolean hasCycle(Node head){
		Node fast = head,slow=head;
		while(fast != null && fast.next != null){
			fast=fast.next.next.next;
			slow=slow.next;
			if(fast==slow)
				return true;
		}
		return false;
	}
	public static void main(String[] args) {
		CyclicLinkedList cList = new CyclicLinkedList();
		cList.addNode(11);
		cList.addNode(10);
		cList.addNode(12);
		cList.addNode(11);
		cList.addNode(20);
		cList.addNode(15);
		System.out.println("Cyclic List -"+cList.hasCycle(head));
	}

}
