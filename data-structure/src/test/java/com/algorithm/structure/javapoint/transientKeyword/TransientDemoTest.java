package com.algorithm.structure.javapoint.transientKeyword;

import static org.junit.Assert.*;

import org.junit.Test;

public class TransientDemoTest {

	@Test
	public void test() throws Exception{
		//fail("Not yet implemented");
		TransientDemo transientDemo = new TransientDemo("steven",40,"lake");
		transientDemo.serializeTest(transientDemo);
		transientDemo.deSerializeTest();
	}

}
