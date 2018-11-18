package com.home.ds.linear;

import java.util.Comparator;

import org.junit.Test;

import com.home.ds.adt.IBinaryTree;

public class BinaryTreeTest {

	@Test
	public void test() {
		IBinaryTree<Integer> t = new BinaryTree<Integer>(35);
		t.addLeftNode(35, 30);
		t.addRightNode(35, 50);
		t.addLeftNode(30, 15);
		t.addLeftNode(15, 10);
		t.addRightNode(15, 25);
		t.addLeftNode(25, 20);
		t.addRightNode(50, 60);
		t.addRightNode(60, 100);
		t.addLeftNode(50, 45);
		t.addLeftNode(100, 75);
		t.addRightNode(75, 80);
		t.printLevelOrder();
		System.out.println("Is full: " + t.isFullTree());
		System.out.println("Is complete: " + t.isComplete());
		System.out.println("Is BST: " + t.isBst(Comparator.comparingInt(k -> k)));
		System.out.println("Size: " + t.size());
		System.out.println("Diameter: " + t.diameter());
		System.out.println("Running count: " + t.runningCount());
		System.out.println("Minimum depth: " + t.minDepth());
		System.out.println("Maximum depth: " + t.maxDepth());
		System.out.println("Minimum value: " + t.minValue(Comparator.comparingInt(k -> k)));
		System.out.println("Maximum value: " + t.maxValue(Comparator.comparingInt(k -> k)));
		int levelToFind = 100;
		System.out.println("Level of " + levelToFind + " is: " + t.getLevel(levelToFind, Comparator.comparingInt(k -> k)));
		//t.printAsTree();
	}

}
