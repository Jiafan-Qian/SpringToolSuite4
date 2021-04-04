package com.classboxes.junitexample.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.classboxes.junitexample.Sum;

public class SumTest {

	private Sum s;
	
	@Before
	public void createObject()
	{
		s = new Sum();
	}
	
	@Test
	public void testCalculateSum() {
		assertEquals(30, s.calculateSum(10, 10, 10));
	}
	
	@Test
	public void testCalSum()
	{
		assertNotEquals(40, s.calculateSum(10, 10, 10));
	}

	@After
	public void removeObject()
	{
		s = null;
	}
}
