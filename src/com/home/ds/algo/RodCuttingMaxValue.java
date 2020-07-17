package com.home.ds.algo;

import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Cut a rod of length n to make max profit
 * cutRod(n) = max(price[i] + cutRod(n-i-1)) for all i in {0, 1 .. n-1}
 * 
 * @author angsh
 *
 */
public class RodCuttingMaxValue {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String in = s.next();
		int inArr[] = Stream.of(in.split(",")).map(m -> m.trim()).filter(f -> !"".equalsIgnoreCase(f))
				.mapToInt(m -> Integer.parseInt(m)).toArray();
		int n = inArr.length;
		long dpSt = System.currentTimeMillis();
		int dpRes = rodCuttingDp(inArr, n);
		long dpEnd = System.currentTimeMillis();
		long dpTime = (dpEnd - dpSt);
		System.out.println(
				"Rod cutting max value using dp for n = " + n + " is " + dpRes + " time taken " + dpTime + " ms");
		long recSt = System.currentTimeMillis();
		int recRes = rodCuttingRecursive(inArr, n);
		long recEnd = System.currentTimeMillis();
		long recTime = (recEnd - recSt);
		System.out.println(
				"Rod cutting max value recursive for n = " + n + " is " + recRes + " time taken " + recTime + " ms");
		s.close();
	}

	private static int rodCuttingDp(int[] arr, int n) {
		int val[] = new int[n+1];
		int max = Integer.MIN_VALUE;
		val[0] = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				max = Math.max(max, val[i - j - 1] + arr[j]);
			}
			val[i] = max;
		}
		return val[n];
	}

	private static int rodCuttingRecursive(int[] arr, int n) {
		if (n <= 0)
			return 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, arr[i] + rodCuttingRecursive(arr, n - i - 1));
		}
		return max;
	}
}
