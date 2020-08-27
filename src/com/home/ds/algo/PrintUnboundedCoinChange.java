package com.home.ds.algo;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

import com.home.ds.adt.List;
import com.home.ds.linear.ArrayList;

/**
 * Print all coins that make up a given value, assuming infinite number of coins
 * are present
 * 
 * @author angsh
 *
 */
public class PrintUnboundedCoinChange {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int val = s.nextInt();
		String in = s.next();
		int inArr[] = Stream.of(in.split(",")).map(m -> m.trim()).filter(f -> !"".equalsIgnoreCase(f))
				.mapToInt(m -> Integer.parseInt(m)).toArray();
		long recSt = System.currentTimeMillis();
		List<List<Integer>> result = new ArrayList<>();
		printCoinChange(inArr, val, result, new ArrayList<>(), 0);
		long recEnd = System.currentTimeMillis();
		long recTime = (recEnd - recSt);
		System.out.println("Total ways for coins " + Arrays.toString(inArr) + " to make " + val + " value is " + result.size() + " time taken " + recTime + " ms");
		System.out.println(result);
		s.close();
	}

	private static void printCoinChange(int[] coins, int val, List<List<Integer>> result, List<Integer> current,
			int index) {
		if (val == 0) {
			result.add(new ArrayList<>(current));
			return;
		}
		if (val < 0)
			return;
		for (int i = index; i < coins.length; i++) {
			if (coins[i] <= val) {
				current.add(coins[i]);
				printCoinChange(coins, val - coins[i], result, current, i);
				current.remove(current.size() - 1);
			}
		}
	}
}
