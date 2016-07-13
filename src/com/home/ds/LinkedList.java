package com.home.ds;

public class LinkedList<E> {

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
	
	public void add(E ele) {
		Node<E> newNode = new Node<>(ele);
		if (head == null) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		count++;
}
	
	public E remove(E ele) {
		if (head.ele.equals(ele)) {
			E y = head.ele;
			head = head.next;
			count--;
			return y;
		}
		Node<E> tmp = head;
		E x = null;
		while (tmp != null) {
			tmp = tmp.next;
			if (tmp.ele.equals(ele)) {
				tmp = tmp.next.next;
				count--;
				break;
			}
		}
		
		return x;
	}
	
	public int size() {
		return count;
	}
	
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
