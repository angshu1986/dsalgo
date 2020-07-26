package com.home.ds.tree;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import com.home.ds.adt.Heap;

public class MinHeapTest {

	private Heap<Integer> heap;

	@Before
	public void setUp() throws Exception {
		heap = new MinHeap<>();
		heap.insert(10);
		heap.insert(20);
		heap.insert(5);
		heap.insert(30);
		heap.insert(15);
	}

	@Test
	public void testSequence() {
		assertArrayEquals(new Integer[] { 5, 15, 10, 30, 20 }, heap.toArray());
	}

	@Test
	public void testExtract() {
		int top = heap.extract();
		assertEquals(5, top);
		assertArrayEquals(new Integer[] { 10, 15, 20, 30 }, heap.toArray());
	}

	@Test
	public void testInsert() {
		heap.insert(4);
		assertArrayEquals(new Integer[] { 4, 15, 5, 30, 20, 10 }, heap.toArray());
	}

	@Test
	public void testGet() {
		int top = heap.get();
		assertEquals(5, top);
		assertArrayEquals(new Integer[] { 5, 15, 10, 30, 20 }, heap.toArray());
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
		assertArrayEquals(new Integer[] { 5, 15, 7, 30, 20, 10 }, heap.toArray());
		int top1 = heap.extract();
		assertEquals(5, top1);
		assertArrayEquals(new Integer[] { 7, 15, 10, 30, 20 }, heap.toArray());
		heap.insert(17);
		assertArrayEquals(new Integer[] { 7, 15, 10, 30, 20, 17 }, heap.toArray());
		heap.insert(8);
		assertArrayEquals(new Integer[] { 7, 15, 8, 30, 20, 17, 10 }, heap.toArray());
		heap.insert(27);
		assertArrayEquals(new Integer[] { 7, 15, 8, 27, 20, 17, 10, 30 }, heap.toArray());
		int top2 = heap.extract();
		assertEquals(7, top2);
		assertArrayEquals(new Integer[] { 8, 15, 10, 27, 20, 17, 30 }, heap.toArray());
		heap.insert(25);
		assertArrayEquals(new Integer[] { 8, 15, 10, 25, 20, 17, 30, 27 }, heap.toArray());
		heap.insert(13);
		assertArrayEquals(new Integer[] { 8, 13, 10, 15, 20, 17, 30, 27, 25 }, heap.toArray());
		int top3 = heap.extract();
		assertEquals(8, top3);
		assertArrayEquals(new Integer[] { 10, 13, 17, 15, 20, 25, 30, 27 }, heap.toArray());
		int top4 = heap.extract();
		assertEquals(10, top4);
		assertArrayEquals(new Integer[] { 13, 15, 17, 27, 20, 25, 30 }, heap.toArray());
	}
}
