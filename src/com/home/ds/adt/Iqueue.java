package com.home.ds.adt;

public interface Iqueue<E> {

	void enq(E ele);

	E deq();

	E peek();

	int size();

	boolean isEmpty();

}