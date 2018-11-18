package com.home.service;

import java.util.Calendar;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.home.ds.sort.Sort;
import com.home.service.dto.SortSelector;
import com.home.service.dto.SortType;
import com.home.service.dto.SorterRequest;
import com.home.service.dto.SorterResponse;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = {"http://localhost:8080"})
public class RestController {
	
	@RequestMapping("/sort")
	@CrossOrigin(origins = "*")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public SorterResponse sort(@RequestBody SorterRequest request) {
		SorterResponse response = new SorterResponse();
		Sort sorter = SortSelector.getSorter(request.getSortType());
		System.out.println(request.getSortType() + " Sorting started for " + request.getArr().length + " integers");
		long start = System.currentTimeMillis();
		int arr[] = sorter.sort(request.getArr());
		long end = System.currentTimeMillis();
		long runtime = end - start;
		System.out.println("Sorting time for " + request.getSortType() + " sort took " + runtime * 1000 + " nanoseconds or " + runtime + " milliseconds " + " for " + request.getArr().length + " integers");
		response.setReturnSortedArray(request.isReturnSortedArray());
		if(request.isReturnSortedArray()) {
			response.setArr(arr);
		}
		response.setSortingTimeMillis(runtime);
		response.setSortType(request.getSortType());
		response.setCount(request.getArr().length);
		return response;
	}
	
	@RequestMapping("/getSortTypes")
	@Produces(MediaType.APPLICATION_JSON)
	@CrossOrigin(origins = "*")
	public SortType[] getSortTypes() {
		System.out.println("Sending sort types");
		return SortType.values();
	}
}
