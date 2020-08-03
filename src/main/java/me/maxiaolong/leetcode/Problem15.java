package me.maxiaolong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author maxiaolong
 * created at 2020/7/28
 */
public class Problem15 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        result.stream().forEach(System.out::println);
    }

    /**
     * a+b+c == 0 应该可以使用回溯，且是全部答案
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return null;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(nums, result, path);
        return result;
    }

    private static void backtrack(int[] nums, List<List<Integer>> result, List<Integer> path) {
        // 满足条件
        if (path.size() == 3) {
            if (nums[path.get(0)] + nums[path.get(1)] + nums[path.get(2)] == 0) {
                Integer[] temp = new Integer[]{nums[path.get(0)], nums[path.get(1)], nums[path.get(2)]};
                Arrays.sort(temp);
                List<Integer> tempList = Arrays.asList(temp);
                // contains
                boolean isContains = false;
                for (int i = 0; i < result.size(); i++) {
                    List<Integer> list = result.get(i);
                    for (int j = 0; j < list.size(); j++) {
                        if(list.get(0).intValue()==tempList.get(0).intValue()&&list.get(1).intValue()==tempList.get(1).intValue()&&list.get(2).intValue()==tempList.get(2).intValue()){
                            isContains = true;
                        }
                    }
                }
                if(!isContains) result.add(tempList);
            }
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //剪枝
            if (path.contains(i)) continue;
            path.add(i);
            backtrack(nums, result, path);
            path.remove(path.size() - 1);
        }
    }
}
