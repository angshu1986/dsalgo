package com.home.ds.linear;

import com.home.ds.adt.IStack;

public class Stack<E> implements IStack<E> {

	private static class Node<E> {
		private E ele;
		private Node<E> next;

		public Node(E ele) {
			this.ele = ele;
		}
	}

	private Node<E> top;
	private int count;

	@Override
	public void push(E ele) {
		Node<E> newNode = new Node<>(ele);
		if (top == null) {
			top = newNode;
		} else {
			newNode.next = top;
			top = newNode;
		}
		count++;
	}

	@Override
	public E pop() {
		if (top == null) {
			throw new RuntimeException("Empty stack");
		} else {
			E ele = top.ele;
			top = top.next;
			count--;
			return ele;
		}
	}

	@Override
	public E top() {
		if (top == null) {
			return null;
		}
		return top.ele;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public boolean isEmpty() {
		return (top == null);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node<E> tmp = top;
		toString(sb, tmp);
		sb.append("]");
		return sb.toString();
	}
	
	private void toString(StringBuilder sb, Node<E> e) {
		if (e.next == null) {
			sb.append(e.ele);
			return;
		} else {
			toString(sb, e.next);
			sb.append(", ");
			sb.append(e.ele);
		}
	}
}
