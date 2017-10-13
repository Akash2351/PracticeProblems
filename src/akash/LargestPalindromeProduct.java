package akash;

/**
 * Created by akash on 11-10-2017.
 */
public class LargestPalindromeProduct {
    public static void main(String[] args) {
        System.out.println(largestPalindrome2(5));
    }

    public static int largestPalindromen(int n) {
        long max = (long) Math.pow(10, n) - 1;
        long min = max / 10;

        for (long h = max; h > min; h--) {
            long left = h, right = 0;
            for (long i = h; i != 0; right = right * 10 + i % 10, i /= 10, left *= 10) ;
            long palindrom = left + right;      // construct the palindrome
            //System.out.println(h+" palin:"+palindrom);

            for (long i = max; i > min; i--) {
                long j = palindrom / i;
                if (j > i || j <= min)
                    break;     // terminate if the other number is greater than current number or is not an n-digit number
                if (palindrom % i == 0) return (int) (palindrom % 1337); // found if current number is a factor
            }
        }


        return 9;    // account for case n = 1
    }

    public static int largestPalindrome2(int n) {
        if (n < 1 || n > 8)
            return 0;
        if (n == 1) return 9;

        long max = (long) Math.pow(10, n) - 1;
        long min = max / 10;

        for (long i = max; i > min; i--) {
            long palin = Long.valueOf(i + new StringBuffer().append(i).reverse().toString());
            //System.out.println(i+" palin:"+palin);

            for (long j = max; j > min; j--) {
                long div = palin / j;
                if (div > j || div < min) break;
                if (palin % j == 0) return (int) (palin % 1337);
            }
        }
        return 0;

    }

    public static int largestPalindrome(int n) {
        if (n < 1 || n > 8)
            return 0;
        long maxNo = (long) Math.pow(10, n) - 1;

        boolean pal = false;
        long curMax = 0;
        for (long i = maxNo; i > 0; i--) {
            for (long j = maxNo; j > 0; j--) {
                long prod = i * j;

                char[] nos = (String.valueOf(prod)).toCharArray();
                int len = nos.length;
                for (int idx = 0; idx < (len / 2); idx++) {
                    if (nos[idx] != nos[len - 1 - idx]) {
                        pal = false;
                        break;
                    }
                    pal = true;
                }
                if (!pal) continue;
                curMax = prod > curMax ? prod : curMax;

            }
        }
        if (curMax == 0) return 0;
        else return (int) curMax % 1337;


    }
}
