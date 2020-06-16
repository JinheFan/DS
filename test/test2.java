package test;

import java.util.HashMap;

public class test2 {
    public static void main(String[] args) {
        String s3 = "abc";
        String s4 = "xxx";
        String s5 = "abc" + "xxx";
        String s6 = s3 + s4;
        System.out.println(s5==s6);
    }
}
