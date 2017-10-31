package akash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by akash on 27-10-2017.
 */
public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        //sort the elements, pick element at once,
        //have 2 pointers -> run from both ends... compare the sum with target and
        // manipulate the left and right pointers.
        Arrays.sort(nums);
        int len = nums.length;
        int target = 0;

        for (int i = 0; i < len; i++) {
            //eliminate duplicates by comparing adjacent elements.
            if (i == 0 || nums[i] != nums[i - 1]) {
                int left = i + 1, right = len - 1;
                while (left < right) {
                    int tempSum = nums[i] + nums[left] + nums[right];
                    if (tempSum == target) {
                        list.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                        left++;
                        right--;
                        //skip duplicate elements...
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    } else if (tempSum < target) {
                        //num array is sorted...so moving right will increase sum..
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return list;
    }


}
