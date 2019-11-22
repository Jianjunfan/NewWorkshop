package com.algorithm.structure.mathnumber;

public class Fibonacci {
//	dynamic programming
	public int calculateFibonacci(int n) {
		int n1 = 1;
		int n2 = 2;
		int n_temp = 0;
		if (n == 1) {
			return n1;
		} else if (n == 2) {
			return n2;
		} else {
			for (int i = 3; i <= n; i++) {
				n_temp = n1 + n2;
				n1 = n2;
				n2 = n_temp;
			}
			return n_temp;
		}
	}

}
