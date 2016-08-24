package com.home.ds.adt;

import java.util.Iterator;

public interface IStack<E> {

	public void push(E ele);
	public E pop();
	public E top();
	public int size();
	public boolean isEmpty();
	public Iterator<E> iterator();
}
