package com.home.ds.linear;

import com.home.ds.adt.IDQueue;

public class DQueue2<E> implements IDQueue<E> {

	private DoublyLinkedList<E> l;

	public DQueue2() {
		l = new DoublyLinkedList<>();
	}

	@Override
	public void offerFirst(E ele) {
		l.addFirst(ele);
	}

	@Override
	public void offerLast(E ele) {
		l.addLast(ele);
	}

	@Override
	public E pollFirst() {
		return l.removeFirst();
	}

	@Override
	public E pollLast() {
		return l.removeLast();
	}

	@Override
	public E peekFirst() {
		return l.get(0);
	}

	@Override
	public E peekLast() {
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
}
