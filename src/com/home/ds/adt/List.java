package com.home.ds.adt;

public interface List<E> extends Iterable<E> {

	void add(E ele);

	void add(E ele, int index);

	E get(int index);

	E remove(E ele);

	E remove(int index);

	int size();

	boolean isEmpty();

	E getLast(int index);

	E set(E element, int index);

	E[] toArray();

}