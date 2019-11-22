package com.algorithm.structure.steven;

public class Steven1 implements BaseInterface{
	@Override
	public String toString() {
		return "Steven1 [name=" + name + ", city=" + city + ", value=" + value + "]";
	}

	public String name;
	public String city;
	public int value;
	
	public Steven1(String name, String city,int value) {
		this.name = name;
		this.city = city;
		this.value = value;
	}
	
	public Steven1() {
		// TODO Auto-generated constructor stub
	}

	public void test() {
		if(test2()||test1()) {
			System.out.println("in || test");
		}
		
		if(test1()&&test2()) {
			System.out.println("in && test");
		}
	}
	
	boolean test1() {
		System.out.println("in test1");
		return true;
	}
	
	boolean test2() {
		System.out.println("in test2");
		return false;
	}

}
