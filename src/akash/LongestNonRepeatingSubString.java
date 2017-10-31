package akash;

import java.util.HashMap;

/**
 * Created by akash on 24-10-2017.
 */
public class LongestNonRepeatingSubString {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int start = 0, max = 0;
        //store each char in map, with its occurence
        HashMap<Character, Integer> map = new HashMap<>();
        char c = 0; //dummy value
        int len = s.length();

        for (int i = 0; i < len; i++) {
            c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) >= start) {
                //if the character is present in map, then that char is repeated..
                // reset the start pointer if its value is greater than current start.
                //check case abba...
                start = map.get(c) + 1;
            }
            map.put(c, i);
            max = (int) Math.max(max, i - start + 1);
        }
        return max;
    }

}
