package com.home.ds.linear;

import java.util.Iterator;

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
		count++;
	}

	public E removeFirst() {
		if (head == null) {
			return null;
		}
		E ele = head.ele;
		head = head.next;
		if (--count == 0) {
			head = tail = null;
		} else {
			head.prev = null;
		}
		return ele;
	}

	public E removeLast() {
		if (tail == null) {
			return null;
		}
		E ele = tail.ele;
		tail = tail.prev;
		if (--count == 0) {
			head = tail = null;
		} else {
			tail.next = null;
		}
		return ele;
	}

	public int size() {
		return count;
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public void add(E ele, int index) {
		if (index < 0 || index > count - 1) {
			throw new IndexOutOfBoundsException("Index: " + index + " Size: " + count);
		}
		Node<E> newNode = new Node<>(ele);
		if (index < (count / 2)) {
			Node<E> tmp = head;
			int i = 0;
			while (i++ < index - 1) {
				tmp = tmp.next;
			}
			newNode.next = tmp.next;
			tmp.next.prev = newNode;
			tmp.next = newNode;
			newNode.prev = tmp;
		} else {
			Node<E> tmp = tail;
			int i = count - 1;
			while (i-- > index) {
				tmp = tmp.prev;
			}
			newNode.prev = tmp.prev;
			tmp.prev.next = newNode;
			tmp.prev = newNode;
			newNode.next = tmp;
		}
		count++;
	}

	public E remove(E ele) {
		Node<E> tmp = head;
		E x = null;
		while (tmp != null) {
			if (tmp.ele.equals(ele)) {
				x = tmp.ele;
				Node<E> prev = tmp.prev;
				Node<E> next = tmp.next;
				if (prev == null) {
					head = next;
				} else {
					prev.next = next;
				}
				if (next == null) {
					tail = prev;
				} else {
					next.prev = prev;
				}
				tmp.ele = null;
				tmp.prev = null;
				tmp.next = null;
				count--;
				break;
			}
			tmp = tmp.next;
		}
		return x;
	}

	public E remove(int index) {
		if (index < 0 || index > count - 1) {
			throw new IndexOutOfBoundsException("Index: " + index + " Size: " + count);
		}
		if (index < (count / 2)) {
			int s = 0;
			Node<E> tmp = head;
			while (s++ < index) {
				tmp = tmp.next;
			}
			E x = tmp.ele;
			Node<E> prev = tmp.prev;
			Node<E> next = tmp.next;
			if (prev == null) {
				head = next;
			} else {
				prev.next = next;
			}
			if (next == null) {
				tail = prev;
			} else {
				next.prev = prev;
			}
			tmp.ele = null;
			tmp.prev = null;
			tmp.next = null;
			count--;
			return x;
		} else {
			int s = count - 1;
			Node<E> tmp = tail;
			while (s-- > index) {
				tmp = tmp.prev;
			}
			E x = tmp.ele;
			Node<E> prev = tmp.prev;
			Node<E> next = tmp.next;
			if (prev == null) {
				head = next;
			} else {
				prev.next = next;
			}
			if (next == null) {
				tail = prev;
			} else {
				next.prev = prev;
			}
			tmp.ele = null;
			tmp.prev = null;
			tmp.next = null;
			count--;
			return x;
		}
	}
	
	public E get(int index) {
		if (index < 0 || index > count - 1) {
			throw new IndexOutOfBoundsException("Index: " + index + " Size: " + count);
		}
		if (index == 0) {
			return head.ele;
		}
		if (index == (count - 1)) {
			return tail.ele;
		}
		if (index < (count / 2)) {
			int s = 0;
			Node<E> tmp = head;
			while (s++ < index) {
				tmp = tmp.next;
			}
			return tmp.ele;
		} else {
			int s = count - 1;
			Node<E> tmp = tail;
			while (s-- > index) {
				tmp = tmp.prev;
			}
			return tmp.ele;
		}
	}


	public Iterator<E> iterator() {
		return new Itr();
	}
	
	private class Itr implements Iterator<E> {

		Node<E> tmp = head;

		@Override
		public boolean hasNext() {
			return tmp != null;
		}

		@Override
		public E next() {
			E ele = tmp.ele;
			tmp = tmp.next;
			return ele;
		}

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
