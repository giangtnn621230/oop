import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adajcent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        int maxRun = 1;
        int currentRun = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                currentRun++;
                if (currentRun > maxRun) {
                    maxRun = currentRun;
                }
            } else {
                currentRun = 1;
            }
        }

        return maxRun;
	}

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                int count = c - '0';
                if (i + 1 < str.length()) {
                    char nextChar = str.charAt(i + 1);
                    for (int j = 0; j < count; j++) {
                        result.append(nextChar);
                    }
                }
            } else {
                result.append(c);
            }
        }

        return result.toString();
	}
	
	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
        if (a == null || b == null || len <= 0) {
            return false;
        }
        if (a.length() < len || b.length() < len) {
            return false;
        }

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i <= a.length() - len; i++) {
            set.add(a.substring(i, i + len));
        }

        for (int j = 0; j <= b.length() - len; j++) {
            if (set.contains(b.substring(j, j + len))) {
                return true;
            }
        }

		return false; // YOUR CODE HERE
	}
}
