package com.home.ds;

public class Stack<E> {

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
	
	public void push(E ele) {
		Node<E> newNode = new Node<>(ele);
		if ((head = tail) == null) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
		}
		count++;
	}
	
	public E pop() {
		if ((head = tail) == null) {
			throw new IllegalArgumentException("Empty stack");
		} else {
			E ele = head.ele;
			head = head.next;
			count--;
			if (count == 0) {
				tail = null;
			}
			return ele;
		}
	}
}
