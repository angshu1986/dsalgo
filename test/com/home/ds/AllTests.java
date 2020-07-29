package com.home.ds;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.home.ds.linear.ArrayListTest;
import com.home.ds.linear.DoublyLinkedListTest;
import com.home.ds.linear.LinkedListTest;
import com.home.ds.linear.QueueTest;
import com.home.ds.linear.StackTest;
import com.home.ds.tree.BinaryTreeTest;
import com.home.ds.tree.MaxHeapTest;
import com.home.ds.tree.MinHeapTest;

@RunWith(Suite.class)
@SuiteClasses({ LinkedListTest.class, QueueTest.class, StackTest.class, ArrayListTest.class, DoublyLinkedListTest.class,
		BinaryTreeTest.class, MaxHeapTest.class, MinHeapTest.class })
public class AllTests {
	// TODO: test boundary conditions and modify code if necessary for all
}
