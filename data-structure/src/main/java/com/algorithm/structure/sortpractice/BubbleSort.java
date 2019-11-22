package com.algorithm.structure.sortpractice;

public class BubbleSort {
	
	public void bubbleSort(int[] dataSet) {
		int length = dataSet.length;
		for (int i=length-1; i>=0; i-- ) {
			for(int j = 0; j<=i-1; j++) {
				int temp;
				if(dataSet[j]>dataSet[j+1]) {
					temp = dataSet[j];
					dataSet[j] = dataSet[j+1];
					dataSet[j+1] = temp;
				}
			}
		}
		
		for (int l = 0; l<length;l++) {
			System.out.println(dataSet[l]);
		}
	}

}
