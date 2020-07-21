package me.maxiaolong.companies.alibaba;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author maxiaolong
 * created at 2020/7/17
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        List l = new ArrayList();
        for (int i = 0; i < t; i++) {
            l.add(sc.nextInt());
        }
        for (int i = 0; i < l.size(); i++) {
            int number = (int)l.get(i);
            // 考虑最大值的边界情况
            if(number==1<<31-1){
                System.out.println(1<<30);
            }
            System.out.println((int) Math.pow(2, getIntBinaryOneNumber(number)+1));
        }
    }

    /**
     * 获得整数的二进制形式中1的个数
     * @param number
     * @return
     */
    public static int getIntBinaryOneNumber(int number){
        int count = 0;
        while(number!=0){
            int r = number%2;
            if(r==1) {
                count++;
            }
            number = number/2;
        }
        return count;
    }
}
