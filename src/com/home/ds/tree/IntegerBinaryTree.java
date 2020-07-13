package com.home.ds.tree;

import java.util.Comparator;

public class IntegerBinaryTree extends BinaryTree<Integer> {
	
	private static final Comparator<Integer> compare = Comparator.comparingInt(k -> k);

	public IntegerBinaryTree(Integer root) {
		super(root);
	}

	public boolean isBst() {
		return super.isBst(compare);
	}

	public Integer minValue() {
		return super.minValue(compare);
	}

	public Integer maxValue() {
		return super.maxValue(compare);
	}

	public int getLevel(Integer t) {
		return super.getLevel(t, compare);
	}

	public int distance(Integer node1, Integer node2) {
		return super.distance(node1, node2, compare);
	}

	public Integer lca(Integer node1, Integer node2) {
		return super.lca(node1, node2, compare);
	}

	public int getMaxSum() {
		//we need some object reference that can be used in recursion, instead of using primitive integer
		int []max = {Integer.MIN_VALUE};
		getMaxSum(root, max);
		return max[0];
	}
	
	public int getMaxSum(Node<Integer> node, int[] max) {
		if (node == null)
			return 0;
		if (node.left == null && node.right == null) {
			return node.data;
		}
		int left = getMaxSum(node.left, max);
		int right = getMaxSum(node.right, max);
		int current = Math.max(node.data, Math.max(node.data + left, node.data + right));
	 
		max[0] = Math.max(max[0], Math.max(current, left + node.data + right));
		return current;
	}	
}
