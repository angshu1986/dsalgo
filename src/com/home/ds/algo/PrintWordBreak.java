package com.home.ds.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
		String sentence = "ilikeicecreamandmango";
		wordBreakBacktracking(sentence, sentence.length(), 0, new StringBuilder());
		System.out.println("******************************************************");
		wordBreakDpPrint(sentence);
		System.out.println("******************************************************");
		wordBreak(sentence, new HashMap<>()).stream().forEachOrdered(System.out::println);
	}

	private static void wordBreakBacktracking(String sentence, int n, int index, StringBuilder wordWithSpace) {
		if (index == n) {
			System.out.println(wordWithSpace.toString());
			return;
		}

		StringBuilder tmp = new StringBuilder();
		for (int i = index; i < n; i++) {
			char alphabet = sentence.charAt(i);
			tmp.append(alphabet);
			if (dict.contains(tmp.toString())) {
				wordWithSpace.append(tmp);
				if (i < n - 1) {
					wordWithSpace.append(" ");
				}
				wordBreakBacktracking(sentence, n, i + 1, wordWithSpace);
				int wordLength = wordWithSpace.length() - tmp.length();
				if (i < n - 1) {
                    wordLength--;
                }
				wordWithSpace.setLength(wordLength);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private static void wordBreakDpPrint(String s) {
		int n = s.length();
		List<String> dp[] = new List[n + 1];
		dp[0] = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				String sub = s.substring(j, i);
				if (dict.contains(sub)) {
					List<String> word = new ArrayList<>();
					if (dp[j] != null) {
						if (dp[j].isEmpty()) {
							word.add(sub);
						} else {
							for (int x = 0; x < dp[j].size(); x++) {
								word.add(dp[j].get(x) + " " + sub);
							}
						}
						if (dp[i] == null) { dp[i] = word; } else { dp[i].addAll(word);}
					}
				}
			}
		}
		if (dp[n] == null) return;
		dp[n].stream().forEachOrdered(System.out::println);
	}
	
	//dfs with memo
	private static List<String> wordBreak(String s, Map<String,List<String>> map) {
        List<String> res = new ArrayList<String>();
        if(s.isEmpty()) {
            return res;
        }
        if(map.containsKey(s)) {
        	return map.get(s);
        }
        if(dict.contains(s)) {
            res.add(s);
        }
        for(int i = 1 ; i < s.length() ; i++) {
            String t = s.substring(i);
            if(dict.contains(t)) {
                List<String> temp = wordBreak(s.substring(0 , i), map);
                if(temp.size() != 0) {
                    for(int j = 0 ; j < temp.size() ; j++) {
                        res.add(temp.get(j) + " " + t);
                    }
                }
            }
        }
        map.put(s , res);
        return res;
    }
}
