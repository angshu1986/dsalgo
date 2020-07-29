package com.home.ds.tree;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import com.home.ds.adt.IBinaryTree;
import com.home.ds.adt.List;
import com.home.ds.adt.IQueue;
import com.home.ds.linear.Queue;

public class BinaryTree<T> implements IBinaryTree<T> {

	protected static class Node<E> {
		E data;
		Node<E> left;
		Node<E> right;

		private Node(E data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
		}
	}

	protected Node<T> root;
	private int size;
	
	public BinaryTree(T root) {
		this.root = new Node<T>(root);
		size++;
	}

	@Override
	public void addLeftNode(T node, T nodeToAdd) {
		addLeft(node, nodeToAdd, root);
	}

	private void addLeft(T node, T nodeToAdd, Node<T> nodeC) {
		if (nodeC == null) {
			return;
		}
		if (nodeC.data.equals(node)) {
			if (nodeC.left == null) {
				nodeC.left = new Node<T>(nodeToAdd);
				size++;
				return;
			} else {
				throw new IllegalArgumentException("Left node of " + nodeC.data + " exists as " + nodeC.left.data
						+ ". Unable to add " + nodeToAdd + " to node " + node);
			}
		}
		addLeft(node, nodeToAdd, nodeC.left);
		addLeft(node, nodeToAdd, nodeC.right);
	}

	@Override
	public void addRightNode(T node, T nodeToAdd) {
		addRight(node, nodeToAdd, root);
	}

	private void addRight(T node, T nodeToAdd, Node<T> nodeC) {
		if (nodeC == null) {
			return;
		}
		if (nodeC.data.equals(node)) {
			if (nodeC.right == null) {
				nodeC.right = new Node<T>(nodeToAdd);
				size++;
				return;
			} else {
				throw new IllegalArgumentException("Right node of " + nodeC.data + " exists as " + nodeC.right.data
						+ ". Unable to add " + nodeToAdd + " to node " + node);
			}
		}
		addRight(node, nodeToAdd, nodeC.left);
		addRight(node, nodeToAdd, nodeC.right);
	}

	@Override
	public void removeNode(T t) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isFullTree() {
		return isFullTree(root);
	}

	private boolean isFullTree(Node<T> node) {
		if (node == null) {
			return true;
		}
		if (node.left == null && node.right == null) {
			return true;
		}
		if (node.left != null && node.right == null) {
			return false;
		}
		if (node.left == null && node.right != null) {
			return false;
		}
		return isFullTree(node.left) && isFullTree(node.right);
	}

	@Override
	public boolean isComplete() {
		return isComplete(root, 0);
	}

	private boolean isComplete(Node<T> node, int index) {
		if (node == null) {
			return true;
		}
		if (index >= size) {
			return false;
		}
		return isComplete(node.left, (2 * index) + 1) && isComplete(node.right, 2 * (index + 1));
	}

	@Override
	public boolean isPresent(T t) {
		return isPresent(root, t);
	}

	private boolean isPresent(Node<T> node, T t) {
		if (node == null) {
			return false;
		}
		if (node.data.equals(t)) {
			return true;
		}
		return isPresent(node.left, t) || isPresent(node.right, t);
	}

	@Override
	public boolean isBst(Comparator<T> compare) {
		return checkBst(root, null, null, compare);
	}

	// recursive solution
	private boolean checkBst(Node<T> node, Node<T> left, Node<T> right, Comparator<T> compare) {
		if (node == null) {
			return true;
		}
		if (left != null && compare.compare(node.data, left.data) < 0) {
			return false;
		}
		if (right != null && compare.compare(node.data, right.data) > 0) {
			return false;
		}
		return checkBst(node.left, left, node, compare) && checkBst(node.right, node, right, compare);
	}
	
	/*boolean checkBST(Node<T> root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.data < min || root.data > max) {
            return false;
        }
        return checkBST(root.left, min, root.data - 1) && checkBST(root.right, root.data + 1, max);
    }*/

	@Override
	public int size() {
		return size;
	}

	@Override
	public int runningCount() {
		return runningCount(root);
	}

	private int runningCount(Node<T> node) {
		if (node == null) {
			return 0;
		}
		return runningCount(node.left) + runningCount(node.right) + 1;
	}

	@Override
	public int minDepth() {
		return minDepth(root);
	}

	/**
	 * This method may end up with complete traversal of Binary Tree even when the
	 * topmost leaf is close to root. <br/>
	 * A Better Solution is to do Level Order Traversal. While doing traversal,
	 * returns depth of the first encountered leaf node.
	 * 
	 * @param node
	 * @return
	 */
	private int minDepth(Node<T> node) {
		if (node == null) {
			return 0;
		}
		if (node.left == null && node.right == null) {
			return 1;
		}
		if (node.left == null) {
			return minDepth(node.right) + 1;
		}
		// If right subtree is NULL, recur for left subtree
		if (node.right == null) {
			return minDepth(node.left) + 1;
		}
		int minLeft = minDepth(node.left) + 1;
		int minRight = minDepth(node.right) + 1;
		return Math.min(minLeft, minRight);
	}

	@Override
	public int maxDepth() {
		return maxDepth(root);
	}

	private int maxDepth(Node<T> node) {
		if (node == null) {
			return 0;
		}
		int maxLeft = maxDepth(node.left) + 1;
		int maxRight = maxDepth(node.right) + 1;
		return Math.max(maxLeft, maxRight);
	}

	@Override
	public T minValue(Comparator<T> compare) {
		return minValue(root, compare, null);
	}

	private T minValue(Node<T> node, Comparator<T> compare, T min) {
		if (node == null) {
			return min;
		}
		if (min == null) {
			min = node.data;
		}
		if (compare.compare(node.data, min) < 0) {
			min = node.data;
		}
		T leftMin = minValue(node.left, compare, min);
		T rightMin = minValue(node.right, compare, min);
		if (compare.compare(leftMin, rightMin) < 0) {
			return leftMin;
		} else {
			return rightMin;
		}
	}

	@Override
	public T maxValue(Comparator<T> compare) {
		return maxValue(root, compare, null);
	}

	private T maxValue(Node<T> node, Comparator<T> compare, T max) {
		if (node == null) {
			return max;
		}
		if (max == null) {
			max = node.data;
		}
		if (compare.compare(node.data, max) > 0) {
			max = node.data;
		}
		T leftMax = maxValue(node.left, compare, max);
		T rightMax = maxValue(node.right, compare, max);
		if (compare.compare(leftMax, rightMax) > 0) {
			return leftMax;
		} else {
			return rightMax;
		}
	}

	@Override
	public int diameter() {
		return diameter(root);
	}

	private int diameter(Node<T> node) {
		if (node == null) {
			return 0;
		}
		int leftHeight = maxDepth(root.left);
		int rightHeight = maxDepth(node.right);

		int leftDiameter = diameter(node.left);
		int rightDiameter = diameter(node.right);

		return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
	}

	@Override
	public int getLevel(T t, Comparator<T> compare) {
		return getLevel(root, t, compare);
	}

	private int getLevel(Node<T> node, T t, Comparator<T> compare) {
		if (node == null) {
			return -1;
		}
		if (compare.compare(node.data, t) == 0) {
			return 1;
		}
		IQueue<Node<T>> q = new Queue<>();
		q.offer(node);
		int level = 1;
		int count = 1;
		while (!q.isEmpty()) {
			Node<T> tmp = q.poll();
			if (compare.compare(t, tmp.data) == 0) {
				return level;
			}
			if (tmp.left != null) {
				q.offer(tmp.left);
			}
			if (tmp.right != null) {
				q.offer(tmp.right);
			}
			if (--count == 0) {
				count = q.size();
				level++;
			}
		}
		return 0;
	}

	@Override
	public int distance(T node1, T node2, Comparator<T> compare) {
		/**
		 * distance of node1 from root + distance of node2 from root - 2 * distance of lca from root
		 */
		int node1Distance = getLevel(node1, compare);
		int node2Distance = getLevel(node2, compare);
		T lca = lca(node1, node2, compare);
		int lcaDistance = getLevel(lca, compare);
		return node1Distance + node2Distance - (2 * lcaDistance);
	}
	
	@Override
	public T lca(T node1, T node2, Comparator<T> compare) {
		return lca(root, node1, node2, compare);
	}
	
	private T lca(Node<T> node, T node1, T node2, Comparator<T> compare) {
		if (node == null) {
			return null;
		}
		if (compare.compare(node.data, node1) == 0 || compare.compare(node.data, node2) == 0) {
			return node.data;
		}
		T left = lca(node.left, node1, node2, compare);
		T right = lca(node.right, node1, node2, compare);
		if (left != null && right != null) {
			return node.data;
		}
		return (left != null) ? left : right;
	}

	@Override
	public void printPreOrder() {
		System.out.println("Printing pre order");
		printPreOrder(root);
		System.out.println();
	}

	private void printPreOrder(Node<T> node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		printPreOrder(node.left);
		printPreOrder(node.right);
	}

	@Override
	public void printInOrder() {
		System.out.println("Printing in order");
		printInOrder(root);
		System.out.println();
	}

	private void printInOrder(Node<T> node) {
		if (node == null) {
			return;
		}
		printInOrder(node.left);
		System.out.print(node.data + " ");
		printInOrder(node.right);
	}

	@Override
	public void printPostOrder() {
		System.out.println("Printing post order");
		printPostOrder(root);
		System.out.println();
	}

	private void printPostOrder(Node<T> node) {
		if (node == null) {
			return;
		}
		printPostOrder(node.left);
		printPostOrder(node.right);
		System.out.print(node.data + " ");
	}

	@Override
	public void printLevelOrder() {
		if (root == null) {
			return;
		}
		System.out.println("Printing level order");
		IQueue<Node<T>> q = new Queue<>();
		q.offer(root);
		while (!q.isEmpty()) {
			Node<T> tmp = q.poll();
			System.out.print(tmp.data + " ");
			if (tmp.left != null) {
				q.offer(tmp.left);
			}
			if (tmp.right != null) {
				q.offer(tmp.right);
			}
		}
		System.out.println();
	}

	@Override
	public void printAsTree() {
		
	}

	@Override
	public void printPath(T node1, T node2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void printAllPaths() {
		// TODO Auto-generated method stub

	}

	@Override
	public void printTopView() {
		System.out.println("Printing top view");
		Map<Integer, T> map = new TreeMap<>();
		printTopView(root, 0, map);
		Iterator<T> itr = map.values().iterator();
		StringBuilder sb = new StringBuilder();
		while (itr.hasNext()) {
			sb.append(itr.next() + " ");
		}
		System.out.println(sb.toString().trim());
	}
	
	private void printTopView(Node<T> node, int index, Map<Integer, T> map) {
		if (node == null) return;
		map.putIfAbsent(index, node.data);
		printTopView(node.left, index - 1, map);
		printTopView(node.right, index + 1, map);
	}

	@Override
	public void printZigZag() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<T> flatten() {
		// TODO Auto-generated method stub
		return null;
	}

}
