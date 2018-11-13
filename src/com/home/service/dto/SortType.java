package com.home.service.dto;

public enum SortType {

	BUBBLE("BUBBLE"), MERGE("MERGE"), QUICK("QUICK"), HEAP("HEAP"), INSERTION("INSERTION"), RADIX("RADIX"), TIM("TIM");
	private String sortType;

	private SortType(String sortType) {
		this.sortType = sortType;
	}
}
