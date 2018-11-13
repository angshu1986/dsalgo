package com.home.ds.sort;

public class QuickSort implements Sort {

	@Override
	public int[] sort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
		return arr;
	}

	private int partition(int a[], int st, int end) {
		int pv = a[(st + end) / 2];
		int index = st;
		for (int i = st; i < end; i++) {
			if (a[i] <= pv) {
				swap(a, index, i);
				index++;
			}
		}
		swap(a, index, end);
		return index;
	}

	private void quickSort(int a[], int st, int end) {
		if (st >= end) {
			return;
		}
		int p = partition(a, st, end);
		quickSort(a, st, p - 1);
		quickSort(a, p + 1, end);
	}
	
	private void swap(int a[], int x, int y) {
		int tmp = a[x];
		a[x] = a[y];
		a[y] = tmp;
	}
}
