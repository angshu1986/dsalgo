package com.home.service.dto;

import java.util.Arrays;

public class SorterRequest {

	private int []arr;
	private SortType sortType;
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
	public boolean isReturnSortedArray() {
		return returnSortedArray;
	}
	public void setReturnSortedArray(boolean returnSortedArray) {
		this.returnSortedArray = returnSortedArray;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(arr);
		result = prime * result + (returnSortedArray ? 1231 : 1237);
		result = prime * result + ((sortType == null) ? 0 : sortType.hashCode());
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
		SorterRequest other = (SorterRequest) obj;
		if (!Arrays.equals(arr, other.arr))
			return false;
		if (returnSortedArray != other.returnSortedArray)
			return false;
		if (sortType != other.sortType)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SorterRequest [arr=" + Arrays.toString(arr) + ", sortType=" + sortType + ", returnSortedArray="
				+ returnSortedArray + "]";
	}
}
