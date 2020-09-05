package com.exam.numbers;

public class RandomFourDigitNumber {

	public static void main(String[] args) {
		int randomPIN = (int)(Math.random()*9000)+1000;
		System.out.println("4 Digit Random number: "+ randomPIN);
	}

}
