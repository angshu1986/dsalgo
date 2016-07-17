package com.home.ds.linear;

import com.home.ds.adt.IList;

public class LinkedList<E> implements IList<E> {

	private static class Node<E> {
		private E ele;
		private Node<E> next;

		public Node(E ele) {
			this.ele = ele;
		}
	}

	private Node<E> head;
	private int count;

	@Override
	public void add(E ele) {
		Node<E> newNode = new Node<>(ele);
		if (head == null) {
			head = newNode;
		} else {
			Node<E> tmp = head;
			while (tmp.next != null) {
				tmp = tmp.next;
			}
			tmp.next = newNode;
		}
		count++;
	}

	@Override
	public void add(E ele, int index) {
		if (index < 0 || index > count - 1) {
			throw new IndexOutOfBoundsException("Index: " + index + " Size: " + count);
		}
		Node<E> newNode = new Node<>(ele);
		Node<E> tmp = head;
		int i = 0;
		while (i++ < index - 1) {
			tmp = tmp.next;
		}
		newNode.next = tmp.next;
		tmp.next = newNode;
		count++;

	}

	@Override
	public E get(int index) {
		if (index < 0 || index > count - 1) {
			throw new IndexOutOfBoundsException("Index: " + index + " Size: " + count);
		}
		Node<E> tmp = head;
		int i = 0;
		while (tmp != null) {
			if (i++ == index) {
				return tmp.ele;
			}
			tmp = tmp.next;
		}
		return null;
	}

	@Override
	public E remove(E ele) {
		if (head.ele.equals(ele)) {
			E y = head.ele;
			head = head.next;
			count--;
			return y;
		} else {
			Node<E> tmp = head;
			E x = null;
			while (tmp != null) {
				if (tmp.next.ele.equals(ele)) {
					x = tmp.next.ele;
					Node<E> prev = tmp.next;
					tmp.next = tmp.next.next;
					count--;
					prev.ele = null;
					prev.next = null;
					break;
				}
				tmp = tmp.next;
			}
			return x;
		}
	}

	@Override
	public E remove(int index) {
		if (index < 0 || index > count - 1) {
			throw new IndexOutOfBoundsException("Index: " + index + " Size: " + count);
		}
		if (index == 0) {
			E ele = head.ele;
			head = head.next;
			count--;
			return ele;
		} else {
			Node<E> tmp = head;
			int visited = 0;
			while (tmp != null) {
				if (visited++ == (index - 1)) {
					E ele = tmp.next.ele;
					tmp.next = tmp.next.next;
					count--;
					return ele;
				}
				tmp = tmp.next;
			}
			return null;
		}
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
		if (count > 0) {
			Node<E> tmp = head;
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
