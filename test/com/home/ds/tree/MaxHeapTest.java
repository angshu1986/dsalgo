package com.home.ds.tree;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import com.home.ds.adt.Heap;

public class MaxHeapTest {

	private Heap<Integer> heap;

	@Before
	public void setUp() throws Exception {
		heap = new MaxHeap<>();
		heap.insert(10);
		heap.insert(20);
		heap.insert(5);
		heap.insert(30);
		heap.insert(15);
	}

	@Test
	public void testSequence() {
		assertArrayEquals(new Integer[] { 30, 20, 5, 10, 15 }, heap.toArray());
	}

	@Test
	public void testExtract() {
		int top = heap.extract();
		assertEquals(30, top);
		assertArrayEquals(new Integer[] { 20, 15, 5, 10 }, heap.toArray());
	}

	@Test
	public void testInsert() {
		heap.insert(40);
		assertArrayEquals(new Integer[] { 40, 20, 30, 10, 15, 5 }, heap.toArray());
	}

	@Test
	public void testGet() {
		int top = heap.get();
		assertEquals(30, top);
		assertArrayEquals(new Integer[] { 30, 20, 5, 10, 15 }, heap.toArray());
	}

	@Test
	public void testIsEmpty() {
		boolean isEmpty = heap.isEmpty();
		assertFalse(isEmpty);
	}

	@Test
	public void testSize() {
		int size = heap.size();
		assertEquals(5, size);
	}

	@Test
	public void testMultipleInsertExtract() {
		heap.insert(7);
		assertArrayEquals(new Integer[] { 30, 20, 7, 10, 15, 5 }, heap.toArray());
		int top1 = heap.extract();
		assertEquals(30, top1);
		assertArrayEquals(new Integer[] { 20, 15, 7, 10, 5 }, heap.toArray());
		heap.insert(17);
		assertArrayEquals(new Integer[] { 20, 15, 17, 10, 5, 7 }, heap.toArray());
		heap.insert(70);
		assertArrayEquals(new Integer[] { 70, 15, 20, 10, 5, 7, 17 }, heap.toArray());
		heap.insert(27);
		assertArrayEquals(new Integer[] { 70, 27, 20, 15, 5, 7, 17, 10 }, heap.toArray());
		int top2 = heap.extract();
		assertEquals(70, top2);
		assertArrayEquals(new Integer[] { 27, 15, 20, 10, 5, 7, 17 }, heap.toArray());
		heap.insert(75);
		assertArrayEquals(new Integer[] { 75, 27, 20, 15, 5, 7, 17, 10 }, heap.toArray());
		heap.insert(30);
		assertArrayEquals(new Integer[] { 75, 30, 20, 27, 5, 7, 17, 10, 15 }, heap.toArray());
		int top3 = heap.extract();
		assertEquals(75, top3);
		assertArrayEquals(new Integer[] { 30, 27, 20, 15, 5, 7, 17, 10 }, heap.toArray());
		int top4 = heap.extract();
		assertEquals(30, top4);
		assertArrayEquals(new Integer[] { 27, 15, 20, 10, 5, 7, 17 }, heap.toArray());
	}
}
