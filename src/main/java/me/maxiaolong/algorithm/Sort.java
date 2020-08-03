package me.maxiaolong.algorithm;

import java.util.Arrays;

/**
 * @author maxiaolong
 * created at 2020/7/22
 */
public class Sort {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,4,2,1,45,6};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 1. 构建最大堆（从大到小）
     * 2. 元素交换
     * 3. 调整堆
     *
     * @param nums
     * @return
     */
    public static void heapSort(int[] nums) {
        buildMaxHeap(nums);
        int i = nums.length - 1;
        while (i > 0) {
            int endValue = nums[i];
            nums[i] = nums[0];
            nums[0] = endValue;
            adjustMaxHeap(nums, --i);
        }
    }

    private static void buildMaxHeap(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            int parentIndex = (i - 1) / 2;
            if (nums[i] > nums[parentIndex]) {
                int temp = nums[i];
                nums[i] = nums[parentIndex];
                nums[parentIndex] = temp;
            }
        }
    }

    private static void adjustMaxHeap(int[] nums, int end) {
        if (end == 0) return;
        int index = 0;
        while (true) {
            int tempIndex = index;
            int left_index = index * 2 + 1;
            if (left_index <= end) {
                if (nums[left_index] > nums[index])
                    tempIndex = left_index;
                if (left_index + 1 <= end) {
                    if (nums[left_index + 1] > nums[tempIndex])
                        tempIndex = left_index + 1;
                }
                if (tempIndex == index) {
                    break;
                } else {
                    int temp = nums[tempIndex];
                    nums[tempIndex] = nums[index];
                    nums[index] = temp;
                    index = tempIndex;
                }
            } else {
                break;
            }
        }
    }

    /**
     *
     * @param nums
     * @return
     */
    public static void mergeSort(int[] nums) {

        return ;
    }
}
