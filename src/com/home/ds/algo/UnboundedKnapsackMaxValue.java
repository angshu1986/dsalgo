package com.home.ds.algo;

import java.util.Scanner;
import java.util.stream.Stream;

/**
 * 
 * @author angsh
 *
 */
public class UnboundedKnapsackMaxValue {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = Integer.parseInt(s.nextLine().trim());
		String wtStr = s.nextLine();
		int wt[] = Stream.of(wtStr.split(",")).map(m -> m.trim()).filter(f -> !"".equalsIgnoreCase(f))
				.mapToInt(m -> Integer.parseInt(m)).toArray();
		String costStr = s.next();
		int cost[] = Stream.of(costStr.split(",")).map(m -> m.trim()).filter(f -> !"".equalsIgnoreCase(f))
				.mapToInt(m -> Integer.parseInt(m)).toArray();
		int n = wt.length;
		long dpSt = System.currentTimeMillis();
		int dpRes = unboundedKnapsackDp(wt, cost, n, N);
		long dpEnd = System.currentTimeMillis();
		long dpTime = (dpEnd - dpSt);
		System.out.println(
				"Unbounded knapsack max value dp for weight = " + N + " is " + dpRes + " time taken " + dpTime + " ms");
		long dpSpaceOptSt = System.currentTimeMillis();
		int dpSpaceOptRes = unboundedKnapsackDpSpaceOptimized(wt, cost, n, N);
		long dpSpaceOptEnd = System.currentTimeMillis();
		long dpSpaceOptTime = (dpSpaceOptEnd - dpSpaceOptSt);
		System.out.println("Unbounded knapsack max value dp space optimized for weight = " + N + " is " + dpSpaceOptRes
				+ " time taken " + dpSpaceOptTime + " ms");
		long recSt = System.currentTimeMillis();
		int recRes = unboundedKnapsackRecursive(wt, cost, n, N);
		long recEnd = System.currentTimeMillis();
		long recTime = (recEnd - recSt);
		System.out.println("Unbounded knapsack max value recursive for weight = " + N + " is " + recRes + " time taken "
				+ recTime + " ms");
		s.close();
	}

	private static int unboundedKnapsackDp(int[] wt, int[] cost, int n, int N) {
		if (n == 0 || N == 0)
			return 0;
		int dp[][] = new int[n + 1][N + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= N; j++) {
				if (wt[i - 1] > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					int include = cost[i - 1] + dp[i][j - wt[i - 1]];
					int exclude = dp[i - 1][j];
					dp[i][j] = Math.max(include, exclude);
				}
			}
		}
		return dp[n][N];
	}

	private static int unboundedKnapsackDpSpaceOptimized(int[] wt, int[] cost, int n, int N) {
		if (n == 0 || N == 0)
			return 0;
		int dp[] = new int[N + 1];
		/**
		 * the commented code also does the same, but it checks for each wt from 0 to N
		 * using all cost and wt, while the second method checks for each cost to build
		 * up all wt from 0 to N
		 */

		/*for (int i = 0; i < n; i++) {
			for (int j = wt[i]; j <= N; j++) {
				dp[j] = Math.max(dp[j], cost[i] + dp[j - wt[i]]);
			}
		}*/

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < n; j++) {
				if (wt[j] <= i) {
					dp[i] = Math.max(dp[i], cost[j] + dp[i - wt[j]]);
				} else {
					break;
				}
			}
		}
		return dp[N];
	}

	private static int unboundedKnapsackRecursive(int[] wt, int[] cost, int n, int N) {
		if (n == 0 || N == 0)
			return 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (wt[i] <= N) {
				max = Math.max(max, cost[i] + unboundedKnapsackRecursive(wt, cost, n, N - wt[i]));
			}
		}
		return max;
	}
}
