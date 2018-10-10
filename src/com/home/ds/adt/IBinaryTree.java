package com.home.ds.adt;

import java.util.Comparator;

/**
 * 
 * @author angsh
 *
 * @param <T>
 */
public interface IBinaryTree<T> {
	
	void addLeftNode(T node, T nodeToAdd);
	void addRightNode(T node, T nodeToAdd);
	void removeNode(T t);
	boolean isFullTree();
	boolean isComplete();
	boolean isPresent(T t);
	boolean isBst(Comparator<T> compare);
	int size();
   int minDepth();
	int maxDepth();
	int minValue();
	int maxValue();
	int diameter();
	int getMaxLevel();
	int getLevel(T t);
	int distance(T node1, T node2);
	int lca(T node1, T node2);
	void printPreOrder();
	void printInOrder();
	void printPostOrder();
	void printAsTree();
	void printPath(T node1, T node2);
	void printAllPaths();
	void printTopView();
	void printZigZag();
	IList<T> flatten();
	
}
