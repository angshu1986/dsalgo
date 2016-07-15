package com.home.ds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ArrayListTest {

	@Test
	public void test() {
		ArrayList<Integer> l = new ArrayList<>();
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
		int removed = l.remove(new Integer(405));
		System.out.println(l.toString());
		assertFalse("Check non empty list", l.isEmpty());
		assertEquals("Check non zero size list", 9, l.size());
		assertEquals("Check removed element", 405, removed);
		int removedFirst = l.remove(new Integer(45));
		assertFalse("Check non empty list", l.isEmpty());
		assertEquals("Check non zero size list", 8, l.size());
		assertEquals("Check removed element", 45, removedFirst);
		System.out.println(l.toString());
		int removedLast = l.remove(new Integer(495));
		assertFalse("Check non empty list", l.isEmpty());
		assertEquals("Check non zero size list", 7, l.size());
		assertEquals("Check removed element", 495, removedLast);
		System.out.println(l.toString());
		l.add(420);
		l.add(900);
		l.add(64);
		assertFalse("Check non empty list", l.isEmpty());
		assertEquals("Check non zero size list", 10, l.size());
		System.out.println(l.toString());
		removed = l.remove(0);
		assertFalse("Check non empty list", l.isEmpty());
		assertEquals("Check non zero size list", 9, l.size());
		assertEquals("Check removed element", 415, removed);
		System.out.println(l.toString());
		removed = l.remove(6);
		assertFalse("Check non empty list", l.isEmpty());
		assertEquals("Check non zero size list", 8, l.size());
		assertEquals("Check removed element", 420, removed);
		System.out.println(l.toString());
		assertEquals("Check get value", 745, l.get(2).intValue());
		l.add(12, 4);
		assertFalse("Check non empty list", l.isEmpty());
		assertEquals("Check non zero size list", 9, l.size());
		assertEquals("Check added element", 12, l.get(4).intValue());
		System.out.println(l.toString());
	}

}
