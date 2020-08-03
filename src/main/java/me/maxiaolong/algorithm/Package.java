package me.maxiaolong.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author maxiaolong
 * created at 2020/7/18
 */
public class Package {
    public static void main(String[] args) {
        int w = 4;
        int[] c = new int[]{2, 1, 3};
        int[] v = new int[]{4, 2, 3};
        int[] m = new int[]{0, 1, 1};
        int[] f = new int[w + 1];
        MultiplePack(f, c, v, m);
        System.out.println(f[w]);
    }

    /**
     * 二维背包问题 (具有两种不同的费用，比如背包重量和物品总数量限制)
     * @param f
     * @param c
     * @param v
     * @param m
     */
    public static void twoDimensionPack(int[][] f, int[] c, int[] v, int[] m){

    }

    /**
     * 多重背包问题，可放置有限个(其它方法为转化为0-1背包问题，使用二进制思想)
     *
     * @param f
     * @param c 物体重量
     * @param v 物体价值
     * @param m 物体数量限制
     * @return
     */
    public static void MultiplePack(int[] f, int[] c, int[] v, int[] m) {
        List<Integer> cList = new ArrayList<>();
        List<Integer> vList = new ArrayList<>();
        int w = f.length - 1;
        for (int i = 0; i < c.length; i++) {
            int k = 1;
            while (k <= m[i] && k * c[i] <= w) {
                cList.add(k*c[i]);
                vList.add(k*v[i]);
                k *= 2;
            }
        }
        zeroOnePack(f, Arrays.stream(cList.toArray(new Integer[cList.size()])).mapToInt(Integer::intValue).toArray(),
                Arrays.stream(vList.toArray(new Integer[vList.size()])).mapToInt(Integer::intValue).toArray());
    }

    /**
     * 完全背包问题，可放置无限个(其它方法为转换为0-1背包问题，个数为2^k个数，使用二进制思想)
     * f(i,w) = max(f(i-1, w),f(i, w-c_i)+v_i) 注意后面是是i，表明可以放多个
     * 使用1维数组：f(w) = max(f(w), f(w-c_i)+v_i) 遍历时，需要w_i升序
     *
     * @param f
     * @param c
     * @param v
     * @return
     */
    public static void CompletePack(int[] f, int[] c, int[] v) {
        for (int i = 0; i < c.length; i++) {
            for (int j = c[i]; j < f.length; j++) {
                f[j] = Math.max(f[j], f[j - c[i]] + v[i]);
            }
        }
    }

    /**
     * 0-1背包问题
     * 放或者不放问题
     * 初始化的细节问题：如果恰好装满，则使用F[0]=0，F[1~V]=-Integer.MAX_INT；否则，F[0~V]=0
     * 状态转移函数：f(i,w)=max(f(i-1,w),f(i-1,w-c_i)+v_i)
     * 使用1维数组：f(w) = max(f(w),f(w-c_i)+v_i) 遍历时，需要w->c_i降序
     *
     * @param f 背包
     * @param c 物品重量
     * @param v 物品价值
     * @return
     */
    public static void zeroOnePack(int[] f, int[] c, int[] v) {
        for (int i = 0; i < c.length; i++) {
            for (int j = f.length - 1; j >= c[i]; j--) {
                f[j] = Math.max(f[j], f[j - c[i]] + v[i]);
            }
        }
    }
}
