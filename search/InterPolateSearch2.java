package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InterPolateSearch2 {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 6, 6, 6, 6, 7, 8};
        List<Integer> res = find(nums, 0, nums.length - 1, 6);
        System.out.println(Arrays.toString(res.toArray()));
    }

    public static List<Integer> find(int[] nums, int left, int right, int target) {
        if (left > right || target < nums[0] || target > nums[nums.length - 1]) {
            return new ArrayList<>();
        }
        int mid = (right - left) * (target - nums[left]) / (nums[right] - nums[left]) + left;
        int midValue = nums[mid];
        if (midValue < target) {
            return find(nums, mid + 1, right, target);
        } else if (midValue > target) {
            return find(nums, left, mid - 1, target);
        } else {
            List<Integer> res = new ArrayList<>();
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || nums[temp] != target) {
                    break;
                }
                res.add(temp);
                temp--;
            }
            res.add(mid);

            temp = mid + 1;
            while (true) {
                if (temp > nums.length - 1 || nums[temp] != target) {
                    break;
                }
                res.add(temp);
                temp++;
            }
            return res;
        }
    }
}
