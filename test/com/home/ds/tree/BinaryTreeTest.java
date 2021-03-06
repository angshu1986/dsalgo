package com.home.ds.tree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Comparator;

import org.junit.Test;

import com.home.ds.adt.IBinaryTree;
import com.home.ds.tree.BinaryTree;
import com.home.ds.tree.IntegerBinaryTree;
/**
 * 				35
 * 			   /  \
 * 			  30  50
 * 			 /	 /	\
 * 			15	45   60
 * 		   /  \		  \
 * 		  10  25	  100
 * 			 /		  /
 * 			20		 75
 * 					  \
 * 					  80
 * @author angsh
 *
 */
public class BinaryTreeTest {

	@Test
	public void test() {
		Comparator<Integer> compare = Comparator.comparingInt(k -> k);
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
		assertFalse("Is full: ", t.isFullTree());
		assertFalse("Is complete: ", t.isComplete());
		assertTrue("Is BST: ", t.isBst(compare));
		assertEquals("Size", 12, t.size());
		assertEquals("Diameter", 10, t.diameter());
		assertEquals("Running Count", 12, t.runningCount());
		assertEquals("Minimum depth: ", 3, t.minDepth());
		assertEquals("Maximum depth: ", 6, t.maxDepth());
		assertEquals("Minimum value: ", 10, t.minValue(compare).intValue());
		assertEquals("Maximum value: ", 100, t.maxValue(compare).intValue());
		int levelToFind = 100;
		assertEquals("Level of " + levelToFind + ": ", 4, t.getLevel(levelToFind, compare));
		assertEquals("LCA", 50, t.lca(45, 100, compare).intValue());
		assertEquals("Distance between two nodes", 6, t.distance(25, 100, compare));
		//t.printAsTree();
		
		IntegerBinaryTree intTree = new IntegerBinaryTree(35);
		intTree.addLeftNode(35, 30);
		intTree.addRightNode(35, 50);
		intTree.addLeftNode(30, 15);
		intTree.addLeftNode(15, 10);
		intTree.addRightNode(15, 25);
		intTree.addLeftNode(25, 20);
		intTree.addRightNode(50, 60);
		intTree.addRightNode(60, 100);
		intTree.addLeftNode(50, 45);
		intTree.addLeftNode(100, 75);
		intTree.addRightNode(75, 80);
		intTree.printLevelOrder();
		intTree.printTopView();
		System.out.println(intTree.getMaxSum());
	}

}
