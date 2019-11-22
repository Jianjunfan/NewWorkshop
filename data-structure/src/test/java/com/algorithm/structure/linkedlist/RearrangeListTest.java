package com.algorithm.structure.linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;

import com.algorithm.structure.linkedlist.LinkedList.Node;

public class RearrangeListTest {

	@Test
	public void reArrageListTest() {
        RearrangeList rearrangeList = new RearrangeList();
        LinkedList list = new LinkedList();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
//        list.head.next.next.next.next = new Node(5);
 
        list.printlist(list.head); // print original list
        rearrangeList.rearrange(list.head); // rearrange list as per ques
        System.out.println("");
        list.printlist(list.head); // print modified list
	}

}
