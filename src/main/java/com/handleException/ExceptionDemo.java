package com.handleException;

import java.util.Scanner;

public class ExceptionDemo {
	
	public static void main(String[] args) {
		handleExceptions();
	}

	public static void handleExceptions() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number");
		int div = 0;
		
		try {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			div = num1 / num2;
			//throw new UserNotFoundException("str");
			throw new UserNotFoundException("str");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		finally{
			System.out.println("Finally block will execute wheither excetion occured or not");
		}

	}

}
