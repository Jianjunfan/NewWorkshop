package com.algorithm.structure.hashtable;

import com.algorithm.structure.mathnumber.PrimeCheck;

/*
 * This is simple Hash Table implement using Array, the size of hash-table is prime value, if not prime code, the key's hash-code will 
 * be more easy to duplication.
 * in this implement, some key's value will be overwrite, for example, capacity is 7, the key 7 and 14 will be in same slot (7%7 = 14%7)
 * Reference: https://www.sanfoundry.com/java-program-implement-hash-tables/
 * */

public class HashTableByArray {
	public int capacity;
	public int[] tableData;
	
	public HashTableByArray(int capacity) {
		PrimeCheck primeCheck = new PrimeCheck();
		this.capacity = primeCheck.nextPrimeDigital(capacity);
		tableData = new int[this.capacity];
	}
	
	public void setValue(int key,int value) {
		tableData[key%capacity] = value;
	}
	
	public int getValue(int key) {
		return tableData[key%capacity];
	}
	
	public void deleteKey(int key) {
		tableData[key%capacity] = 0;
	}
	
	public int getTableSize() {
		return this.capacity;
	}
	
	public void cleanTable() {
		tableData = new int[this.capacity];
	}

}
