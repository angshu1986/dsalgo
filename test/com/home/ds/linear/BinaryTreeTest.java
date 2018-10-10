package com.home.ds.linear;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Test;

import com.home.ds.adt.IBinaryTree;

public class BinaryTreeTest {

	@Test
	public void test() {
		IBinaryTree<Integer> tree = new BinaryTree<Integer>(35);
		tree.addLeftNode(35, 30);
		tree.addRightNode(35, 50);
		tree.addLeftNode(30, 15);
		tree.addLeftNode(15, 10);
		tree.addRightNode(15, 25);
		tree.addLeftNode(25, 20);
		tree.addLeftNode(50, 60);
		tree.printPostOrder();
		tree.printPreOrder();
		tree.printInOrder();
		System.out.println("Is BST " + tree.isBst(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		}));
	}

}
