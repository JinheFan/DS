package tree;

public class PreOrderArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrBinaryTree tree = new ArrBinaryTree(nums);
        tree.preOrder();
    }

    static class ArrBinaryTree {
        int[] nums;

        public ArrBinaryTree(int[] nums) {
            this.nums = nums;
        }

        public void preOrder() {
            this.preOrder(0);
        }

        public void preOrder(int index) {
            if (nums == null || nums.length == 0) {
                return;
            }
            System.out.print(nums[index] + " ");
            if(index * 2 + 1 < nums.length) {
                preOrder(index * 2 + 1);
            }
            if(index * 2 + 2 < nums.length) {
                preOrder(index * 2 + 2);
            }
        }
    }
}
