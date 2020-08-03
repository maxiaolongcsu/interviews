package me.maxiaolong.companies.pdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author maxiaolong
 * created at 2020/8/2
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] chars = new char[6][6];
        for (int i = 0; i < 6; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < 6; j++) {
                chars[i][j] = s.charAt(j);
            }
        }

        int[][] nums = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                nums[i][j] = 0;
            }
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if(chars[i][j]=='#'){
                    if(i==0&&j==0) nums[0][0] = 6;
                    if(i==0&&j>0){
                        if(nums[i][j-1] == 0) nums[i][j] = 6;
                        else nums[i][j] = 5;
                    }
                    if(i>0&&j==0){
                        if(nums[i-1][j] == 0) nums[i][j] = 6;
                        else nums[i][j] = 5;
                    }
                    if(i>0&&j>0){
                        if(nums[i-1][j] == 0 && nums[i-1][j-1] == 0) nums[i][j] = 6;
                        else nums[i][j] = 5;
                    }
                }
            }
        }

        long result = 1;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                result = result * (nums[i][j]!=0?nums[i][j]:1);
            }
        }
        System.out.println(result);
    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt(), m = sc.nextInt(), t = sc.nextInt();
//        int[] x = new int[n + m + 2];
//        int[] y = new int[n + m + 2];
//        x[0] = 0;
//        y[0] = 0;
//        for (int i = 1; i < n+1; i++) {
//            x[i] = sc.nextInt();
//            y[i] = sc.nextInt();
//        }
//        x[n + 1] = 0;
//        y[n + 1]  = 0;
//        for (int i = 0; i < m; i++) {
//            x[n + 2 + i] = sc.nextInt();
//            y[n + 2 + i] = sc.nextInt();
//        }
//
//        List<Integer> result = new ArrayList<>();
//        List<List<Integer>> path = new ArrayList<>();
//        backtrack(x, y, t, n, m, result, path);
//        int res = result.size()>0?result.get(0):-1;
//        System.out.println(res);
//    }
//
//    public static void backtrack(int[] x, int[] y, int t, int n, int m, List<Integer> result, List<List<Integer>> path) {
//        if (path.size() == 2) {
//            int tmp = path.get(0).get(1) + path.get(1).get(1);
//            if(tmp >= t){
//                int res = path.get(0).get(0) + path.get(1).get(0);
//                if(result.size()==0) result.add(res);
//                else if(result.get(0) > res) result.set(0, res);
//            }
//        }
//
//        if(path.size()==0){
//            for (int i = 0; i < n + 1; i++) {
//                path.add(Arrays.asList(new Integer(x[i]), new Integer(y[i])));
//                backtrack(x, y, t, n, m, result, path);
//                path.remove(path.size() - 1);
//            }
//        }
//        if(path.size() == 1){
//            for (int i = n + 1; i < n + m + 2; i++) {
//                path.add(Arrays.asList(new Integer(x[i]), new Integer(y[i])));
//                backtrack(x, y, t, n, m, result, path);
//                path.remove(path.size() - 1);
//            }
//        }
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int k = sc.nextInt(), n = sc.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
//
//        if(k==0){
//            System.out.println("paradox");
//            return;
//        }
//
//        int index = 0;
//        int reverseNum = 0;
//        for (int i = 0; i < n; i++) {
//            index += nums[i];
//            if(index == k) {
//                System.out.println("paradox");
//                return;
//            }
//            if(index > k){
//                index = 2*k - index;
//                reverseNum ++;
//            }
//        }
//        System.out.printf("%d %d%n", k - index, reverseNum);
//    }

}
