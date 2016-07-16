package com.home.ds;

import com.home.ds.adt.Iqueue;

public class Queue2<E> implements Iqueue<E> {

	private DoublyLinkedList<E> l;

	public Queue2() {
		l = new DoublyLinkedList<>();
	}

	@Override
	public void enq(E ele) {
		l.addFirst(ele);
	}

	@Override
	public E deq() {
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

}
