package search;

public class BinarySearchNonRecursion {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9};
        System.out.println(find(nums, 3));
    }

    public static int find(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
