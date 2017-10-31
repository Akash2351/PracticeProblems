package akash;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akash on 25-10-2017.
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        GenerateParenthesis gp = new GenerateParenthesis();
        System.out.println(gp.generateParenthesis(3));
        System.out.println(gp.generateParenthesis(2));
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateRecursive("", n, n, list);
        return list;
    }

    public void generateRecursive(String cur, int leftRemaining, int rightRemaining, List<String> list) {
        if (leftRemaining == 0 && rightRemaining == 0) {
            list.add(cur);
            return;
        }

        if (leftRemaining > 0) {
            generateRecursive(cur + "(", leftRemaining - 1, rightRemaining, list);
            //possible combinations when left < right...valid case
            if (leftRemaining < rightRemaining) {
                generateRecursive(cur + ")", leftRemaining, rightRemaining - 1, list);
            }
        } else {
            generateRecursive(cur + ")", leftRemaining, rightRemaining - 1, list);
        }
    }
}
