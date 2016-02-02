package org.sintef.jarduino.myProjects;

public class Conversion {
	
	
	/*
	 * Global variables
	 */
	private int decNum;
	private int binNum[];
	
	/* Constructor for the class */
	public Conversion(){}
	
	//Getters and setters
	public int getDecNum(){ 
		return decNum;
	}
	
	public int[] getBinNum(){ 
		int N = decNum;
		int c = 0;
		
		binNum = new int[8];
		
		// converts the decimal to an array representing the binary.
		while(N >= 1){
			if( N == 1){ binNum[c] = 1; } else{ binNum[c] = N%2; c++; }
			N = N/2;
		}
		
		//This if statement checks if the array is full, if not, it will fill the slots with zeroes.
		if(c < 8){ while(c < 7){ c++; binNum[c] = 0; } }
	
		//print the number in binary, not going to be used in this function
		//while(c >= 0){ System.out.print(binNum[c]); c--; }
		
		return binNum;
	}
	
	public void setDecNum(int N){
		if (N < 0 && N > 255) throw new IllegalArgumentException();
		this.decNum = N;
	}
	
	/* Receives a integer number in decimal, maximum of 255 and minimum of 0 and convert it to binary numbers
	 * @param N is the decimal number the function receives
	 * @return return an array of binary numbers representing the value received.
	 */
}
