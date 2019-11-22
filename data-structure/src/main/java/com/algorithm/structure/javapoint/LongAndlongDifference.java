package com.algorithm.structure.javapoint;


/*
 * Long vs long, Integer vs int
 * 1. Long and Integer is object, long and int are primitive type
 * 2. You should use long and int, except where you need to make use of methods inherited from Object, such as hashcode. 
 *    Java.util.collections methods usually use the boxed (Object-wrapped) versions, 
 * 3. Another difference is that long and int are pass-by-value, whereas Long and Integer are pass-by-reference value, like all non-primitive Java types. 
 *    So if it were possible to modify a Long or Integer (it's not, they're immutable without using JNI code), there would be another reason to use one over the other.

 * 4. final difference is that a Long or Integer could be null.
 * */

public class LongAndlongDifference {
	
	public void verifyLong(Long value) {
		value = Long.valueOf(98);
		if (value == null) {
			System.out.println("the value is null");
		}
		else {
			System.out.println("the value is not null: " + value);
			System.out.println("the hashcode value is :" + value.hashCode() );
		}
	}
	
	public void verifyPrimitiveLong(long value) {
		value = 98;
	}

}
