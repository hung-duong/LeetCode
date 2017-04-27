package edu.mum.medium;

/**
 * Created by hungduong on 3/2/17.
 * http://www.geeksforgeeks.org/counting-inversions/
 */
public class CountInversionPairs {
    public static int mergeSort(int[] arr, int left, int right) {
        int inv_count = 0;

        if(left >= right) {
            return inv_count;
        } else {
            int mid = (left + right)/2;
            inv_count = mergeSort(arr, left, mid);
            inv_count += mergeSort(arr, mid + 1, right);

            inv_count += merge(arr, left, mid, right);
        }

        return inv_count;
    }

    public static int merge(int[] arr, int left, int mid, int right) {
        int inv_count = 0;
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }

        for(int i=0; i < n2; i++) {
            R[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0;

        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
                inv_count++;
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) {
            arr[k++] = L[i++];
        }

        while (j < n2) {
            arr[k++] = R[j++];
        }

        return inv_count;
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 8, 6, 1};
        int inv_counts = mergeSort(arr, 0, arr.length - 1);

        System.out.print(inv_counts);
    }
}
