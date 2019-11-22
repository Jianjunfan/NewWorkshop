package com.algorithm.structure.javapoint;

import static org.junit.Assert.*;

import org.junit.Test;

public class OverloadingFeatureTest {

	@Test
	public void combinationTest() {
		
		OverloadingFeature overloadingFeature = new OverloadingFeature();
		int sum = overloadingFeature.combination(2,4);
		System.out.println("combination return int value: " + sum);
		
		String str = overloadingFeature.combination("hello", " world");
		System.out.println("combination return String value: " + str);
	}

}
