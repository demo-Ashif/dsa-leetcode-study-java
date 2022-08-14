package leetcode.BinarySearch;

/*
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */

public class SearchInRotatedArray {
    public static void main(String[] args) {
        int result = searchInRotatedArray(new int[]{5, 1, 3}, 5);
        System.out.println(result);

    }

    static int searchInRotatedArray(int[] nums, int target) {
        int ans;

        if (nums.length == 1) {
            if (nums[0] == target) return 0;
            else return -1;
        }

        int pivotElementIndex = findPivotElement(nums);
        if (pivotElementIndex == -1) { //no pivot element so array is no rotated, normal binary search
            ans = binarySearch(nums, target, 0, pivotElementIndex - 1);
        } else {
            if (target == nums[pivotElementIndex]) return pivotElementIndex;
            ans = binarySearch(nums, target, 0, pivotElementIndex - 1);
            if (ans == -1) {
                int end = nums.length - 1;
                ans = binarySearch(nums, target, pivotElementIndex + 1, end);
            }
        }

        return ans;
    }

    static int findPivotElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && nums[mid] > nums[mid + 1]) { // check to avoid index out of bound
                return mid;
            }

            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }

            if (nums[mid] <= nums[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }

        return -1;
    }

    static int binarySearch(int[] arr, int target, int startIndex, int endIndex) {
        int index = -1;
        int start = startIndex;
        int end = endIndex;
        int mid;

        while (start <= end) {
            mid = start + (end - start) / 2;

            if (target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }

        return index;
    }
}
