package search;

public class SequenceSearch {
    public static void main(String[] args) {
        int[] nums = {2, -1, 9, 8, 3, 5};
        int index = find(nums, 9);
        if(index == -1) {
            System.out.println("not found");
            return;
        }
        System.out.println(index);
    }

    public static int find(int[] nums, int value) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
