package me.maxiaolong.companies.baidu;

import java.util.Arrays;

/**
 * @author maxiaolong
 * created at 2020/7/21
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = new int[]{6,5,4,3,2,1};
        System.out.println(Arrays.toString(quickSort(arr, 0, arr.length - 1)));
    }

    public static int[] quickSort(int[] arr, int start, int end){
        if(arr==null||arr.length==0||arr.length==1||end<=start) return arr;
        int flag = arr[start];
        int i = start + 1;
        int j = end;
        while(i < j){
            while(i<j&&arr[i]<=flag) i++;
            while(i<j&&arr[j]>flag) j--;
            if(i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // i==j,确定flag的位置
        int index = i;
        if(arr[i] > flag) index = i - 1;
        for (int k = start; k < index; k++) {
            arr[k] = arr[k+1];
        }
        arr[index] = flag;
        quickSort(arr, start, index - 1);
        quickSort(arr, index + 1, end);
        return arr;
    }
}
