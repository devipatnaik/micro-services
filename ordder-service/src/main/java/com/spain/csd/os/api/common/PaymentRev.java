package com.spain.csd.os.api.common;

import java.util.Scanner;

public class PaymentRev {

	public static void main(String[] args) {
		
		String original;
		String reverse="";
		
		Scanner scan = new Scanner(System.in);
		
		original = scan.nextLine();
		
		int len = original.length();
		for(int i =len-1; i>=0; i--) {
			reverse = reverse + original.charAt(i);
		}
		System.out.println("Reverse : "+reverse);

	}
}
