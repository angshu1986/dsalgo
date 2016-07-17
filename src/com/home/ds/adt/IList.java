package com.home.ds.adt;

public interface IList<E> {

	void add(E ele);

	void add(E ele, int index);

	E get(int index);

	E remove(E ele);

	E remove(int index);

	int size();

	boolean isEmpty();

}