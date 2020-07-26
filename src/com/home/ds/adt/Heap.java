package com.home.ds.adt;

public interface Heap<V> {

	V get();

	V extract();

	void insert(V v);

	boolean isEmpty();

	int size();

	V[] toArray();
}
