/**
 * Akash Anjanappa -Heap sort
 * 17 March 2017
 * checkout :http://quiz.geeksforgeeks.org/heap-sort/
 */

package akash;

public class HeapSort {


    // Ascending sort algorithm..uses maxHeap
    public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 6, 7};

        HeapSort ob = new HeapSort();
        ob.sort(arr);
 
        System.out.println("Sorted array is");
        printArray(arr);
    }
	
    //function that sorts the array in ascending order using maxheap.
	void sort(int[] arr){
		int n = arr.length;
		
		//build the heap from bottom up first.  
		//go to the last parent in the tree and build from there.
		for(int i=n/2-1; i>=0;i--)
			heapify(arr,n,i);
		
		//once max heap is found, swap the arr[0] with the last element. 
		//now again heapify the arr excluding the last element..continue this process
		for(int i=n-1;i>=0;i--){
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			//heapify the 0th position 
			heapify(arr,i,0);
		}
	}

	//maxheap
	//To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
	void heapify(int[] arr,int n,int i){
		
		int largest = i;
		int left = 2*i+1;  //left child
		int right = 2*i+2;  //right child
		
		//check if parent is the largest, else swap
		if(left<n && arr[left]> arr[largest])
			largest = left;
		if(right<n && arr[right]>arr[largest])
			largest = right;
		
		//see if the swap needs to be done
		if(largest != i){
			int swap = arr[largest];
			arr[largest] = arr[i];
			arr[i] = swap;
			
			//now heapify the swapped position recursively
			heapify(arr,n,largest);
		}
	}
	
	 /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
 
}
