package com.home.ds;

import static org.junit.Assert.*;

import org.junit.Test;

import com.home.ds.linear.DoublyLinkedList;
import com.home.ds.utils.TestUtils;

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
		l.removeLast();
		l.removeLast();
		l.removeLast();
		System.out.println(l.toString());
		l.add(31, 1);
		System.out.println(l.toString());
		l.add(100, 2);
		System.out.println(l.toString());
		l.remove(new Integer(10));
		System.out.println(l.toString());
		l.addFirst(161);
		l.addLast(451);
		l.addFirst(611);
		l.addLast(425);
		l.add(TestUtils.getRandomInteger(10, 400), 4);
		System.out.println(l.toString());
		l.remove(1);
		System.out.println(l.toString());
		l.remove(6);
		System.out.println(l.toString());
		System.out.println(l.get(1));
		System.out.println(l.get(5));
	}
}
