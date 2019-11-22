package com.algorithm.structure.linkedlist;

public class LinkedList {

	static Node head; // head of list

	/* Node Class */
	public static class Node {

		int data;
		Node next;

		// Constructor to create a new node
		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void printlist(Node node) {
		if (node == null) {
			return;
		}
		while (node != null) {
			System.out.print(node.data + " -> ");
			node = node.next;
		}
	}
	
	public Node partition(Node node, int value) {
		Node head = node;
		Node tail = node;
		while(node!=null)
		{
			Node next = node.next;
			if(node.data<value) {
				node.next=head;
				head=node;
			}
			else {
				tail.next=node;
				tail=node;
			}
			node = next;
		}
		tail.next=null;
		return head;
	}
	
	public void invokeFunction() {
		Node node1 = new Node(2);
		Node node2 = new Node(3);
		Node node3 = new Node(5);
		Node node4 = new Node(6);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		Node finalNode = partition(node1,5);
		
	}

}
