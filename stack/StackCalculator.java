package stack;

import java.util.Stack;

public class StackCalculator {
    public static void main(String[] args) {
        String str = "820/4/5";
        System.out.println(calculate(str));
    }

    public static int calculate(String str) {
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> operateStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                int num = str.charAt(i) - '0';
                while ((i + 1) < str.length() && Character.isDigit(str.charAt(i + 1))) {
                    num = num * 10 + (str.charAt(i + 1) - '0');
                    i++;
                }
                numStack.push(num);
            } else if (str.charAt(i) == '+' || str.charAt(i) == '-') {
                if(operateStack.isEmpty()) {
                    operateStack.push(str.charAt(i));
                } else {
                    Character operInStack = operateStack.peek();
                    int priority = getPriority(operInStack);
                    if(priority >= 0) {
                        Integer num1 = numStack.pop();
                        Integer num2 = numStack.pop();
                        Character popChar = operateStack.pop();
                        if(popChar == '*') {
                            numStack.push(num1 * num2);
                        } else if(popChar == '/') {
                            numStack.push(num2 / num1);
                        } else if (popChar == '+') {
                            numStack.push(num1 + num2);
                        } else if (popChar == '-') {
                            numStack.push(num2 - num1);
                        }
                        operateStack.push(str.charAt(i));
                    } else {
                        operateStack.push(str.charAt(i));
                    }
                }
            } else if (str.charAt(i) == '*' || str.charAt(i) == '/') {
                if(operateStack.isEmpty()) {
                    operateStack.push(str.charAt(i));
                } else {
                    Character operInStack = operateStack.peek();
                    int priority = getPriority(operInStack);
                    if(priority >= 1) {
                        Integer num1 = numStack.pop();
                        Integer num2 = numStack.pop();
                        Character popChar = operateStack.pop();
                        if(popChar == '*') {
                            numStack.push(num1 * num2);
                        } else if(popChar == '/') {
                            numStack.push(num2 / num1);
                        }
                        operateStack.push(str.charAt(i));
                    } else {
                        operateStack.push(str.charAt(i));
                    }
                }
            }
        }
        Integer num1 = numStack.pop();
        Integer num2 = numStack.pop();
        Character popChar = operateStack.pop();
        if (popChar == '+') {
            return num1 + num2;
        } else if (popChar == '-') {
            return num2 - num1;
        } else if (popChar == '*') {
            return num1 * num2;
        } else {
            return num2 / num1;
        }
    }

    private static int getPriority(char c) {
        if(c == '+' || c == '-') {
            return 0;
        } else if (c == '*' || c == '/') {
            return 1;
        } else {
            return -1;
        }
    }
}


