package me.maxiaolong.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author maxiaolong
 * created at 2020/7/28
 */
public class Problem1 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 返回数值对应的数组(利用哈希表实现O(1)的时间复杂度)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target){
        if(nums==null||nums.length<2) return null;
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            int residue = target - nums[i];
            if(map.containsKey(residue)){
                result[0] = map.get(residue);
                result[1] = i;
                return result;
            }
        }
        return null;
    }
}
