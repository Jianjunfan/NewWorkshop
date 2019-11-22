package com.algorithm.structure.javapoint;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongAndlongDifferenceTest {

	@Test
	public void objectLongtest() {
		LongAndlongDifference longAndlongDifference = new LongAndlongDifference();
		Long value = 121L;
		System.out.println("before function, value is: " + value);
		longAndlongDifference.verifyLong(value);
		System.out.println("After function, value is: " + value);
	}
	
	@Test
	public void primitiveLongtest() {
		LongAndlongDifference longAndlongDifference = new LongAndlongDifference();
		long value = 121L;
		longAndlongDifference.verifyLong(value);
	}

}
