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
	public String toString() {//TODO: print in same logic using recursion
		StringBuilder sb = new StringBuilder("[");
		if (count > 0) {
			Node<E> tmp = top;
			Object arr[] = new Object[count];
			int i = 0;
			while (tmp != null) {
				arr[i++] = tmp.ele;
				tmp = tmp.next;
			}
			for (; i > 0; i--) {
				sb.append(arr[i - 1]);
				if (i > 1) {
					sb.append(", ");
				}
			}
		}
		sb.append("]");
		return sb.toString();
	}
}
