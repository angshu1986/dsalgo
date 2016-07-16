package com.home.ds;

import static org.junit.Assert.*;

import org.junit.Test;

public class DoublyLinkedListTest {

	@Test
	public void test() {
		DoublyLinkedList<Integer> l = new DoublyLinkedList<>();
		assertTrue("Check empty list", l.isEmpty());
		assertEquals("Check zero size list", 0, l.size());
		l.addFirst(10);
		l.addFirst(54);
		l.addLast(89);
		l.addFirst(61);
		l.addLast(45);
		l.addLast(86);
		l.addLast(23);
		System.out.println(l.toString());
		l.removeFirst();
		l.removeLast();
		/*l.removeLast();
		l.removeLast();
		l.removeLast();
		*/System.out.println(l.toString());
		l.add(31, 1);
		l.add(100, 4);
		System.out.println(l.toString());
	}

}
