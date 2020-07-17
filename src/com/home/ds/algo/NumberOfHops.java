package com.home.ds.algo;

import java.util.Scanner;

/**
 * Number of hops to reach nth star, given only one or two or three hops can be taken
 * @author angsh
 *
 */
public class NumberOfHops {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		long dpSt = System.currentTimeMillis();
		long dpRes = hops(n);
		long dpEnd = System.currentTimeMillis();
		long dpTime = (dpEnd - dpSt);
		System.out.println("Number of hops using dp for n = " + n + " is " + dpRes + " time taken " + dpTime + " ms");
		long recSt = System.currentTimeMillis();
		long recRes = hopsRecursive(n);
		long recEnd = System.currentTimeMillis();
		long recTime = (recEnd - recSt);
		System.out.println("Number of hops recursive for n = " + n + " is " + recRes + " time taken " + recTime + " ms");
		s.close();
	}

	private static long hops(int n) {
		if (n == 0 || n == 1)
			return 1;
		if (n == 2)
			return 2;
		java.math.BigDecimal s1 = java.math.BigDecimal.ONE;
		java.math.BigDecimal s2 = java.math.BigDecimal.ONE;
		java.math.BigDecimal s3 = java.math.BigDecimal.ONE.add(java.math.BigDecimal.ONE);
		java.math.BigDecimal s4 = java.math.BigDecimal.ZERO;
		for (int i = 3; i <= n; i++) {
			s4 = s1.add(s2).add(s3);
			s1 = s2;
			s2 = s3;
			s3 = s4;
		}
		return s4.remainder(new java.math.BigDecimal("1000000007")).longValue();
	}
	
	private static long hopsRecursive(int n) {
		if (n == 0 || n == 1)
			return 1;
		if (n == 2)
			return 2;
		return hopsRecursive(n - 1) + hopsRecursive(n - 2) + hopsRecursive(n - 3);
	}
}
