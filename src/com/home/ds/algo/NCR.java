package com.home.ds.algo;

import java.util.Scanner;

public class NCR {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String in = s.next();
		String arr[] = in.split(",");
		int n = Integer.parseInt(arr[0].trim());
		int r = Integer.parseInt(arr[1].trim());
		long dpSt = System.currentTimeMillis();
		int dpRes = nCrModp(n, r);
		long dpEnd = System.currentTimeMillis();
		long dpTime = (dpEnd - dpSt);
		System.out.println("Combination for n = " + n + " and r = " + r + " using dp is " + dpRes + " time taken "
				+ dpTime + " ms");
		long recSt = System.currentTimeMillis();
		long recRes = nCrModpRecursive(n, r);
		long recEnd = System.currentTimeMillis();
		long recTime = (recEnd - recSt);
		System.out.println("Combination for n = " + n + " and r = " + r + " using recursion is " + recRes
				+ " time taken " + recTime + " ms");
		s.close();
	}

	private static int nCrModp(int n, int r) {
		if (r > n)
			return 0;
		if (n == r || r == 0)
			return 1;
		if (r == 1)
			return n;
		if (r > n - r)
			r = n - r;
		double arr[] = new double[r + 1];
		arr[0] = 1;
		for (int i = 1; i <= n; i++) {
			double prev = 1;
			for (int j = 1; j <= r; j++) {
				double tmp = arr[j];
				arr[j] = (arr[j] + prev) % (Math.pow(10, 9) + 7);
				prev = tmp;
			}
		}
		return (int) arr[r];
	}

	private static int nCrModpRecursive(int n, int r) {
		if (r > n)
			return 0;
		if (n == r || r == 0)
			return 1;
		if (r == 1)
			return n;
		if (r > n - r)
			r = n - r;
		return (int) ((nCrModpRecursive(n - 1, r - 1) + nCrModpRecursive(n - 1, r))% (Math.pow(10, 9) + 7));
	}

}
