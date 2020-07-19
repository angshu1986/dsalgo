package com.home.ds.algo;

import java.util.Scanner;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str1 = s.nextLine().trim();
		String str2 = s.next().trim();
		int m = str1.length();
		int n = str2.length();
		long dpSt = System.currentTimeMillis();
		int dpRes = lcsLengthDp(str1, str2, m, n);
		long dpEnd = System.currentTimeMillis();
		long dpTime = (dpEnd - dpSt);
		System.out.println("LCS length for string 1 = " + str1 + " and string 2 = " + str2 + " using dp is " + dpRes
				+ " time taken " + dpTime + " ms");
		long dpSpaceOptSt = System.currentTimeMillis();
		int dpSpaceOptRes = lcsLengthDpSpaceOptimized(str1, str2, m, n);
		long dpSpaceOptEnd = System.currentTimeMillis();
		long dpSpaceOptTime = (dpSpaceOptEnd - dpSpaceOptSt);
		System.out.println("LCS length for string 1 = " + str1 + " and string 2 = " + str2
				+ " using space optimized dp is " + dpSpaceOptRes + " time taken " + dpSpaceOptTime + " ms");
		long recSt = System.currentTimeMillis();
		long recRes = lcsLengthRecursive(str1, str2, m, n);
		long recEnd = System.currentTimeMillis();
		long recTime = (recEnd - recSt);
		System.out.println("LCS length for string 1 = " + str1 + " and string 2 = " + str2 + " using recursion is "
				+ recRes + " time taken " + recTime + " ms");
		s.close();
	}

	private static int lcsLengthRecursive(String str1, String str2, int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}

		if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
			return lcsLengthRecursive(str1, str2, m - 1, n - 1) + 1;
		}

		return Math.max(lcsLengthRecursive(str1, str2, m, n - 1), lcsLengthRecursive(str1, str2, m - 1, n));
	}

	private static int lcsLengthDp(String str1, String str2, int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}
		int dp[][] = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[m][n];
	}

	private static int lcsLengthDpSpaceOptimized(String str1, String str2, int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}
		int dp[] = new int[n + 1];
		for (int i = 1; i <= m; i++) {
			int prev = 0;
			for (int j = 1; j <= n; j++) {
				int tmp = dp[j];
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[j] = prev + 1;
				} else {
					dp[j] = Math.max(dp[j], dp[j - 1]);
				}
				prev = tmp;
			}
		}

		return dp[n];
	}
}
