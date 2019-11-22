package com.algorithm.structure.steven;

public class Steven2 implements BaseInterface{

	@Override
	public String toString() {
		return "Steven2 [name=" + name + ", city=" + city + ", value=" + value + "]";
	}

	String name;
	String city;
	int value;
	public static int count = 0;
	
	public Steven2(String name, String city,int value) {
		this.name = name;
		this.city = city;
		this.value = value;
		this.count = 89;
	}
	public static void s2Print() {
		count = 89;
		System.out.println( "count is " + count);
	}
}
