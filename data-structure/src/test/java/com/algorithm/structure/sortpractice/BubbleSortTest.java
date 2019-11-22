package com.algorithm.structure.sortpractice;

import static org.junit.Assert.*;

import org.junit.Test;

public class BubbleSortTest {

	@Test
	public void bubbleSortTest() {
		BubbleSort bubbleSort = new BubbleSort();
		int[] array = {3,6,7,1,2,9,33,12,45};
		bubbleSort.bubbleSort(array);
	}

}
