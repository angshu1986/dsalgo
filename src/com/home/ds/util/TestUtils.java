package com.home.ds.util;

import java.util.Random;

public class TestUtils {
	// static initializers
	private static final Random r = new Random();

	public static int getRandomInteger(int lower, int higher) {
		return r.nextInt(higher - lower + 1) + lower;
	}
}
