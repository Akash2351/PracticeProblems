package akash;

import java.util.HashSet;

/**
 * Created by akash on 12-10-2017.
 */
public class DuplicateElement {

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));
    }

    public static boolean containsDuplicate(int[] nums) {

        if (nums == null || nums.length == 0)
            return false;

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            else set.add(nums[i]);
        }
        return false;

    }

}
