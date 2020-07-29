package com.home.ds.algo;

import java.util.HashSet;
import java.util.Set;

public class PrintWordBreak {

	private static final Set<String> dict = new HashSet<String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add("i");
			add("like");
			add("sam");
			add("sung");
			add("samsung");
			add("mobile");
			add("ice");
			add("cream");
			add("icecream");
			add("man");
			add("go");
			add("mango");
			add("and");
		}
	};

	public static void main(String[] args) {
		new PrintWordBreak().wordBreakBacktracking("ilikeicecreamandmango", 0, "");
	}

	private void wordBreakBacktracking(String sentence, int index, String wordWithSpace) {
		if (index == sentence.length()) {
			System.out.println(wordWithSpace.trim());
			return;
		}

		StringBuilder tmp = new StringBuilder();
		for (int i = index; i < sentence.length(); i++) {
			char alphabet = sentence.charAt(i);
			tmp.append(alphabet);
			if (dict.contains(tmp.toString())) {
				wordWithSpace = wordWithSpace.concat(tmp.toString()).concat(" ");
				wordBreakBacktracking(sentence, i + 1, wordWithSpace);
				int wordLength = wordWithSpace.length() - tmp.length() - 1;
				wordWithSpace = wordWithSpace.substring(0, wordLength);
			}
		}
	}
}
