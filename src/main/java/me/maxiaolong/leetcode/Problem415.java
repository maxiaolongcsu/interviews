package me.maxiaolong.leetcode;

/**
 * @author maxiaolong
 * created at 2020/7/28
 */
public class Problem415 {

    public static void main(String[] args) {
        String num1 = "97548261";
        String num2 = "1235654789";
        System.out.println(addStrings(num1, num2));
        System.out.println(1235654789+97548261);
        // String num2 = "97548262"； //数字相同则使用compareTo
        System.out.println(num1.compareTo(num2));
    }

    /**
     * 大数相加
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String addStrings(String num1, String num2) {
        int len = num1.length() > num2.length() ? num1.length() : num2.length();
        int addition = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int temp1 = i < num1.length() ? num1.charAt(num1.length() - 1 - i) - '0' : 0;
            int temp2 = i < num2.length() ? num2.charAt(num2.length() - 1 - i) - '0' : 0;
            int anchor = temp1 + temp2 + addition;
            if (anchor >= 10) {
                sb.append(anchor - 10);
                addition = 1;
            } else {
                sb.append(anchor);
                addition = 0;
            }
        }
        if (addition != 0) sb.append(addition);
        return sb.reverse().toString();
    }
}
