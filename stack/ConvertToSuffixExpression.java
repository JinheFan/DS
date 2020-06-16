package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class ConvertToSuffixExpression {
    public static void main(String[] args) {
        String expression = "1 + ( ( 2 + 30 ) * 4 ) - 5";
        List<String> list = getList(expression);
        System.out.println(getResult(list));
    }
    private static List<String> getList(String expression) {
        String[] strings = expression.split(" ");
        List<String> list = Arrays.stream(strings).collect(Collectors.toList());
        return list;
    }

    private static List<String> getResult(List<String> list) {
        Stack<String> stack = new Stack<>();
        List<String> res = new ArrayList<>();
        for(String item : list) {
            if(item.matches("\\d+")) {
                res.add(item);
            } else if (item.equals("(")) {
                stack.push(item);
            } else if (item.equals(")")) {
                while (!stack.peek().equals("(")) {
                    res.add(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && Operation.getValue(item) <= Operation.getValue(stack.peek())) {
                    res.add(stack.pop());
                }
                stack.push(item);
            }
        }
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }
}

class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String operation) {
        int res = 0;
        switch (operation) {
            case "+" :
                res = ADD;
                break;
            case "-" :
                res = SUB;
                break;
            case "*" :
                res = MUL;
                break;
            case "/" :
                res = DIV;
                break;
            default:
                break;
        }
        return res;
    }
}
