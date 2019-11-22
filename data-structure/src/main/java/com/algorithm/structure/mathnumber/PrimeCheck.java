package com.algorithm.structure.mathnumber;

public class PrimeCheck {
	
	public boolean isPrimeDigital(int num) {
		
		if(num==2 || num ==3) {
			return true;
		}
		else if( (num == 1)|| (num%2 == 0) ) 
		{
			return false;
		}
		else {
			for (int i = 3; i*i<=num; i+=2) {
				if (num %i == 0) {
					return false;
				}
			}
		}
		return true;		
		
	}
	
	public int nextPrimeDigital(int num) {
		if(num%2 ==0) num++;
		
		for(;!isPrimeDigital(num);num+=2) {}
			
		return num;
		
	}

}
