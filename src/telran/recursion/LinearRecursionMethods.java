package telran.recursion;

public class LinearRecursionMethods {
	public static int factorial(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("n cannot be a negative");
		}
		int res = 1;
		if (n != 0) {
			res = n * factorial(n - 1);
		}
		return res;

	}

	/*
	 * a - any integer b - positive integer
	 */
	public static int pow1(int a, int b) {
		if (b < 0) {
			throw new IllegalArgumentException();
		}
		int res = 1;
		if (b != 0) {
			res = a * pow1(a, b - 1);
		}
		return res;
	}

	/**
	 * 
	 * @param num - any integer number
	 * @param extent - positive integer number
	 * @return num ^ extent
	 *  no cycles
	 *  only arithmetic operations +, -
	 *  additional functions if any with the same limitations
	 */
	public static int pow(int num, int extent) {
		if (extent < 0) {
			throw new IllegalArgumentException();
		}
		int res = 1;
		if (extent > 0) {
			res = multiply(num, pow(num, extent - 1));
		}
		return res;
	}
/**
 * 
 * @param a - any number
 * @param b - any number
 * @return a * b with the limitations defined in the method pow
 */
	private static int multiply(int a, int b) {
		int res = 0;
		if (b < 0) {
			//updating sign at both factors doesn't impact a multiplication result
			a = -a;
			b = -b;
		}
		res = multiplyNoSignCheck(a, b);
		return res;
	}
/**
 * 
 * @param a - any number
 * @param b - any positive number
 * @return
 */
	private static int multiplyNoSignCheck(int a, int b) {
		return b == 0 ? 0 : a + multiplyNoSignCheck(a, b - 1);
	}

	public static void displayArray(int[] array) {
		displayArray(0, array, false);
	}

	public static void displayArrayReversed(int[] array) {
		displayArray(0, array, true);
	}

	private static void displayArray(int index, int[] array, boolean isReversed) {
		if (index < array.length) {
			if (isReversed) {
				displayArray(index + 1, array, isReversed);
				System.out.print(array[index] + " ");
			} else {
				System.out.print(array[index] + " ");
				displayArray(index + 1, array, isReversed);
			}
		}

	}

	public static int sum(int[] array) {
		return sum(0, array);
	}

	private static int sum(int index, int[] array) {
		int res = 0;
		if (index < array.length) {
			res = array[index] + sum(index + 1, array);
		}
		return res;
	}

	public static void reverse(int[] array) {
		reverse(0, array.length - 1, array);
	}

	private static void reverse(int left, int right, int[] array) {
		if (left < right) {
			int tmp = array[left];
			array[left] = array[right];
			array[right] = tmp;
			reverse(left + 1, right - 1, array);
		}

	}

	/**
	 * 
	 * @param x - any integer number
	 * @return x ^ 2 no cycles allowed only arithmetic operations +, - no additional
	 *         functions allowed no static fields
	 */
	public static int square(int x) {
		//x ^ 2 = (x - 1)^2 + 2x - 1 - recursive formula
		int res = 0; 
		if(x != 0) {
			res = x < 0 ? square(-x) : x + x - 1 + square(x - 1);
		}
		return res;
	}

	/**
	 * 
	 * @param str    - string
	 * @param substr - substring
	 * @return true if substr is a substring of a string, false otherwise
	 *  no cycles
	 *  allowed only three String methods are charAt(int index);substring(int beginIndex);
	 *   length()
	 */
	public static boolean isSubstring(String str, String substr) {

		boolean res = false;
		if (str.length() >= substr.length()) {
			res = isSubstringAtFirstPart(str, substr) ? 
					true : isSubstring(str.substring(1), substr);
		} 

		return res;

	}

	private static boolean isSubstringAtFirstPart(String str, String substr) {
		boolean res = false;
		if (substr.length() == 0) {
			res = true;
		} else if (str.charAt(0) == substr.charAt(0)) {
			res = isSubstringAtFirstPart(str.substring(1), substr.substring(1));
		}
		
		return res;
	}
}