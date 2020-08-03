package me.maxiaolong.companies.yuanfudao;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author maxiaolong
 * created at 2020/8/2
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < number; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            // 直接使用所有区间无法消除冗余空间 最终选择计算换空间的方式
            map.put(start, map.containsKey(start) ? map.get(start) + 1 : 1);
            map.put(end, map.containsKey(end) ? map.get(end) - 1 : -1);
        }
        int result = 0;
        int temp = 0;
        for(Integer key: map.keySet()){
            temp += map.get(key);
            result = Math.max(result, temp);
        }
        System.out.println(result);
    }
}