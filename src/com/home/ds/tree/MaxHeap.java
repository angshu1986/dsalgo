package com.home.ds.tree;

import com.home.ds.adt.AbstractHeap;

public class MaxHeap<V> extends AbstractHeap<V> {

	@Override
	public V extract() {
		if (heap.size() == 0)
			return null;
		V top = heap.get(0);
		int size = heap.size() - 1;
		heap.set(heap.get(size), 0);
		heap.remove(size);
		heapify(0, false);
		return top;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void insert(V v) {
		heap.add(v);
		int i = heap.size() - 1;
		int p = (i - 1) / 2;

		while (i != 0) {
			V parent = heap.get(p);
			V inserted = heap.get(i);
			int compare = comparator != null ? comparator.compare(parent, inserted)
					: ((Comparable<? super V>) parent).compareTo(inserted);
			if (compare < 0) {
				heap.set(parent, i);
				heap.set(inserted, p);
				i = p;
				p = (i - 1) / 2;
			} else {
				break;
			}
		}
	}

}
