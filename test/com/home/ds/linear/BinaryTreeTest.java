package com.home.ds.linear;

import static org.junit.Assert.*;

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
		//t.addRightNode(60, 100);
		t.addLeftNode(20, 45);
		t.addLeftNode(45, 75);
		t.addLeftNode(75, 80);
		System.out.println("Is full: " + t.isFullTree());
		System.out.println("Is complete: " + t.isComplete());
		System.out.println("Size: " + t.size());
		System.out.println("Running count: " + t.runningCount());
		System.out.println("Minimum depth: " + t.minDepth());
		//t.printAsTree();
	}

}
