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
	
	public void addFirst(E ele) {
		Node<E> newNode = new Node<>(ele);
		if (head == null) {
			head = tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		count++;
	}
	
	public void addLast(E ele) {
		Node<E> newNode = new Node<>(ele);
		if (head == null) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		count++;
	}
	
	public E removeFirst() {
		if (count == 0) {
			throw new RuntimeException("Empty list");
		} else {
			E ele = head.ele;
			head = head.next;
			if (--count == 0) {
				tail = null;
			}
			return ele;
		}
	}
	
	public E removeLast() {
		if (count == 0) {
			throw new RuntimeException("Empty list");
		} else {
			E ele = tail.ele;
			Node<E> tmp = head;
			while (true) {
				if (tmp.next == tail) {
					tail.ele = null;
					tail = tmp;
					break;
				}
				tmp = tmp.next; //TODO: continue from here
			}
			return ele;
		}
	}
	
	public void add(E ele) {
		addFirst(ele);
	}
}
