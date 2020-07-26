package com.home.ds.linear;

import java.util.Iterator;

import com.home.ds.adt.IList;

public class LinkedList2<E> implements IList<E> {

	private DoublyLinkedList<E> l;

	public LinkedList2() {
		l = new DoublyLinkedList<>();
	}

	@Override
	public void add(E ele) {
		l.addLast(ele);
	}

	@Override
	public void add(E ele, int index) {
		l.add(ele, index);
	}

	@Override
	public E get(int index) {
		return l.get(index);
	}

	@Override
	public E remove(E ele) {
		return l.remove(ele);
	}

	@Override
	public E remove(int index) {
		return l.remove(index);
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
		return l.iterator();
	}

	@Override
	public E getLast(int index) {
		return get(l.size() - index);
	}

	@Override
	public E set(E element, int index) {
		// TODO to be implemented in later check in
		return null;
	}
}
