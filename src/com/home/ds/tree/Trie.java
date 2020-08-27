package com.home.ds.tree;

import java.util.HashMap;
import java.util.Map;

import com.home.ds.adt.List;
import com.home.ds.linear.ArrayList;

public class Trie {
	//TODO: write test case
	public static void main(String[] args) {
		Trie t = new Trie();
		t.insert("how to train your dragon");
		t.insert("when is new year");
		t.insert("how to catch a train");
		t.insert("how to drive a car");
		t.insert("when is christmas");
		t.insert("when is diwali");
		t.insert("what is diwali");
		t.insert("what is a computer");
		t.insert("when is diwali");
		System.out.println("Auto complete: " + t.autoComplete("wha"));
	}

	private static class Node {
		private Map<Character, Node> map;
		private boolean isCompleteWord;

		private Node() {
			// use hashmap for any order, or use treemap for ordered nodes
			this.map = new HashMap<>();
		}
	}

	private Node root;

	public void insert(String str) {
		if (str == null || str.isEmpty()) {
			return;
		}
		if (root == null) {
			root = new Node();
		}
		Node curr = root;
		for (Character ch : str.toCharArray()) {
			curr.map.putIfAbsent(ch, new Node());
			curr = curr.map.get(ch);
		}
		curr.isCompleteWord = true;
	}

	public boolean search(String str) {
		if (str != null && !str.isEmpty() && root != null) {
			Node curr = root;
			for (Character ch : str.toCharArray()) {
				if (!curr.map.containsKey(ch)) {
					return false;
				}
				curr = curr.map.get(ch);
			}
			return curr.isCompleteWord;
		}
		return false;
	}

	public List<String> autoComplete(String prefix) {
		List<String> result = new ArrayList<>();
		if (root != null && prefix != null && !prefix.isEmpty()) {
			Node curr = root;
			char prefixArr[] = prefix.toCharArray();
			int matchCount = 0;
			for (Character ch : prefixArr) {
				if (curr.map.containsKey(ch)) {
					matchCount++;
					curr = curr.map.get(ch);
				}
			}
			if (matchCount == prefixArr.length) {
				autoComplete(new StringBuilder(prefix), curr, result);
			}
		}
		return result;
	}

	private void autoComplete(StringBuilder wordFormed, Node node, List<String> result) {
		if (node == null) {
			return;
		}
		if (node.isCompleteWord) {
			result.add(wordFormed.toString());
		}
		for (Map.Entry<Character, Node> entry : node.map.entrySet()) {
			char ch = entry.getKey();
			wordFormed.append(ch);
			Node thisNode = entry.getValue();
			autoComplete(wordFormed, thisNode, result);
			wordFormed.setLength(wordFormed.length() - 1);
		}
	}
	
	public List<String> getAllWords() {
		List<String> result = new ArrayList<>();
		autoComplete(new StringBuilder(), root, result);
		return result;
	}
	//TODO
	public void delete(String prefix) {
		
	}
}
