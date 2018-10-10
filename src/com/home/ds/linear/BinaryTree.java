package com.home.ds.linear;

import java.util.Comparator;

import com.home.ds.adt.IBinaryTree;
import com.home.ds.adt.IList;

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
				throw new IllegalArgumentException("Left node of " + nodeC.data + " exists as " + nodeC.left.data + ". Unable to add " + nodeToAdd + " to node " + node);
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
				throw new IllegalArgumentException("Right node of " + nodeC.data + " exists as " + nodeC.right.data + ". Unable to add " + nodeToAdd + " to node " + node);
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
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
		//TODO: complete this
		return checkBst(node.left, compare) && checkBst(node.right, compare);
		}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int maxDepth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int minValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int maxValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int diameter() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxLevel() {
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
	public int lca(T node1, T node2) {
		// TODO Auto-generated method stub
		return 0;
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
	public void printAsTree() {
		// TODO Auto-generated method stub
		
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
