package sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] nums = {7, 45, 3, 8, 2, 7, 5};
        for (int i = (int) Math.floor(nums.length / 2); i >= 0; i--) {
            heapSort(nums, i, nums.length);
        }
        for (int j = nums.length - 1; j > 0; j--) {
            swap(nums, 0, j);
            heapSort(nums, 0, j);
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void heapSort(int[] nums, int index, int length) {
        int temp = nums[index];
        for (int i = index * 2 + 1; i < length; i = i * 2 + 1) {
            if (i + 1 < length && nums[i] < nums[i + 1]) {
                i++;
            }
            if (nums[index] < nums[i]) {
                nums[index] = nums[i];
                index = i;
            } else {
                break;
            }
        }
        nums[index] = temp;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

