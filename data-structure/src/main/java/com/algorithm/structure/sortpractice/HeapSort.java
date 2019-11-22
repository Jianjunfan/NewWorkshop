package com.algorithm.structure.sortpractice;

import com.algorithm.structure.treepractice.BinaryHeap;

/**
 * HeapSort's Big-o, time complexity o(nlogn), because Time complexity of convertToMaxHeapTreeFromArray() is O(Logn),
 * create-and-build whole heap (all node) need O(n)
 * and overall time complexity of Heap Sort is O(nLogn).
 * 
 */
public class HeapSort {
	//public int[] array = {4,6,7,8,12,9};
	
	public void heapSortImplement(int[] array) {
		System.out.println("Before heap sort, the array value: ");
		printAllArray(array);
		
		
		//1. invoke binarty heap to let array as heap-max
		BinaryHeap binaryHeap = new BinaryHeap();
		binaryHeap.constructMaxBinatyHeap(array);
		
		//2. Because now, array is binary heap, so array[0] is max value, swap the array[0] to the end of array[n-1], 
		// now continue to heapily array, make sure array node [0] as Max value
		for(int i= array.length-1;i>=0;i--) {
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			binaryHeap.convertToMaxHeapTreeFromArray(array, i, 0);
		}
		
		System.out.println("After heap sort, the array value: ");
		printAllArray(array);
	}
	
	public void printAllArray(int[] array) {
		for(int i = 0;i<array.length;i++) {
			System.out.println(array[i]);
		}
	}

}
