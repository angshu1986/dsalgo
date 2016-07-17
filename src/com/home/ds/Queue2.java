package com.home.ds;

import com.home.ds.adt.IQueue;

public class Queue2<E> implements IQueue<E> {

	private DoublyLinkedList<E> l;

	public Queue2() {
		l = new DoublyLinkedList<>();
	}

	@Override
	public void offer(E ele) {
		l.addFirst(ele);
	}

	@Override
	public E poll() {
		return l.removeLast();
	}

	@Override
	public E peek() {
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
	
	@Override public String toString() {
		return l.toString();
	}
}
