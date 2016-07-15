package com.home.ds;

public class DoublyLinkedList<E> {

	private static class Node<E> {
		private E ele;
		private Node<E> prev;
		private Node<E> next;
		private Node(E ele) {
			this.ele = ele;
		}
	}
	
	private Node<E> head;
	private Node<E> tail;
	private int count;
	
	public void addFirst(E ele) {
		Node<E> newNode = new Node<>(ele);
		if (count == 0) {
			head = tail = newNode;
		} else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
		count++;
	}
	
	public void addLast(E ele) {
		Node<E> newNode = new Node<>(ele);
		if (count == 0) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
	}
	
	public E removeFirst() {
		if (head == null) {
			return null;
		}
		E ele = head.ele;
		head = head.next;
		head.prev = null;
		count--;
		return ele;
	}
	
	public E removeLast() {
		if (tail == null) {
			return null;
		}
		E ele = tail.ele;
		tail = tail.prev;
		tail.next = null;
		count--;
		return ele;
	}
	
	public void add(E ele, int index) {//TODO: complete this method
		if (index < 0 || index > count - 1) {
			throw new IndexOutOfBoundsException("Index: " + index + " Size: " + count);
		}
	}
}
