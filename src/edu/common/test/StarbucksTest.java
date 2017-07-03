package edu.common.test;

/**
 * Created by hungduong on 6/16/17.
 */
public class StarbucksTest {

    //Question 1: merge 2 arrays
    public static int[] mergerString(String[] a, String[] b) {
        int n = a.length;
        int[] res = new int[n];

        for(int i = 0; i < n; i++) {
            String strA = a[i];
            String strB = b[i];

            if(strA.length() == strB.length()) {
                int[] alphabet = new int[28];
                for(int j = 0; j < strA.length(); i++) {
                    alphabet[strA.charAt(j) - 'a']++;
                }

                int index = 0;
                for(int j = 0; j < strB.length(); i++) {
                    if(alphabet[strB.charAt(j) - 'a'] != 0) {
                        index++;
                    }
                }

                res[i] = index;
            } else {
                res[i] = -1;
            }
        }

        return res;
    }


    //Question 2: arr = [2, 3, 3, 4] => min = 2 + 3 + 4 + 5 = 14
    //            arr = [3, 3, 2, 4] => sort => [2, 3, 3, 4] => min = ....
    public static int findSumMin(int[] arr) {
        //Sort
        heapsort(arr);

        int min = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] <= arr[i - 1]) {
                arr[i] = arr[i - 1] + 1;
            }
            min += arr[i];
        }

        return min;
    }

    public static void heapsort(int[] arr) {
        int heapsize = arr.length;

        for(int i = heapsize/2 - 1; i >= 0; i--) {
            heapify(arr, heapsize, i);
        }

        for(int i = heapsize -1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2

        if(l < n && arr[l] > arr[largest])
            largest = l;

        if(r < n && arr[r] > arr[largest])
            largest = r;

        if(largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    //Question 3: Anagram
    //          input  a = {'a', 'ab', 'abcd'}
    //                 b = {'bc', 'ba', 'abab'}
    //          output   = {-1, 0, 2}
    public static int[] find(String[] a, String[] b) {
        int[] res = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            if (a[i].length() != b[i].length()) {
                res[i] = -1;
                continue;
            }

            int[] alphabet = new int[26];
            for (int j = 0; j < a[i].length(); j++) {
                alphabet[a[i].charAt(j) - 'a']++;
            }

            for (int j = 0;  j < b[i].length(); j++) {
                alphabet[b[i].charAt(j) - 'a']--;
            }

            for(int j = 0; j < alphabet.length; j++) {
                if(alphabet[j] > 0) {
                    res[i] += alphabet[j];
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String[] a = {"a", "ab", "abcd"};
        String[] b = {"bc", "ba", "abab"};

        int[] res = find(a, b);
        for(int i = 0;  i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
