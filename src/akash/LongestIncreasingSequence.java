/**
 * Akash Anjanappa -Longest increasing sequence
 * 17 March 2017
 * checkout : http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
 * DP
 */

package akash;

import java.util.Arrays;

public class LongestIncreasingSequence {

	public static void main(String[] args) {
		 int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
         int n = arr.length;
         System.out.println("Length of lis is " + lis( arr, n ) + "\n" );

	}
	
	public static int lis(int[] ary,int n){
		int[] lis = new int[n];
		int max = 0;
		
		//fill all the lis with 1.
		Arrays.fill(lis,1);
		
		//for index i, find if any index j (j<i) is less than i and find max of lis[i]
		for(int i=1;i<n;i++){
			for(int j=0;j<n;j++){
				if(ary[i]>ary[j] && lis[i]<lis[j]+1)
					lis[i] = lis[j]+1;
			}
		}
		
		//pick the max of lis..
		for(int i=0;i<n;i++){
			if(max<lis[i])
				max = lis[i];
		}
		
		return max;
	}

}
