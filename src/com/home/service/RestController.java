package com.home.service;

import java.util.Calendar;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.home.ds.sort.Sort;
import com.home.service.dto.SortSelector;
import com.home.service.dto.SorterRequest;
import com.home.service.dto.SorterResponse;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@RequestMapping("/sort")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public SorterResponse sort(@RequestBody SorterRequest request) {
		SorterResponse response = new SorterResponse();
		Sort sorter = SortSelector.getSorter(request.getSortType());
		System.out.println(request.getSortType() + " Sorting started at " + Calendar.getInstance().getTime());
		long start = System.currentTimeMillis();
		int arr[] = sorter.sort(request.getArr());
		long end = System.currentTimeMillis();
		System.out.println(request.getSortType() + " Sorting ended at " + Calendar.getInstance().getTime());
		long runtime = end - start;
		response.setReturnSortedArray(request.isReturnSortedArray());
		if(request.isReturnSortedArray()) {
			response.setArr(arr);
		}
		response.setSortingTimeMillis(runtime);
		response.setSortType(request.getSortType());
		return response;
	}
}
