package com.home.ds.algo;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * @author angsh
 *
 */
public class WordBreakPossibility {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String in = s.nextLine();
		Set<String> dict = Stream.of(in.split(",")).map(m -> m.trim()).filter(f -> !"".equalsIgnoreCase(f))
				.collect(Collectors.toSet());
		String sentence = s.next().trim();
		long dpSt = System.currentTimeMillis();
		boolean dpRes = wordBreakDp(dict, sentence);
		long dpEnd = System.currentTimeMillis();
		long dpTime = (dpEnd - dpSt);
		System.out.println("Word break possibility dp solution for string = " + sentence + " looking up in dictonairy "
				+ dict + " is " + dpRes + " time taken " + dpTime + " ms");
		long recSt = System.currentTimeMillis();
		boolean recRes = wordBreakRecursive(dict, sentence);
		long recEnd = System.currentTimeMillis();
		long recTime = (recEnd - recSt);
		System.out.println("Word break possibility recursive for string = " + sentence + " looking up in dictonairy "
				+ dict + " is " + recRes + " time taken " + recTime + " ms");
		s.close();
	}

	private static boolean wordBreakDp(Set<String> dict, String s) {
		int n = s.length();
		boolean dp[] = new boolean[n + 1];
		dp[0] = true;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && dict.contains(s.substring(j, i))) {
					dp[i] = true;
				}
			}
		}
		return dp[n];
	}

	// store prefix for memo/dp
	private static boolean wordBreakRecursive(Set<String> dict, String s) {
		if (s.isEmpty()) {
			return true;
		}
		for (int i = 1; i <= s.length(); i++) {
			String prefix = s.substring(0, i);
			String suffix = s.substring(i, s.length());
			if (dict.contains(prefix) && wordBreakRecursive(dict, suffix)) {
				return true;
			}
		}
		return false;
	}
}
