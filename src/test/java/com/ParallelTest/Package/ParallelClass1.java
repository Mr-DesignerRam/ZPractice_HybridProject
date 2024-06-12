package com.ParallelTest.Package;

import org.testng.annotations.Test;

public class ParallelClass1 {
	

	int count;
	public ParallelClass1(int count ) {
		this.count=count;
	}	
	@Test
	public void test1() {
		System.out.println("Count of test1 : "+count);
	}

	@Test
	public void test2() {
		System.out.println("Count of test2 : "+count);
	}
	@Test
	public void test3() {
		System.out.println("Count of test3 : "+count);
	}
	@Test
	public void test4() {
		System.out.println("Count of test4 : "+count);
	}
}
