package akash;

/**
 * Created by akash on 12-10-2017.
 */
public class RomanToInteger {
    String s = "";

    public static void main(String[] args) {
        RomanToInteger roman = new RomanToInteger();
        System.out.println(roman.romanToInt("DCIL"));
    }

    public int getValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }

    public int romanToInt(String s) {
        if (s == null || s.isEmpty())
            return 0;
        int sum = 0;
        char[] chars = s.toCharArray();
        //first value is added to sum
        sum += getValue(chars[0]);
        //check from 2nd roman...see if the prev char is less than current one.
        //if yes, subtract the prev value.
        for (int i = 1; i < chars.length; i++) {

            if (getValue(chars[i - 1]) < getValue(chars[i])) {
                //subtract twice, since its value is added once..
                sum = sum - (2 * getValue(chars[i - 1]));
            }
            //current value is added by default.
            sum += getValue(chars[i]);
        }
        return sum;
    }
}
