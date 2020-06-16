package search;

public class InterPolateSearch {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        int res = find(nums, 0, nums.length - 1, 0);
        System.out.println(res);
    }

    public static int find(int[] nums, int left, int right, int target) {
        if (left > right || target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int mid = (right - left) * (target - nums[left]) / (nums[right] - nums[left]) + left;
        int midValue = nums[mid];
        if (midValue > target) {
            return find(nums, left, mid - 1, target);
        } else if (midValue < target) {
            return find(nums, mid + 1, right, target);
        } else {
            return mid;
        }
    }
}
