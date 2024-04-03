package com.TestClass.Package;



import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Listener.DummyListener;


@Listeners(DummyListener.class)
public class DummyListernerTest {
	
	@Test
	public void Test1() {
		System.out.println("Test1 Method Executed");

	}
	@Test
	public void Test2() {
		System.out.println("Test2 Method Executed");
	}

	@Test
	public void Test3() {
		System.out.println("Test3 Method Executed");
	}
	@Test
	public void Test4() {
		System.out.println("Test4 Method Executed");
		Assert.fail();
	}

}
