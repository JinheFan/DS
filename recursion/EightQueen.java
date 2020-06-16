package recursion;

public class EightQueen {
    int max = 8;
    int[] arr = new int[max];
    int count = 0;
    public static void main(String[] args) {
        EightQueen queen = new EightQueen();
        queen.check(0);
        System.out.println(queen.count);
    }

    private void check(int n) {
        if(n == max) {
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            arr[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }

    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if(arr[n] == arr[i] || Math.abs(i - n) == Math.abs(arr[i] - arr[n])) {
                return false;
            }
        }
        return true;
    }

    private void print() {
        count++;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
