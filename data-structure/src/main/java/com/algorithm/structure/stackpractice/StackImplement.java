package com.algorithm.structure.stackpractice;
/**
 * 
 * @author stevenfan
 * stack need operation, pop(), push(), peek(), isEmpty(), getSize()
 */
public class StackImplement {
	
	public int stackSize;
	public DataPoint top;
	
	public StackImplement() {
		this.stackSize = 0;
		this.top = null;
	}
	public int pop() throws Exception{
		
		if(top == null ) throw new stackEmptyException();
		DataPoint dataPoint_tmp = top.next;
		this.stackSize--;
		return top.value;
	}
	
	public int peek() throws Exception{
		if(top == null ) throw new stackEmptyException();
		return top.value;
	}
	
	public void push(int data) {
		DataPoint dataPoint = new DataPoint(data);
		DataPoint dataPoint_tmp = top;
		
		this.top = dataPoint;
		top.next = dataPoint_tmp;
		
		this.stackSize++;
	}
	
	public int getSize() {
		return this.stackSize;
	}
	
	public class DataPoint{
		
		public DataPoint(int value) {
			this.value = value;
			this.next = null;
		}
		public int value;
		public DataPoint next;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public class stackEmptyException extends Exception{
		
	}

}
