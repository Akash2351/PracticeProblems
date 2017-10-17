package akash;

/**
 * Created by akash on 16-10-2017.
 */
public class MaximumSubArray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public static int maxSubArray(int[] nums) {
        int sumSoFar = nums[0], sumEndingHere = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //maximum sum at ith position is, max+num[i] or num[i]...take max of them
            sumEndingHere = Math.max(sumEndingHere + nums[i], nums[i]);
            //take the max of sumSoFar and sumEndingHere...
            sumSoFar = Math.max(sumSoFar, sumEndingHere);
        }
        return sumSoFar;
    }
}
