package com.algorithm.structure.mathnumber;

public class BinomialCoefficients {

//	Recursion:
	public int binom(int a, int b) {
		if (b == 0 || b == a)
			return 1;
		else
			return binom(a - 1, b - 1) + binom(a - 1, b);
	}

//	Dynamic Programming:

	public int binomDP(int a, int b) {
		int binom[][];
		binom = new int[a + 1][a + 1];
		for (int i = 0; i <= a; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i)
					binom[i][j] = 1;
				else
					binom[i][j] = binom[i - 1][j - 1] + binom[i - 1][j];
			}
		}
		return binom[a][b];
	}

}
