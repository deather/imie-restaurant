package com;

import java.util.Arrays;
import java.util.List;

public class Fibonacci {
	public static void main(String[] args) {
		List<Integer> ns = Arrays.asList(0, 1, 15, 23);

		for (Integer n : ns)
			System.out.println(n + " : " + fibonnaci(n));
	}

	public static int fibonnaci(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;

		return fibonnaci(n-1) + fibonnaci(n-2);
	}
}
