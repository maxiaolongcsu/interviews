package me.maxiaolong.companies.baidu;

import java.util.Arrays;

/**
 * @author maxiaolong
 * created at 2020/7/21
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 0, 1, 5};
        quickSelect(nums, 4, 0,nums.length - 1);
        System.out.println(nums[4 - 1]);

        zeroToEnd(nums);
        System.out.println(Arrays.toString(nums));
        quickSortV1(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void zeroToEnd(int[] nums) {
        int firstZeroIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && firstZeroIndex == -1) firstZeroIndex = i;
            if (nums[i] != 0 && i > firstZeroIndex) {
                nums[firstZeroIndex] = nums[i];
                nums[i] = 0;
                firstZeroIndex++;
            }
        }
    }

    public static void quickSelect(int[] arr, int k, int start, int end) {
        if (arr == null || arr.length == 0 || start >= end) return;
        int flag = arr[start];
        int i = start, j = end;
        while (i < j) {
            while (i < j && arr[j] >= flag) j--;
            arr[i] = arr[j];
            while (i < j && arr[i] <= flag) i++;
            arr[j] = arr[i];
        }
        arr[i] = flag;
        if (k - 1 > i) {
            quickSelect(arr, k, i + 1, end);
        }
        if (k - 1 < i) {
            quickSelect(arr, k, start, i - 1);
        }
    }

    public static void quickSortV1(int[] arr, int start, int end) {
        if (arr == null || arr.length == 0 || start >= end) return;
        int flag = arr[start];
        int i = start, j = end;
        while (i < j) {
            while (i < j && arr[j] >= flag) j--;
            arr[i] = arr[j];
            while (i < j && arr[i] <= flag) i++;
            arr[j] = arr[i];
        }
        arr[i] = flag;
        quickSortV1(arr, start, i - 1);
        quickSortV1(arr, i + 1, end);
    }

    public static int[] quickSort(int[] arr, int start, int end) {
        if (arr == null || arr.length == 0 || arr.length == 1 || end <= start) return arr;
        int flag = arr[start];
        int i = start + 1;
        int j = end;
        while (i < j) {
            while (i < j && arr[i] <= flag) i++;
            while (i < j && arr[j] > flag) j--;
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // i==j,确定flag的位置
        int index = i;
        if (arr[i] > flag) index = i - 1;
        for (int k = start; k < index; k++) {
            arr[k] = arr[k + 1];
        }
        arr[index] = flag;
        quickSort(arr, start, index - 1);
        quickSort(arr, index + 1, end);
        return arr;
    }
}


