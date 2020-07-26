package com.home.ds.sort;

public class QuickSort implements Sort {
	
	public static void main(String[] args) {
		int arr[] = new int[]{1, 3, -6, 2, 5, -3, 7};
		new QuickSort().sort(arr);
		printArray(arr);
	}
	
	static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    }

	@Override
	public void sort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	private int partition(int a[], int st, int end) {
		int pv = a[end];
		//swap(a, (st + end) / 2, end);
		int index = st;
		for (int i = st; i < end; i++) {
			if (a[i] <= pv) {
				swap(a, index++, i);
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
