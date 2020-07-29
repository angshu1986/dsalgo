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
	int runningCount();
	int minDepth();
	int maxDepth();
	T minValue(Comparator<T> compare);
	T maxValue(Comparator<T> compare);
	int diameter();
	int getLevel(T t, Comparator<T> compare);
	int distance(T node1, T node2, Comparator<T> compare);
	T lca(T node1, T node2, Comparator<T> compare);
	void printPreOrder();
	void printInOrder();
	void printPostOrder();
	void printLevelOrder();
	void printAsTree();
	void printPath(T node1, T node2);
	void printAllPaths();
	void printTopView();
	void printZigZag();
	List<T> flatten();
	
}
