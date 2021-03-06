package com.home.ds.algo;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Print all coins that make up a given value, assuming infinite number of coins
 * are present
 * 
 * @author angsh
 *
 */
public class ZeroOneCoinChangeMinCoins {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int val = s.nextInt();
		String in = s.next();
		int coins[] = Stream.of(in.split(",")).map(m -> m.trim()).filter(f -> !"".equalsIgnoreCase(f))
				.mapToInt(m -> Integer.parseInt(m)).toArray();
		long dpSt = System.currentTimeMillis();
		int dpResult = minCoinsDp(coins, val, coins.length);
		long dpEnd = System.currentTimeMillis();
		long dpTime = (dpEnd - dpSt);
		System.out.println("Using dp minimum coins from " + Arrays.toString(coins) + " to make " + val + " value is "
				+ dpResult + " time taken " + dpTime + " ms");
		long dpSOSt = System.currentTimeMillis();
		int dpSOResult = minCoinsDpSpaceOptimized(coins, val, coins.length);
		long dpSOEnd = System.currentTimeMillis();
		long dpSOTime = (dpSOEnd - dpSOSt);
		System.out.println("Using dp space optimized minimum coins from " + Arrays.toString(coins) + " to make " + val
				+ " value is " + dpSOResult + " time taken " + dpSOTime + " ms");
		long recSt = System.currentTimeMillis();
		int recResult = minCoinsRec(coins, val, coins.length - 1);
		long recEnd = System.currentTimeMillis();
		long recTime = (recEnd - recSt);
		System.out.println("Using recursion minimum coins from " + Arrays.toString(coins) + " to make " + val
				+ " value is " + recResult + " time taken " + recTime + " ms");
		s.close();
	}

	private static int minCoinsDp(int[] coins, int val, int n) {
		Arrays.sort(coins);
		int dp[][] = new int[n + 1][val + 1];
		for (int i = 1; i <= val; i++) {
			dp[0][i] = Integer.MAX_VALUE - 1;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= val; j++) {
				if (coins[i - 1] <= j) {
					dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i - 1][j - coins[i - 1]]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][val];
	}

	private static int minCoinsDpSpaceOptimized(int[] coins, int val, int n) {
		Arrays.sort(coins);
		int dp[] = new int[val + 1];
		Arrays.fill(dp, Integer.MAX_VALUE - 1);
		dp[0] = 0;
		for (int i = 0; i < n; i++) {
			for (int j = val; j >= coins[i]; j--) {
				dp[j] = Math.min(dp[j], 1 + dp[j - coins[i]]);
			}
		}
		return dp[val];
	}

	private static int minCoinsRec(int coins[], int val, int n) {
		if (val == 0) {
			return 0;
		}
		if (n < 0)
			return Integer.MAX_VALUE - 1;
		if (coins[n] > val) {
			return minCoinsRec(coins, val, n - 1);
		} else {
			return Math.min(1 + minCoinsRec(coins, val - coins[n], n - 1), minCoinsRec(coins, val, n - 1));
		}
	}
}
