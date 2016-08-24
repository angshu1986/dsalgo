package com.home.ds.linear;

import java.util.Iterator;

import com.home.ds.adt.IStack;

public class Stack2<E> implements IStack<E> {

	private DoublyLinkedList<E> l;

	public Stack2() {
		l = new DoublyLinkedList<>();
	}

	@Override
	public void push(E ele) {
		l.addLast(ele);
	}

	@Override
	public E pop() {
		return l.removeLast();
	}

	@Override
	public E top() {
		return l.get(size() - 1);
	}

	@Override
	public int size() {
		return l.size();
	}

	@Override
	public boolean isEmpty() {
		return l.isEmpty();
	}

	@Override
	public String toString() {
		return l.toString();
	}
	
	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public E next() {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}
}
