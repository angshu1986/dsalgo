package com.home.service.dto;

import java.util.Arrays;

public class SorterResponse {

	private int []arr;
	private SortType sortType;
	private long sortingTimeMillis;
	private boolean returnSortedArray;
	private int count;
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(arr);
		result = prime * result + count;
		result = prime * result + (returnSortedArray ? 1231 : 1237);
		result = prime * result + ((sortType == null) ? 0 : sortType.hashCode());
		result = prime * result + (int) (sortingTimeMillis ^ (sortingTimeMillis >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SorterResponse other = (SorterResponse) obj;
		if (!Arrays.equals(arr, other.arr))
			return false;
		if (count != other.count)
			return false;
		if (returnSortedArray != other.returnSortedArray)
			return false;
		if (sortType != other.sortType)
			return false;
		if (sortingTimeMillis != other.sortingTimeMillis)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SorterResponse [arr=" + Arrays.toString(arr) + ", sortType=" + sortType + ", sortingTimeMillis="
				+ sortingTimeMillis + ", returnSortedArray=" + returnSortedArray + ", count=" + count + "]";
	}
}
