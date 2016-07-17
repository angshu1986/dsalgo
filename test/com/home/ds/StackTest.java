package com.home.ds;

import static org.junit.Assert.*;

import org.junit.Test;

import com.home.ds.linear.Stack;
import com.home.ds.utils.TestUtils;

public class StackTest {

	@Test
	public void testPush() {
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < 10; i++) {
			int x = TestUtils.getRandomInteger(10, 90);
			System.out.println("Adding " + x);
			s.push(x);
		}
		assertEquals("Check whether elements are added", 10, s.size());
		System.out.println(s.toString());
	}

	@Test
	public void testPop() {
		Stack<Integer> s = new Stack<>();
		s.push(15);
		s.push(45);
		int popped1 = s.pop();
		assertEquals("Check last popped element", 45, popped1);
	}

	@Test(expected = RuntimeException.class)
	public void testPopException() {
		Stack<Integer> s = new Stack<>();
		s.pop();
	}

	@Test
	public void testTop() {
		Stack<Integer> s = new Stack<>();
		s.push(52);
		s.push(10);
		s.push(22);
		int top = s.top();
		assertEquals("Check last inserted element", 22, top);
	}

	@Test
	public void testSize() {
		Stack<Integer> s = new Stack<>();
		assertEquals("Check zero size", 0, s.size());
		s.push(12);
		s.push(23);
		assertEquals("Check non zero size", 2, s.size());
	}

	@Test
	public void testIsEmpty() {
		Stack<Integer> s = new Stack<>();
		assertTrue("Empty stack", s.isEmpty());
		s.push(12);
		assertFalse("Non Empty stack", s.isEmpty());
		s.top();
		assertFalse("Non Empty stack", s.isEmpty());
		s.pop();
		assertTrue("Empty stack", s.isEmpty());
	}
}
