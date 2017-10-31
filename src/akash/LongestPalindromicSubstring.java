package akash;

/**
 * Created by akash on 26-10-2017.
 */
public class LongestPalindromicSubstring {

    static int low, curMax;

    public static void main(String[] args) {
        System.out.println(longestPalindrome("bananas"));
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (s == null || s.isEmpty())
            return null;
        if (s.length() == 1)
            return s;
        for (int i = 0; i < len; i++) {
            extendPalindrome(s, i, i); //check for odd palindromes starting from i
            extendPalindrome(s, i, i + 1); // check for even palindromes
        }
        return s.substring(low, low + curMax);
    }

    //extend palindrome around its centre...
    static void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (curMax < right - left - 1) {
            low = left + 1;
            curMax = right - left - 1;
        }
    }
}
