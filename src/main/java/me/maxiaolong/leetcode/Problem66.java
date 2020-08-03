package me.maxiaolong.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maxiaolong
 * created at 2020/7/22
 * 不重复数组全排列结果
 */
public class Problem66 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> result = permute(nums);
        result.stream().forEach(System.out::println);
    }

    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if(nums==null||nums.length==0) return result;
        backtrack(result, nums, path);
        return result;
    }

    /**
     * dfs进行搜索的框架
     * result = []
     * def backtrack(path, nums){
     *     if(满足结束条件):
     *          result.add(path);
     *          return
     *     for 选择 in 选择列表：
     *          添加选择；
     *          backtrack(path, nums);
     *          撤销选择；
     * }
     *
     * result: 结果列表
     * nums: 选择列表
     * path：目前路径
     * @param nums
     */
    public static void backtrack(List<List<Integer>> result, int[] nums, List<Integer> path){
        if(path.size()==nums.length){
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 剪枝过程
            if(path.contains(nums[i])) continue;
            path.add(nums[i]);
            backtrack(result, nums, path);
            // 后入先出的想法
            path.remove(path.size()-1);
        }
    }
}
