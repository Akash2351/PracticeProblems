/**
 * Akash Anjanappa -Longest Substring palindrome in a string
 * 16 March 2017
 * checkout for video: https://www.youtube.com/watch?v=obBdxeCx_Qs
 * DP
 */
package akash;

public class LongestSubstring {

	public static void main(String[] args) {
		System.out.println("Longest palindrome :" + findPalindrome("BANANAS"));
		//String str = "BANANS";
		//System.out.println(str.substring(2,4));
	}

	// function that returns the longest palindrome substring in the string
	static String findPalindrome(String str) {
		int len = str.length();
		int max_len = 1;
		int palindromeBeginsAt = 0;
		boolean[][] palindrome = new boolean[len][len];

		// for 1 char case
		// diagonal in the matrix
		for (int i = 0; i < len; i++) {
			// Same Char is a palindrome of itself
			palindrome[i][i] = true;
		}

		// for 2 char case
		// check if two adjacent chars are the same. if yes, mark true in table
		for (int i = 0; i < len - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				palindrome[i][i + 1] = true;
				palindromeBeginsAt = i;
				max_len = 2;
			}
		}

		// for 3 chars and above
		// uses the results from previous calculations..
		// finds all palindrome of len 3 and above
		for (int cur_len = 3; cur_len <= len; cur_len++) {
			for (int i = 0; i < len - cur_len + 1; i++) {
				// cal the end index to check.
				int j = i + cur_len - 1;
				// 1-> check if first and last chars are same
				// 2-> check if the remaining, after removing first and last
				// char is palindrome
				if (str.charAt(i) == str.charAt(j) && palindrome[i + 1][j - 1]) {
					palindrome[i][j] = true;
					palindromeBeginsAt = i;
					max_len = cur_len;
				}
			}
		}

		int endIndex = palindromeBeginsAt+max_len;
		return str.substring(palindromeBeginsAt,endIndex );
	}

}
