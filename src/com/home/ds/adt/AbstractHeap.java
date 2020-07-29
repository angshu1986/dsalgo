package com.home.ds.adt;

import java.util.Comparator;

import com.home.ds.linear.ArrayList;

public abstract class AbstractHeap<V> implements Heap<V> {

	protected List<V> heap;
	protected Comparator<V> comparator;
	private static final int DEFAULT_SIZE = 10;

	public AbstractHeap() {
		this(DEFAULT_SIZE, null);
	}

	public AbstractHeap(Comparator<V> comparator) {
		this(DEFAULT_SIZE, comparator);
	}

	public AbstractHeap(int size) {
		this(size, null);
	}

	public AbstractHeap(int size, Comparator<V> comparator) {
		this.comparator = comparator;
		heap = new ArrayList<>(size);
	}

	@Override
	public V get() {
		if (heap.size() > 0)
			return heap.get(0);
		return null;
	}

	@Override
	public boolean isEmpty() {
		return heap.size() == 0;
	}

	@Override
	public int size() {
		return heap.size();
	}

	protected void heapify(int i, boolean isMinHeap) {
		int n = heap.size();
		if (isMinHeap) {
			minheapify(n, i);
		} else {
			maxheapify(n, i);
		}
	}

	@SuppressWarnings("unchecked")
	private void maxheapify(int n, int i) {
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;

		V left = l < n ? heap.get(l) : null;
		V right = r < n ? heap.get(r) : null;
		V root = heap.get(largest);
		int compareLeft = left != null
				? comparator != null ? comparator.compare(left, root) : ((Comparable<? super V>) left).compareTo(root)
				: -1;
		if (l < n && compareLeft > 0) {
			largest = l;
			root = left;
		}

		int compareRight = right != null
				? comparator != null ? comparator.compare(right, root) : ((Comparable<? super V>) right).compareTo(root)
				: -1;
		if (r < n && compareRight > 0) {
			largest = r;
			root = right;
		}
		if (largest != i) {
			V ith = heap.get(i);
			heap.set(ith, largest);
			heap.set(root, i);
			maxheapify(n, largest);
		}
	}

	@SuppressWarnings("unchecked")
	private void minheapify(int n, int i) {
		int smallest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;

		V left = l < n ? heap.get(l) : null;
		V right = r < n ? heap.get(r) : null;
		V root = heap.get(smallest);
		int compareLeft = left != null
				? comparator != null ? comparator.compare(left, root) : ((Comparable<? super V>) left).compareTo(root)
				: -1;
		if (l < n && compareLeft < 0) {
			smallest = l;
			root = left;
		}

		int compareRight = right != null
				? comparator != null ? comparator.compare(right, root) : ((Comparable<? super V>) right).compareTo(root)
				: -1;
		if (r < n && compareRight < 0) {
			smallest = r;
			root = right;
		}
		if (smallest != i) {
			V ith = heap.get(i);
			heap.set(ith, smallest);
			heap.set(root, i);
			minheapify(n, smallest);
		}
	}

	@Override
	public V[] toArray() {
		return heap.toArray();
	}

	@Override
	public String toString() {
		return heap.toString();
	}

}
