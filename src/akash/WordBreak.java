package akash;

import java.util.Arrays;
import java.util.List;

/**
 * Created by akash on 12-10-2017.
 */
public class WordBreak {

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        System.out.println(wb.wordBreakDP("iamace", Arrays.asList("i", "am", "a", "ace")));
    }

    public boolean wordBreakDP(String s, List<String> wordDict) {
        if (s == null || s.isEmpty())
            return true;
        if (s.length() == 1 && wordDict.contains(s)) return true;
        int t[] = new int[s.length() + 1];
        int len = s.length();

        t[0] = 1;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (t[j] == 1 && wordDict.contains(s.substring(j, i))) {
                    t[i] = 1;
                    break;
                }
            }
        }
        return t[len] == 1;
    }

    public boolean wordBreak(String s, List<String> wordDict) {


        int len = s.length();
        int t[][] = new int[len][len];
        for (int row[] : t)
            Arrays.fill(row, 0);

        //consider for each lenght combination from 1 to 6..
        for (int l = 1; l <= len; l++) {

            for (int i = 0; i < len - l + 1; i++) {
                int j = i + l - 1;
                if (wordDict.contains(s.substring(i, j + 1))) {
                    t[i][j] = 1;
                    continue;
                } else {
                    for (int k = i + 1; k <= j; k++) {
                        if (t[i][k - 1] == 1 && t[k][j] == 1) {
                            t[i][j] = 1;
                            break;
                        }
                    }


                }
            }
        }
        return t[0][len - 1] == 1;

    }

    public boolean wordBreakWrong(String s, List<String> wordDict) {

        if (s == null || s.isEmpty())
            return true;
        if (s.length() == 1 && wordDict.contains(s)) return true;

        int j = 0;
        boolean tillPrev = false;
        int len = s.length();
        for (int i = 1; i < len; i++) {
            if (wordDict.contains(s.substring(j, i))) {
                j = i;
                tillPrev = true;
            } else {
                if (i == len - 1) return false;
                System.out.println("not found:" + i + " str" + s.substring(j, i));
            }
        }
        return tillPrev;

    }
}
