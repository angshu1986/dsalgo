package com.home.service.dto;

import com.home.ds.sort.BubbleSort;
import com.home.ds.sort.HeapSort;
import com.home.ds.sort.InsertionSort;
import com.home.ds.sort.MergeSort;
import com.home.ds.sort.QuickSort;
import com.home.ds.sort.SelectionSort;
import com.home.ds.sort.Sort;
import com.home.ds.sort.TimSort;

public class SortSelector {

	public static Sort getSorter(SortType sortType) {
		switch (sortType) {
		case MERGE:
			return new MergeSort();
		case QUICK:
			return new QuickSort();
		case BUBBLE:
			return new BubbleSort();
		case INSERTION:
			return new InsertionSort();
		case SELECTION:
			return new SelectionSort();
		case HEAP:
			return new HeapSort();
		case TIM:
			return new TimSort();
		default:
			throw new IllegalArgumentException("Sorting not implemented for " + sortType + " sort");
		}
	}
}
