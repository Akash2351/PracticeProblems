package akash;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akash on 16-10-2017.
 */
public class MinStackTest {

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());
    }

    static class MinStack {
        List<Integer> list = new ArrayList<>();
        List<Integer> minList = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int size = 0;

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            if (x < min) {
                min = x;
            }
            list.add(x);
            minList.add(min);
            size = list.size();
        }

        public void pop() {
            size -= 1;
            list.remove(size);
            minList.remove(size);
            if (size == 0) {
                min = Integer.MAX_VALUE;
            } else {
                min = minList.get(size - 1);
            }

        }

        public int top() {
            return list.get(size - 1);
        }

        public int getMin() {
            return minList.get(size - 1);
        }
    }

/**
 * Your MinStackTest object will be instantiated and called as such:
 * MinStackTest obj = new MinStackTest();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
