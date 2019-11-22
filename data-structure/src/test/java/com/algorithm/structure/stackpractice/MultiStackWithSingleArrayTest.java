package com.algorithm.structure.stackpractice;

import static org.junit.Assert.*;

import org.junit.Test;

public class MultiStackWithSingleArrayTest {

	@Test
	public void test() {
//		fail("Not yet implemented");
//		 Let us create 3 stacks in an array of size 10 
		int k = 3, n = 10; 
		
		MultiStackWithSingleArray ks = new MultiStackWithSingleArray(k, n); 

		ks.push(15, 2); 
		ks.push(45, 2); 
		ks.pop(2);
		ks.pop(2);

		// Let us put some items in stack number 1 
		ks.push(17, 1); 
		ks.push(49, 1); 
		ks.push(39, 1); 

		// Let us put some items in stack number 0 
		ks.push(11, 0); 
		ks.push(9, 0); 
		ks.push(7, 0); 

		System.out.println("Popped element from stack 2 is " + ks.pop(2)); 
		System.out.println("Popped element from stack 1 is " + ks.pop(1)); 
		System.out.println("Popped element from stack 0 is " + ks.pop(0)); 
	}

}
