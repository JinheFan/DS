package sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BucketSort {
    public static void main(String[] args) {
        int[] nums = new int[100];
        int index = 0;
        List<Integer> list = Stream.generate(() -> (int) (Math.random() * 100)).limit(100).collect(Collectors.toList());
        for(int num : list) {
            nums[index++] = num;
        }
        bucketSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void bucketSort(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
            }
        }
        int maxLength = (max + "").length();
        int[][] bucket = new int[10][nums.length];
        int[] bucketElementsCounts = new int[10];
        int index = 0;
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < nums.length; j++) {
                int digitOfElement = nums[j] / n % 10;
                bucket[digitOfElement][bucketElementsCounts[digitOfElement]] = nums[j];
                bucketElementsCounts[digitOfElement]++;
            }
            for (int k = 0; k < bucket.length; k++) {
                if (bucketElementsCounts[k] != 0) {
                    for (int l = 0; l < bucketElementsCounts[k]; l++) {
                        nums[index++] = bucket[k][l];
                    }
                }
                bucketElementsCounts[k] = 0;
            }
            index = 0;
        }
    }
}
