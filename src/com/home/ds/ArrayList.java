package com.home.ds;

import java.util.Arrays;

public class ArrayList<E> {

	private int capacity;
	private Object[] arr;
	private int count;

	public ArrayList(int capacity) {
		this.capacity = capacity;
		arr = new Object[capacity];
	}

	public ArrayList() {
		this(10);
	}

	public void add(E e) {
		ensureCapacity();
		arr[count++] = e;
	}

	public void add(E e, int index) {
		checkRange(index);
		ensureCapacity();
		System.arraycopy(arr, index, arr, index + 1, count - index);
		arr[index] = e;
		count++;
	}

	@SuppressWarnings("unchecked")
	public E get(int index) {
		checkRange(index);
		return (E) arr[index];
	}

	@SuppressWarnings("unchecked")
	public E remove(int index) {
		checkRange(index);
		E e = (E) arr[index];
		System.arraycopy(arr, index + 1, arr, index, count - index - 1);
		arr[count - 1] = null;
		count--;
		return e;
	}

	@SuppressWarnings("unchecked")
	public E remove(E ele) {
		for (int i = 0; i < arr.length; i++) {
			if (ele.equals(arr[i])) {
				E returned = (E) arr[i];
				System.arraycopy(arr, i + 1, arr, i, arr.length - i - 1);
				arr[count - 1] = null;
				count--;
				return returned;
			}
		}
		return null;
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public int size() {
		return count;
	}

	private void checkRange(int index) {
		if (index < 0 || index > capacity) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + count);
		}
	}

	private void ensureCapacity() {
		if (count >= capacity) {
			capacity *= 2;
			arr = Arrays.copyOf(arr, capacity);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		if (count > 0) {
			for (int i = 0; i < count; i++) {
				sb.append(arr[i]);
				if (i < count - 1) {
					sb.append(", ");
				}
			}
		}
		sb.append("]");
		return sb.toString();

	}
}