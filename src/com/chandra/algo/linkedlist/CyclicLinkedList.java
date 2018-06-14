package com.chandra.algo.linkedlist;

public class CyclicLinkedList {

	private static Node head;

	public void addNode(int data) {

		Node newNode = new Node(data);
		if (head == null)
			head = newNode;
		else {
			newNode.next = head;
			head = newNode;
		}
	}

	public boolean hasCycle(Node head) {
		Node fast = head, slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow)
				return true;
		}
		return false;
	}

	public void addToTheLast(Node node) {

		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;

			temp.next = node;
		}
	}

	public static void main(String[] args) {
		CyclicLinkedList cList = new CyclicLinkedList();
		Node cycleNode = new Node(1);
		cList.addToTheLast(new Node(11));
		cList.addToTheLast(new Node(10));
		cList.addToTheLast(cycleNode);
		cList.addToTheLast(new Node(12));
		cList.addToTheLast(new Node(11));
		cList.addToTheLast(new Node(20));
		cList.addToTheLast(new Node(15));
		cList.addToTheLast(cycleNode);
		ListUtil.printList(head);
		
		System.out.println("Cyclic List -" + cList.hasCycle(head));
	}

}
