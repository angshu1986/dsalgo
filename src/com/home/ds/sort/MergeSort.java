package com.home.ds.sort;

public class MergeSort implements Sort {
	
	@Override
	public int[] sort(int[] arr) {
		if (arr == null) {
			return arr;
		}
		if (arr.length == 1) {
			return arr;
		}
		return sort(arr, 0, arr.length - 1);
	}

	private int[] sort(int[] arr, int st, int end) {
		if (st >= end) {
			return arr;
		}
		int k = (end - st) / 2 + st;
		int arr1[] = new int[k + 1];
		int arr2[] = new int[end - k];
		System.arraycopy(arr, st, arr1, 0, arr1.length);
		System.arraycopy(arr, k + 1, arr2, 0, arr2.length);
		sort(arr1, 0, arr1.length - 1);
		sort(arr2, 0, arr2.length - 1);
		merge(arr1, arr2, arr);
		return arr;
	}

	private void merge(int arr1[], int arr2[], int arr[]) {
		int i = 0, j = 0, k = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] > arr2[j]) {
				arr[k++] = arr2[j++];
			} else {
				arr[k++] = arr1[i++];
			}
		}
		while (i < arr1.length) {
			arr[k++] = arr1[i++];
		}
		while (j < arr2.length) {
			arr[k++] = arr2[j++];
		}
	}
}
