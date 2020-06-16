package stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class PolandNotation {
    public static void main(String[] args) {
        String expression = "3 4 + 5 * 6 -";   // (3 + 4) * 5 - 6
        List<String> list = getList(expression);
        int result = getResult(list);
        System.out.println(result);
    }

    private static List<String> getList(String expression) {
        String[] strings = expression.split(" ");
        List<String> list = Arrays.stream(strings).collect(Collectors.toList());
        return list;
    }

    public static int getResult(List<String> list) {
        Stack<String> stack = new Stack<>();
        for(String str : list) {
            if(str.matches("\\d+")) {   //匹配数字
                stack.push(str);
            } else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                if(str.equals("+")) {
                    res = num1 + num2;
                } else if (str.equals("-")) {
                    res = num2 - num1;
                } else if (str.equals("*")) {
                    res = num1 * num2;
                } else if (str.equals("/")) {
                    res = num2 / num1;
                } else {
                    throw new RuntimeException();
                }
                stack.push(res + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
