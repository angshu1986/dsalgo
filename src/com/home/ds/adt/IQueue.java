package com.home.ds.adt;

public interface IQueue<E> {

	void offer(E ele);

	E poll();

	E peek();

	int size();

	boolean isEmpty();

}