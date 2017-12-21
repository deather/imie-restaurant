package com;

import java.util.Arrays;
import java.util.List;

public class Bissextile {

	public static void main(String[] args) {
		List<Integer> années = Arrays.asList(
				2017, 2008, 2000, 1900
		);

		for(Integer année: années) {
			System.out.print(année);

			if (isBissextile(année))
				System.out.println(" est bissextile");
			else
				System.out.println(" est pas bissextile");
		}
	}

	public static boolean isBissextile(int année) {
		if ((année % 4 == 0 && année % 100 != 0) || année % 400 == 0)
			return true;

		return false;
	}
}
