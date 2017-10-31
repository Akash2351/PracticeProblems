/**
 * Created by Chiru on Jan 3, 2017
 */
package sorting;

public class MergeSort {

	public static void main(String[] args) {

		int[] arr = {33, 55, 44, 11, 10, 56, 22, 1, 2, 3, 80, 90, 100};

		mergeSort(0, arr.length - 1, arr);

		for (int ele : arr)
			System.out.println(ele);

	}

	public static void mergeSort(int low, int high, int[] arr) {

		if (low < high) {

			int mid = (low + high) / 2;

			mergeSort(low, mid, arr);
			mergeSort(mid + 1, high, arr);

			merge(low, mid, high, arr);
		}
	}

	public static void merge(int low, int mid, int high, int[] arr) {
		int[] tempArr = new int[high + 1];

		for (int i = 0; i < high + 1; i++) {
			tempArr[i] = arr[i];
		}

		int i = low;
		int j = mid + 1;
		int k = low; // track sorted array

		while (i <= mid && j <= high) {
			if (tempArr[i] <= tempArr[j]) {
				arr[k] = tempArr[i];
				i++;
			} else {
				arr[k] = tempArr[j];
				j++;
			}
			k++;
		}

		while (i <= mid) {
			arr[k] = tempArr[i];
			k++;
			i++;
		}
	}
}