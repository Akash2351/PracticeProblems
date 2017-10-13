package akash;

import java.util.HashMap;

/**
 * Created by akash on 12-10-2017.
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] out = twoSum(new int[]{2, 9, 13, 5, 4}, 11);
        System.out.println(out[0] + "," + out[1]);
    }

    public static int[] twoSum(int[] nums, int target) {

        if (nums == null || nums.length < 2)
            return new int[]{0, 0};

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            } else {
                map.put(target - nums[i], i);
            }
        }
        return new int[]{0, 0};

    }
}
