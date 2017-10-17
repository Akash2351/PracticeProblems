package akash;

import java.util.Stack;

/**
 * Created by akash on 16-10-2017.
 */
public class ValidParenthesis {

    public static void main(String[] args) {
        System.out.println(isValid("(){[]}"));
    }

    public static boolean isValid(String str) {

        if (str == null || str.isEmpty())
            return false;

        if (str.length() == 1) return false;

        Stack<Character> s = new Stack<>();
        char chars[] = str.toCharArray();

        s.push(chars[0]);

        for (int i = 1; i < chars.length; i++) {
            if (s.size() > 0) {
                char top = (char) s.peek();
                if (chars[i] == ')' && top == '(') {
                    s.pop();
                    continue;
                }
                if (chars[i] == ']' && top == '[') {
                    s.pop();
                    continue;
                }
                if (chars[i] == '}' && top == '{') {
                    s.pop();
                    continue;
                }
            }
            s.push(chars[i]);
        }

        if (s.size() > 0) return false;
        return true;
    }
}
