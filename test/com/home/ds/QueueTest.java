package com.home.ds;

import static org.junit.Assert.*;

import org.junit.Test;

import com.home.ds.adt.Iqueue;
import com.home.ds.utils.TestUtils;

public class QueueTest {

	@Test
	public void testAll() {
		Iqueue<Integer> q = new Queue<>();
		assertTrue("is empty queue", q.isEmpty());
		assertEquals("Check zero size", 0, q.size());
		q.enq(191);
		for (int i = 0; i < 10; i++) {
			int x = TestUtils.getRandomInteger(50, 500);
			System.out.println("Adding " + x);
			q.enq(x);
		}
		System.out.println(q.toString());
		assertFalse("is non empty queue ", q.isEmpty());
		assertEquals("Check non zero size", 11, q.size());
		assertEquals("Check last removed element", 191, q.deq().intValue());
		q.deq();
		q.deq();
		q.deq();
		q.deq();
		assertFalse("is non empty queue ", q.isEmpty());
		assertEquals("Check non zero size", 6, q.size());
		System.out.println(q.toString());
		q.enq(99);
		q.enq(299);
		int size = q.size();
		for (int i = 0; i < size; i++) {
			q.deq();
		}
		assertTrue("is empty queue ", q.isEmpty());
		assertEquals("Check zero size", 0, q.size());
		System.out.println(q.toString());
	}

}
