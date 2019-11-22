package com.algorithm.structure.treepractice;

/**
 * Binary Heap is special complete binary tree,where items are stored in a special order 
 * such that value in a parent node is greater(or smaller) than the values in its two children nodes. 
 * The former is called as max heap and the latter is called min heap. 
 * The heap can be represented by binary tree or array.
 */
public class BinaryHeap {
	
	// To heapify a subtree rooted with node i which is an index in arr[]. n is size of heap
	//Big-o, time complexity o(nlogn)
	public void convertToMaxHeapTreeFromArray(int[] array,int n, int i ) {
		int large = i;
		int leftChild = i*2 +1;
		int rightChild = i*2 +2;
		if (leftChild<n && array[leftChild] > array[large]) {
			large = leftChild;
		}
		
		if(rightChild<n && array[rightChild]>array[large]) {
			large = rightChild;
		}
		
		if(large!=i) {
			int temp = array[i];
			array[i]=array[large];
			array[large]=temp;
			
			//invoke convertToMaxHeapTreeFromArray to heapify a subtree rooted with node 'large'
			convertToMaxHeapTreeFromArray(array,n,large);
		}
		
	}
	
	public void convertToMinHeapTreeFromArray(int[] array,int n,int i) {
		int small = i;
		int left = i*2 +1;
		int right = i*2 +2;
		if(left<n && array[left]<array[small]) {
			small = left;
		}
		
		if(right<n && array[right]<array[small]) {
			small = right;
		}
		
		if(small != i) {
			int temp = array[i];
			array[i] = array[small];
			array[small] = temp;
			
			//Continue to invoke convertToMinHeapTreeFromArray to heapify a subtree rooted with node "small"
			convertToMinHeapTreeFromArray(array,n,small);
		}
	}
	
	public void constructMaxBinatyHeap(int[] array) {
		//int[] array = {4,6,7,8,12,9};
		for(int i = array.length /2 -1;i>=0;i--) {
			convertToMaxHeapTreeFromArray(array, array.length, i);
		}
		System.out.println("constructMaxBinatyHeap:");
		printAllArray(array);
	}
	
	public void constructMinBinatyHeap(int[] array) {
		//int[] array = {4,6,7,8,12,9};
		for(int i = array.length /2 -1;i>=0;i--) {
			convertToMinHeapTreeFromArray(array, array.length, i);
		}
		System.out.println("constructMinBinatyHeap:");
		printAllArray(array);
	}
	
	public void printAllArray(int[] array) {
		System.out.println("Begin to print Array after heapify to bianry heap");
		for(int i = 0;i<array.length;i++) {
			System.out.println(array[i]);
		}
	}
	

}
