package com.algorithm.structure.javapoint.transientKeyword;

/**
 * transient keyword, 
 * if a member be add transient key word, this variable will be set to default value when doing serialize.
 * 
 * But,if have static/final keyword together with transient, transient will no useful any more, because:
 * 1. static variable is belong to class, not a instance
 * 2. final variable directly serialized by its value.
 * 
 * */


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TransientDemo implements Serializable {

	private transient final String name = "fan";
	private transient int age;
	private String address;

	public TransientDemo(String name, int age, String address) {
//		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	public void objectPrint() {
		System.out.println("in Demo objectPrint");
	}
	
	public void serializeTest(TransientDemo transientDemo) throws Exception{
//		TransientDemo transientDemo = new TransientDemo("steven",40,"lake");
		
		System.out.println("before Serialize-DeSerialize, name is " + transientDemo.name);
		System.out.println("before Serialize-DeSerialize, age is " + transientDemo.age);
		System.out.println("before Serialize-DeSerialize, address is " + transientDemo.address);
		transientDemo.objectPrint();
		
		FileOutputStream fos = new FileOutputStream("serialize.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(transientDemo);
	}
	
	public void deSerializeTest() throws Exception{
		FileInputStream fis = new FileInputStream("serialize.txt");
		ObjectInputStream oos = new ObjectInputStream(fis);
		TransientDemo obj = (TransientDemo)oos.readObject();
		
		System.out.println("After Serialize-DeSerialize, name is " + obj.name);
		System.out.println("After Serialize-DeSerialize, age is " + obj.age);
		System.out.println("After Serialize-DeSerialize, address is " + obj.address);
		obj.objectPrint();
		
//		obj.deSerializeTest();
		
	}
}
