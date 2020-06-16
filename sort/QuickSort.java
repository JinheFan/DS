package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {9, 6, 7, 4, 3, 0};
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void sort(int[] nums, int left, int right) {
        int l = left;
        int r = right;
        int mid = (r - l) / 2 + l;
        int pivot = nums[mid];
        while (l < r) {
            while (nums[l] < pivot) {
                l++;
            }
            while (nums[r] > pivot) {
                r--;
            }
            if(l >= r) {
                break;
            }
            swap(nums, l, r);
            if(nums[l] == pivot) {
                r--;
            }
            if(nums[r] == pivot) {
                l++;
            }
        }
        if( l == r) {
            l++;
            r--;
        }
        if(left < r) {
            sort(nums, left, r);
        }
        if(right > l) {
            sort(nums, l, right);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
