package leetcode.BinarySearch;

/*
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */

import java.util.Arrays;

public class SearchRange {
    public static void main(String[] args) {
        int[] result = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        System.out.println(Arrays.toString(result));

    }

    static int[] searchRange(int[] nums, int target) {
        int[] ans;

        if (nums.length <= 0) return new int[]{-1, -1};

        int first = binarySearch(nums, target, true);
        int last = binarySearch(nums, target, false);

        ans = new int[]{first, last};


        return ans;
    }

    static int binarySearch(int[] nums, int target, boolean firstOccurrence) {
        int ans = -1;

        int start = 0;
        int end = nums.length - 1;
        int mid;

        while (start <= end) {
            mid = start + (end - start) / 2;

            if (target == nums[mid]) {
                ans = mid;
                if (firstOccurrence) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }
}
