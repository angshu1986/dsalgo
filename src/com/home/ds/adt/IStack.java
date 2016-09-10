package com.home.ds.adt;

public interface IStack<E> {

	public void push(E ele);
	public E pop();
	public E top();
	public int size();
	public boolean isEmpty();
}
