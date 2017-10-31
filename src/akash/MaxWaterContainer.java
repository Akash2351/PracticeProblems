package akash;

/**
 * Created by akash on 27-10-2017.
 */
public class MaxWaterContainer {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public static int maxArea(int[] height) {
        int max = 0, left = 0, right = height.length - 1;

        if (height == null || height.length < 2)
            return max;
        //traverse from outermost container, moving left or right wall accordingly
        while (left < right) {
            //area = width * height..
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return max;
    }
}
