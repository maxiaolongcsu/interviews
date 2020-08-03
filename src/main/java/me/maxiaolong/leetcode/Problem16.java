package me.maxiaolong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author maxiaolong
 * created at 2020/7/28
 */
public class Problem16 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        if(nums==null||nums.length<3) return Integer.MIN_VALUE;
        List<Integer> result = Arrays.asList(Integer.MIN_VALUE);
        List<Integer> path = new ArrayList<>();
        backtrack(nums, target, result, path);
        return result.get(0);
    }

    public static void backtrack(int[] nums, int target, List<Integer> result, List<Integer> path) {
        if (path.size() == 3) {
            int temp = nums[path.get(0)] + nums[path.get(1)] + nums[path.get(2)];
            if (Math.abs(temp - target) < Math.abs(result.get(0) - target)) result.set(0, temp);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (path.contains(i)) continue;
            path.add(i);
            backtrack(nums, target, result, path);
            path.remove(path.size() - 1);
        }
    }
}


