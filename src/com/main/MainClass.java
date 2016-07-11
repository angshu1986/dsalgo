package com.main;

import java.util.Random;

import com.home.ds.Queue;
import com.home.ds.Stack;

public class MainClass {

	//static initializers
	private static final Random r = new Random();
	
	public static void main(String[] args) {
		testQueue();
		//testStack();
	}
	
	private static void testQueue() {
		Queue<Integer> q = new Queue<>();
		for (int i = 0; i < 10; i++) {
			int x = getRandomInteger(50, 500);
			System.out.println("Adding " + x);
			q.enq(x);
		}
		System.out.println(q.toString());
	}
	
	private static void testStack() {
		Stack<Integer> s = new Stack<>();
		System.out.println("Is empty stack : " + s.isEmpty());
		for (int i = 0;i<10;i++) {
			int x = getRandomInteger(10, 90);
			System.out.println("Adding " + x);
			s.push(x);
		}
		System.out.println("Is empty stack : " + s.isEmpty());
		System.out.println("Size " + s.size());
		System.out.println("Stack now " + s.toString());
		System.out.println("Popped " + s.pop());
		System.out.println("Popped " + s.pop());
		System.out.println("Popped " + s.pop());
		System.out.println("Stack now " + s.toString());
		System.out.println("Top now " + s.top());
		s.push(50);
		s.push(78);
		int size = s.size();
		System.out.println("Size " + s.size());
		System.out.println("Stack now " + s.toString());
		System.out.println("Popping all to check isEmpty()");
		for (int i=0;i<size;i++) {
			System.out.println("Popped " + s.pop());
		}
		System.out.println("Is empty stack now : " + s.isEmpty());
	}
	
	private static int getRandomInteger(int lower, int higher) {
		return r.nextInt(higher - lower + 1) + lower;
	}

}
