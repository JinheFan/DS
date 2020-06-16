package sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] nums = {4, 3, 1, 6, -1, 7, 3, 9};
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            if (i != j) {
                nums[j] = temp;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
