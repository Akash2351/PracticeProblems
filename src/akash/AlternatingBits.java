package akash;

/**
 * Created by akash on 14-10-2017.
 */
public class AlternatingBits {

    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(5));
        System.out.println(hasAlternatingBits(11));
    }

    public static boolean hasAlternatingBits(int n) {
        int prev, cur;
        if (n == 0) return true;

        // bitwise and operator...eg if n=5, n & 1 => 101 and 001 => 1
        prev = (n & 1) == 1 ? 1 : 0;
        //right shift the no by 1 bit...
        n = n >> 1;
        while (n > 0) {
            cur = (n & 1) == 1 ? 1 : 0;
            if (prev == cur) return false;
            prev = cur;
            n = n >> 1;
        }
        return true;
    }
}
