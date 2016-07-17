package com.home.ds.adt;

public interface IDQueue<E> {

	void offerFirst(E ele);

	void offerLast(E ele);

	E pollFirst();

	E pollLast();

	E peekFirst();

	E peekLast();

	int size();

	boolean isEmpty();

}