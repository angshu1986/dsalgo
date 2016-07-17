package com.home.ds.linear;

import com.home.ds.adt.IDQueue;

public class DQueue<E> implements IDQueue<E> {

	private static class Node<E> {
		private E ele;
		private Node<E> next;

		private Node(E ele) {
			this.ele = ele;
		}
	}

	private Node<E> head;
	private Node<E> tail;
	private int count;

	@Override
	public void offerFirst(E ele) {
		Node<E> newNode = new Node<>(ele);
		if ((head) == null) {
			head = tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		count++;
	}

	@Override
	public void offerLast(E ele) {
		Node<E> newNode = new Node<>(ele);
		if ((head) == null) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		count++;
	}

	@Override
	public E pollFirst() {
		if (head == null) {
			throw new RuntimeException("Empty queue");
		} else {
			E ele = head.ele;
			head = head.next;
			if (--count == 0) {
				tail = null;
			}
			return ele;
		}
	}

	@Override
	public E pollLast() {
		if (head == null) {
			throw new RuntimeException("Empty queue");
		} else {
			Node<E> tmp = head;
			while (tmp.next != null) {
				tmp = tmp.next;
			}
			E ele = tmp.ele;
			tmp = tail;
			if (--count == 0) {
				head = null;
			}
			return ele;
		}
	}

	@Override
	public E peekFirst() {
		return head.ele;
	}

	@Override
	public E peekLast() {
		return tail.ele;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node<E> tmp = head;
		if (count > 0) {
			while (tmp != null) {
				sb.append(tmp.ele);
				tmp = tmp.next;
				if (tmp != null) {
					sb.append(", ");
				}
			}
		}
		sb.append("]");
		return sb.toString();
	}
}
