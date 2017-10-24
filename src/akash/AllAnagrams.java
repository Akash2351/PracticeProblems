package akash;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akash on 18-10-2017.
 */
public class AllAnagrams {

    public static void main(String[] args) {
        AllAnagrams ana = new AllAnagrams();
        System.out.println(ana.findAnagrams("abab", "ab"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null) return list;
        int strLen = s.length();
        int pLen = p.length();
        //sliding window... slide for pattern length each iteration
        for (int i = 0; i < strLen; i++) {
            if (i + pLen > strLen) break;
            if (isAnagram(s.substring(i, i + pLen), p))
                list.add(i);
        }
        return list;
    }

    //function to check if two strings are anagrams or not...
    boolean isAnagram(String s1, String s2) {
        // count the chars in first string and verify with second
        int dict[] = new int[26];
        if (s1 == null || s2 == null || s1.length() != s2.length()) return false;

        for (char c : s1.toCharArray()) {
            dict[c - 'a']++;
        }
        for (char c : s2.toCharArray()) {
            dict[c - 'a']--;
            if (dict[c - 'a'] < 0) return false;
        }
        return true;
    }
}
