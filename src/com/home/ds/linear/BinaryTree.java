package com.home.ds.linear;

import java.util.Comparator;
import java.util.List;

import com.home.ds.adt.IBinaryTree;
import com.home.ds.adt.IList;
import com.home.ds.adt.IQueue;

public class BinaryTree<T> implements IBinaryTree<T> {

	private static class Node<E> {
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

	private Node<T> root;
	private int size;
	private int level;

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
		return checkBst(root, compare);
	}

	private boolean checkBst(Node<T> node, Comparator<T> compare) {
		if (node == null) {
			return true;
		}
		// TODO: complete this
		return checkBst(node.left, compare) && checkBst(node.right, compare);
	}

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
	public T minValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T maxValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int diameter() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLevel(T t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int distance(T node1, T node2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T lca(T node1, T node2) {
		// TODO Auto-generated method stub
		return null;
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
		IQueue<HorizontalDistancePair<T>> q = new Queue<>();
		List<HorizontalDistancePair<T>> l = new java.util.ArrayList<>();
		HorizontalDistancePair<T> p = new HorizontalDistancePair<>(0, root);
		l.add(p);
		q.offer(p);
		while (!q.isEmpty()) {
			HorizontalDistancePair<T> tmp = q.poll();
			if (tmp.node.left != null) {
				HorizontalDistancePair<T> left = new HorizontalDistancePair<>(tmp.hd - 1, tmp.node.left);
				q.offer(left);
				l.add(left);
			}
			if (tmp.node.right != null) {
				HorizontalDistancePair<T> left = new HorizontalDistancePair<>(tmp.hd + 1, tmp.node.right);
				q.offer(left);
				l.add(left);
			}
		}
		System.out.println(l);
		int tabCount = Math.abs(l.stream().mapToInt(m -> m.hd).min().getAsInt());
		System.out.println("Starting tab count: " + tabCount);
		IQueue<Node<T>> q2 = new Queue<>();
		q2.offer(root);
		int leftTabCount = tabCount - 1;
		int rightTabCount = tabCount + 1;
		int x = -1;
		while (!q2.isEmpty()) {
			Node<T> tmp = q2.poll();
			for (int i = 0; i < tabCount; i++) {
				System.out.print("    ");
			}
			System.out.print(tmp.data);
			if (tmp.left != null || tmp.right != null) {
				System.out.println();
				x++;
			}
			if (tmp.left != null) {
				leftTabCount = tabCount + x - 1;
				q2.offer(tmp.left);
				for (int i = 0; i < leftTabCount; i++) {
					System.out.print("    ");
				}
				System.out.print("/");
			}
			if (tmp.right != null) {
				rightTabCount = tabCount + x + 1;
				q2.offer(tmp.right);
				for (int i = 0; i < rightTabCount; i++) {
					System.out.print("    ");
				}
				System.out.print("\\");
			}
			if (tmp.left != null || tmp.right != null) {
				System.out.println();
			}
		}
	}

	private static class HorizontalDistancePair<N> {
		int hd;
		Node<N> node;

		private HorizontalDistancePair(int hd, Node<N> node) {
			this.hd = hd;
			this.node = node;
		}

		@Override
		public String toString() {
			return "[hd=" + hd + ", node=" + node.data + "]";
		}
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
		// TODO Auto-generated method stub

	}

	@Override
	public void printZigZag() {
		// TODO Auto-generated method stub

	}

	@Override
	public IList<T> flatten() {
		// TODO Auto-generated method stub
		return null;
	}

}
