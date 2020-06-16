package array;

public class SparseArray {
    public static void main(String[] args) {
        System.out.println("Original Array");
        int[][] chessAry = new int[11][11];
        chessAry[1][2] = 1;     // 1 : 黑子
        chessAry[2][3] = 2;     // 2 : 蓝子
        for (int[] row : chessAry) {
            for(int val : row) {
                System.out.printf("%d\t", val);
            }
            System.out.println();
        }

        // 获取不为0的个数(sum)
        int sum = 0;
        for(int i = 0; i < chessAry.length; i++) {
            for(int j = 0; j < chessAry[0].length; j++) {
                if(chessAry[i][j] != 0) {
                    sum++;
                }
            }
        }
        // 创建 sparse array
        int[][] sparseAry = new int[sum + 1][3];
        sparseAry[0][0] = chessAry.length;
        sparseAry[0][1] = chessAry[0].length;
        sparseAry[0][2] = sum;
        // 给sparse array 赋值
        int row = 1;
        for(int i = 0; i < chessAry.length; i++) {
            for(int j = 0; j < chessAry[0].length; j++) {
                if(chessAry[i][j] != 0) {
                    sparseAry[row][0] = i;
                    sparseAry[row][1] = j;
                    sparseAry[row][2] = chessAry[i][j];
                    row++;
                }
            }
        }
        // 输出 sparse array
        System.out.println("Sparse Array");
        for (int[] row1 : sparseAry) {
            for(int val : row1) {
                System.out.printf("%d\t", val);
            }
            System.out.println();
        }
        // convert sparse array to origin array
        int[][] originArr = new int[sparseAry[0][0]][sparseAry[0][1]];
        for(int i = 1; i < sparseAry.length; i++) {
            originArr[sparseAry[i][0]][sparseAry[i][1]] = sparseAry[i][2];
        }

    }
}
