package com.algorithm.structure.mathnumber;

import static org.junit.Assert.*;

import org.junit.Test;

public class FibonacciTest {
	public static final String CACTUS_METADATA_ALGORITHM_DELIMITER = ".";

	@Test
	public void test() {
		Fibonacci fibonacci = new Fibonacci();
		int num = 5;
		int result = fibonacci.calculateFibonacci(num);
		String metaDataStr = "0.1.23-skdjfkdfj";
		int idx = metaDataStr.indexOf(CACTUS_METADATA_ALGORITHM_DELIMITER);
		String verStr = metaDataStr.substring(0, idx);
		int lastIdx = metaDataStr.lastIndexOf(CACTUS_METADATA_ALGORITHM_DELIMITER);
		String algStr = metaDataStr.substring(lastIdx-1, lastIdx);
		
		String serverMetaData = metaDataStr.substring(lastIdx + 1);
		int algorithm = Integer.valueOf(algStr);
		System.out.println("the number " + num + " fibonacci is " + result);

	}

}
