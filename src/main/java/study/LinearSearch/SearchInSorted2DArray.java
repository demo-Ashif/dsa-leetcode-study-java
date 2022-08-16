package study.LinearSearch;

import java.util.Arrays;

public class SearchInSorted2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 3, 5, 7},
                {10, 12, 13, 15},
                {17, 21, 33, 35},
                {39, 41, 48, 55}
        };
        int target = 33;
//        int[] ans = search(arr, target); // format of return value {row, col}
        int[] ans = searchLinearBinary(arr, target); // format of return value {row, col}

        System.out.println(Arrays.toString(ans));
    }

    //linear search O(NxM)
    static int[] search(int[][] arr, int target) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] == target) {
                    return new int[]{row, col};
                }
            }
        }
        return new int[]{-1, -1};
    }

    //linear + binary search O(NxlogN)
    static int[] searchLinearBinary(int[][] arr, int target) {
        for (int row = 0; row < arr.length; row++) {
            int result = binarySearch(arr[row], target);
            if (result != -1) {
                return new int[]{row, result};
            }
        }
        return new int[]{-1, -1};
    }

    static int binarySearch(int[] arr, int target) {
        int index = -1;
        int start = 0;
        int end = arr.length - 1;
        int mid;

        while (start <= end) {
            mid = start + (end - start) / 2;

            if (target == arr[mid]) {
                return mid;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return index;
    }
}
