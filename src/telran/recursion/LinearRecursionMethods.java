package telran.recursion;

public class LinearRecursionMethods {
    public static int factorial(int n) {
        int res;
        if (n < 0) {
            throw new IllegalArgumentException("n cannot be a negative");
        } else if (n == 0) {
            res = 1;
        } else {
            res = n * factorial(n - 1);
        }
        return res;
    }

    /*
     * a - any integer
     * b - positive integer
     */
    public static int pow1(int a, int b) {
        int res;
        if (b < 0) {
            throw new IllegalArgumentException();
        } else if (b == 0) {
            res = 1;
        } else {
            res = a * pow1(a, b - 1);
        }
        return res;
    }

    /**
     * 
     * @param a - any integer number
     * @param b - positive integer number
     * @return a ^ b
     * no cycles
     * only arithmetic operations +, -
     * additional functions if any with the same limitations
     */
    public static int pow(int a, int b) {
        if (b < 0) {
            throw new IllegalArgumentException("b must be a positive integer");
        }

        int result = 1;
        if (b != 0) {
            result = a * pow(a, b - 1);
        }
        return result;
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
        int res;
        if (index < array.length) {
            res = array[index] + sum(index + 1, array);
        } else {
            res = 0;
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
     * @return x ^ 2
     * no cycles
     * allowed only arithmetic operations +, -
     * no additional functions allowed
     * no static fields
     */
    public static int square(int x) {
        int result = 0;
        int absX = x < 0 ? -x : x;
        for (int i = 0; i < absX; i++) {
            result += absX;
        }
        return result;
    }

    /**
     * 
     * @param str - string
     * @param substr - substring
     * @return true if substr is a substring of a string, false otherwise
     * no cycles
     * allowed only three String methods are charAt(int index);substring(int beginIndex);
     * length()
     */
    public static boolean isSubstring(String str, String substr) {
        boolean result = false;
        if (substr.length() == 0) {
            result = true;
        } else if (str.length() >= substr.length()) {
            result = true;
            for (int i = 0; i < substr.length(); i++) {
                if (str.charAt(i) != substr.charAt(i)) {
                    result = false;
                    break;
                }
            }
            if (!result) {
                result = isSubstring(str.substring(1), substr);
            }
        }
        return result;
    }

}
