package com.home.service.dto;

public class SorterResponse {

	private int []arr;
	private SortType sortType;
	private long sortingTimeMillis;
	private boolean returnSortedArray;
	public int[] getArr() {
		return arr;
	}
	public void setArr(int[] arr) {
		this.arr = arr;
	}
	public SortType getSortType() {
		return sortType;
	}
	public void setSortType(SortType sortType) {
		this.sortType = sortType;
	}
	public long getSortingTimeMillis() {
		return sortingTimeMillis;
	}
	public void setSortingTimeMillis(long sortingTimeMillis) {
		this.sortingTimeMillis = sortingTimeMillis;
	}
	public boolean isReturnSortedArray() {
		return returnSortedArray;
	}
	public void setReturnSortedArray(boolean returnSortedArray) {
		this.returnSortedArray = returnSortedArray;
	}
}
