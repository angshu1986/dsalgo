package com.home.ds.linear;

import com.home.ds.adt.IQueue;

public class Queue<E> implements IQueue<E> {

	private static class Node<E> {
		private E ele;
		private Node<E> next;
		public Node(E ele) {
			this.ele = ele;
		}
	}
	
	private Node<E> head;
	private Node<E> tail;
	private int count;
	
	@Override
	public void offer(E ele) {
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
	public E poll() {
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
	public E peek() {
		return tail.ele;
	}
	
	@Override
	public int size() {
		return count;
	}
	
	@Override
	public boolean isEmpty() {
		return (head == null);
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
