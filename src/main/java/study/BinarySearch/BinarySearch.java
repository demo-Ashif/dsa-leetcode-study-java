package study.BinarySearch;

/*
* Time Complexity of Binary Search O(logN)
* pre-condition - array list must be sorted
* 1st iteration N/2, 2nd iteration N/4 .... N/2^k
* N/2^k =1
* N = 2^k
* log2^N = k ---> O(logN)
* */

public class BinarySearch {
    public static void main(String[] args) {
        //private static final Logger logger = LogManager.getLogger(Main.class);
        int result = binarySearch(new int[]{5, 9, 17, 23, 25, 45, 59, 63, 71, 74, 78, 88, 99}, 99);
        if(result==-1){
           System.out.println("Not Found!");
        }else {
            System.out.printf("Found at index: %d",result);
        }

    }

    static int binarySearch(int[] arr, int key) {
        int index = -1;
        int low = 0;
        int high = arr.length - 1;
        int mid;

        while (low <= high) {
            //better then (high+low)/2 otherwise it may exceed int capacity
            mid = low + (high - low) / 2;

            if (key == arr[mid]) {
                return mid;
            } else if (key > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return index;
    }
}
