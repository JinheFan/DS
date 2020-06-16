package divideAndConquer;

public class Hanota {
    public static void main(String[] args) {
        helper(3, 'a', 'b', 'c');
    }

    public static void helper(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第一个盘从 " + a + "->" + c);
        } else {
            helper(num - 1, a, c, b);
            System.out.println("第" + num + "盘从" + a + "->" + c);
            helper(num - 1, b, a, c);
        }
    }
}
