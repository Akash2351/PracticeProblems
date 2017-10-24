package akash;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akash on 18-10-2017.
 */
public class FindMissingNos {
    //Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 1)
            return list;

        // the nos in the given array range from 1 to n...so indices are -l less...0 to n-1
        // for every no found, mark it negative in the same array for indices...
        for (int i = 0; i < nums.length; i++) {
            int index = (int) Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        //see if any no is positive...that means, it was not visited first...that is a missing no
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                list.add(i + 1);
        }
        return list;
    }
}
