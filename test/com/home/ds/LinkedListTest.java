package com.home.ds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LinkedListTest {

	@Test
	public void test() {
		LinkedList<Integer> l = new LinkedList<>();
		assertTrue("Check empty list", l.isEmpty());
		assertEquals("Check zero size list", 0, l.size());
		l.add(45);
		l.add(415);
		l.add(145);
		l.add(453);
		l.add(405);
		l.add(745);
		l.add(450);
		l.add(245);
		l.add(452);
		l.add(495);
		System.out.println(l.toString());
		assertFalse("Check non empty list", l.isEmpty());
		assertEquals("Check non zero size list", 10, l.size());
		int removed = l.remove(405);
		System.out.println(l.toString());
		assertFalse("Check non empty list", l.isEmpty());
		assertEquals("Check non zero size list", 9, l.size());
		assertEquals("Check removed element", 405, removed);
	}

}
