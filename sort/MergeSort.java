package sort;

import java.util.Arrays;

public class MergeSort {
    static int count = 0;

    public static void main(String[] args) {
        int[] nums = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[nums.length];
        split(nums, 0, nums.length - 1, temp);
        System.out.println(Arrays.toString(nums));
        System.out.println(count);
    }

    public static void split(int[] nums, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (right - left) / 2 + left;
            split(nums, left, mid, temp);
            split(nums, mid + 1, right, temp);
            merge(nums, left, mid, right, temp);
        }
    }

    public static void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;

        count++;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[t++] = nums[i];
                i++;
            } else {
                temp[t++] = nums[j];
                j++;
            }
        }

        while (i <= mid) {
            temp[t++] = nums[i];
            i++;
        }

        while (j <= right) {
            temp[t++] = nums[j];
            j++;
        }

        t = 0;
        int l = left;
        while (l <= right) {
            nums[l++] = temp[t++];
        }
    }
}
