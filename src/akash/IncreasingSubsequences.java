package akash;

import java.util.*;

/**
 * Created by akash on 15-10-2017.
 */
public class IncreasingSubsequences {

    public static void main(String[] args) {
        System.out.println(getSubsequences(new int[]{4, 6, 7, 7}));
    }

    public static List<List<Integer>> getSubsequences(int nums[]) {
        //input [4,6,7,7] = > op:[[7, 7], [6, 7], [4, 6], [4, 7, 7], [4, 6, 7, 7], [4, 7], [4, 6, 7], [6, 7, 7]]
        Set<List<Integer>> results = new HashSet<List<Integer>>();
        Set<List<Integer>> subResults = new HashSet<List<Integer>>();
        for (int num : nums) {
            for (List<Integer> l : subResults) {
                //check if the last element in list is greater than current element, if not,
                // add current element and make a new list.
                if ((l.get(l.size() - 1) > num)) continue;
                List<Integer> copy = new ArrayList<Integer>(l);
                copy.add(num);
                results.add(copy);
            }
            //add each num as an arraylist .. so next time in loop, we build on this list.
            subResults.add(Arrays.asList(num));
            // add the lists so far, so that these lists will also be extended
            subResults.addAll(results);
        }
        return new LinkedList(results);
    }
}
