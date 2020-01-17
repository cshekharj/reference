package com.chandra.algo.linkedlist;

public class ListUtil {

	public static  void printList(Node head){
		Node node=head;
		System.out.print("LinkedList -> ");
		for(;node != null;node=node.next)
			if(node.next != null)
				System.out.print(node.data+":");
			else
				System.out.print(node.data);
		 	System.out.println();
	 }
}
