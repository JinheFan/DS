package dp;

public class Knapsack {
    public static void main(String[] args) {
        int[] itemWeight= {1, 4, 3};
        int[] itemValue = {1500, 3000, 2000};
        int bagStore = 4;
        int numsOfitems = itemValue.length;

        int[][] value = new int[numsOfitems + 1][bagStore + 1];
        for (int i = 0; i < value.length; i++) {
            value[i][0] = 0;
        }
        for (int i = 0; i < value[0].length; i++) {
            value[0][i] = 0;
        }
        for (int m = 1; m < value.length; m++) {
            for (int n = 1; n < value[0].length; n++) {
                if (itemWeight[m - 1] > n) {
                    value[m][n] = value[m - 1][n];
                } else if (itemWeight[m - 1] <= n) {
                    value[m][n] = Math.max(value[m - 1][n], itemValue[m - 1] + value[m - 1][n - itemWeight[m - 1]]);
                }
            }
        }
        for (int[] row : value) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println(value[value.length - 1][value[0].length - 1]);
    }
}
