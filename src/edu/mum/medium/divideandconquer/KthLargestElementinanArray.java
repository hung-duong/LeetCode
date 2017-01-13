package edu.mum.medium.divideandconquer;

/**
 * Created by hungduong on 1/6/17.
 */
public class KthLargestElementinanArray {
    //Use HeapSort
    public static int findKthLargest(int[] nums, int k) {
        int heapsize = nums.length;

        // Build heap (rearrange array)
        // Max-Heap
        for(int i = heapsize/2 - 1; i >= 0; i--) {
            heapify(nums, heapsize, i);
        }

        // One by one extract an element from heap
        for(int i = heapsize - 1; i >= heapsize - k + 1; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            // call max heapify on the reduced heap
            heapify(nums, i, 0);
        }

        return nums[0];
    }

    public static int findKthLargestDistinct(int[] nums, int k) {
        int heapsize = nums.length;

        // Build heap (rearrange array)
        // Max-Heap
        for(int i = heapsize/2 - 1; i >= 0; i--) {
            heapify(nums, heapsize, i);
        }

        // One by one extract an element from heap
        int temp;
        int i = heapsize - 1;
        while(i >= heapsize - k + 1) {
            temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            // call max heapify on the reduced heap
            heapify(nums, i, 0);

            if(nums[0] == temp) k++;

            i--;
        }

        return nums[0];
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        // If left child is larger than root
        if(l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        // If right child is larger than largest so far
        if(r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        // If largest is not root
        if(largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }

    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4, 4, 4, 4, 4, 6, 6, 6, 6, 6, 5};

        System.out.print(findKthLargestDistinct(nums, 4));
    }
}
