package me.maxiaolong.codingoffer;

import com.sun.istack.internal.NotNull;

import java.util.*;

/***
 * 代码风格规定
 * 1. 单if单语句，直接写后面
 * 2. 多if单语句, 直接换行写后面
 */

public class Main {
    public static void main(String[] args) {
        int[][] arrs = {{1, 2, 3}, {2, 3, 4}};
        System.out.printf("3 二维数组查找目标值：%b%n", twoDimensionArraysContainsTarget(arrs, -1));
        System.out.printf("4 替换空格：%s%n", replaceSpace(new StringBuffer("Hello World")));
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        System.out.printf("5 从尾到头打印链表:%s%n", Arrays.toString(printListNode(node).toArray()));
        ArrayList<Integer> result6 = new ArrayList<>();
        TreeNode.preOrder(reConstructBinaryTree(new int[]{1, 2, 4, 5, 3}, new int[]{4, 2, 5, 1, 3}), result6);
        System.out.printf("6 根据前序及中序遍历重建二叉树:%s%n", Arrays.toString(result6.toArray()));
        Queue queue = new Queue();
        queue.push(1);
        queue.push(2);
        System.out.printf("7 使用两个栈构造队列：%d,%d,%d%n", queue.pop(), queue.pop(), queue.pop());
        System.out.printf("8 旋转数组最小值:%d%n", minNumberInRotateArray(new int[]{6501, 6828, 6963, 7036, 7422, 7674, 8146, 8468, 8704, 8717, 9170, 9359, 9719, 9895, 9896, 9913, 9962, 154, 293, 334, 492, 1323, 1479, 1539, 1727, 1870, 1943, 2383, 2392, 2996, 3282, 3812, 3903, 4465, 4605, 4665, 4772, 4828, 5142, 5437, 5448, 5668, 5706, 5725, 6300, 6335}));
        System.out.printf("9 斐波那契数列：第%d个数的值为%d%n", 3, fibonacci(3));
        System.out.printf("青蛙跳台阶：%d台阶有%d种方式%n", 4, jumpFrog(4));
        System.out.printf("10 二进制%d中1的个数为%d%n", -1, oneCountInBinaryNumber(-1));
        System.out.printf("11 %f^%d=%f%n", 0.1, 2, power(0.1, 2));
        System.out.printf("12 %d位数", 2);
        printToMaxOfNDigits(2);
        System.out.println();
        ListNode node3 = new ListNode(3, null);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        System.out.printf("13 删除链表节点, 原链表为%s,", Arrays.toString(listNodesToArrayList(node1).toArray()));
        deleteListNode(node1, node3);
        System.out.printf("删除链表后为%s%n", Arrays.toString(listNodesToArrayList(node1).toArray()));
        int[] arr = {1, 2, 2, 3, 4, 5, 6, 7, 8};
        System.out.printf("14 排序前为%s，", Arrays.toString(arr));
        reOrderArray(arr);
        System.out.printf("奇前偶后排序后为%s%n", Arrays.toString(arr));
        System.out.printf("15 查找倒数第&d个节点的数值为%d%n", 2, findKthToTail(node1, 2) == null ? "null" : findKthToTail(node1, 2).getVal());
        System.out.printf("16 翻转链表 原链表%s，翻转后链表%s%n", Arrays.toString(listNodesToArrayList(node1).toArray()), Arrays.toString(listNodesToArrayList(reverseListNode(node1)).toArray()));
        System.out.printf("17 链表合并 原链表%s %s，合并后链表%s%n", Arrays.toString(listNodesToArrayList(node).toArray()), Arrays.toString(listNodesToArrayList(node1).toArray()), Arrays.toString(listNodesToArrayList(mergeListNodes(node, node1)).toArray()));
        TreeNode treeNode5 = new TreeNode(5, null, null);
        TreeNode treeNode4 = new TreeNode(4, null, null);
        TreeNode treeNode3 = new TreeNode(3, treeNode5, null);
        TreeNode treeNode2 = new TreeNode(2, null, treeNode4);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);
        System.out.printf("18 是否为子树结构%s%n", isSubBinaryTree(treeNode1, treeNode1));
        System.out.printf("19 镜像二叉树");
        mirrorBinaryTree(treeNode1);
        preOrderBinaryTree(treeNode1);
        System.out.println();
        int[][] array = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.printf("20 顺时针打印矩阵：");
        printMatrix(array);
        System.out.println();
        System.out.print("21 实现Stack数据结构及其min函数：");
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(1);
        myStack.push(2);
        myStack.push(0);
        System.out.print(myStack.min());
        myStack.pop();
        System.out.print(myStack.min());
        myStack.pop();
        System.out.print(myStack.min());
        myStack.pop();
        System.out.print(myStack.min());
        System.out.println();
        System.out.printf("22 判断出栈顺序是否可行：%s，%s，%s%n", "12345","45321", isStackPopSequence("12345","45312"));
        System.out.printf("23 层次遍历二叉树");
        printBinaryTreeByStage(treeNode1);
        System.out.println();
        System.out.printf("24 判断序列是否可能为二叉搜索树后续遍历的结果");
        System.out.println(verifyPostOrderOfBST(new int[]{1, 6, 10, 12, 9, 17, 25, 18, 16}));
    }

    //25. 找到二叉树中路径和为某一整数的所有序列
    public static List<List<Integer>> findAllPathSumN(TreeNode node, int target, List<List<Integer>> result, List<Integer> path){
        if(node==null) return result;
        path.add(node.getVal());
        target -= node.getVal();
        // 这里的路径指的是一定要到叶节点
        if(target==0&&node.getLeft()==null&&node.getRight()==null){
            result.add(new ArrayList<>(path));
        }
        if(target>0){
            findAllPathSumN(node.getLeft(), target, result, path);
            findAllPathSumN(node.getRight(), target, result, path);
        }
        // 左边进行完，要将左边的末尾节点 进行回退
        path.remove(path.size() - 1);
        return result;
    }

    //24. BST数据结构特点
    public static boolean verifyPostOrderOfBST(int[] sequence){
        if(sequence == null||sequence.length == 0) return false;
        // sequence==2的情况都有可能的
        if(sequence.length==1 || sequence.length==2) return true;
        int root = sequence[sequence.length - 1];
        int index = -1;
        // 条件语句需要特别注意
        for (int i = sequence.length-2; i >= 0; i--) {
            if(sequence[i] < root){
                index = i;
                break;
            }
        }
        for (int i = 0; i < index ; i++) {
            if(sequence[i] >= root) return false;
        }
        return verifyPostOrderOfBST(Arrays.copyOfRange(sequence, 0, index+1))&& verifyPostOrderOfBST(Arrays.copyOfRange(sequence, index+1, sequence.length-1));
    }

    //23. 层次遍历二叉树
    public static void printBinaryTreeByStage(TreeNode node){
        if(node==null) return;
        java.util.Queue<TreeNode> queue = new LinkedList();
        queue.add(node);
        while(!queue.isEmpty()){
            TreeNode top = queue.poll();
            System.out.print(top.getVal()+ " "); //使用单引号就是char，千万不要搞错了
            if(top.getLeft()!=null) queue.add(top.getLeft());
            if(top.getRight()!=null) queue.add(top.getRight());
        }
    }

    //22. 判断出栈顺序是否可行(模拟人的识别过程)
    public static boolean isStackPopSequence(String pushStr, String popStr) {
        if(pushStr==null||popStr==null||pushStr.length()!=popStr.length()) return false;
        // 入栈视角
        MyStack myStack = new MyStack();
        int popIndex = 0;
        for (int i = 0; i < pushStr.length(); i++) {
            int pushCh = pushStr.charAt(i) - '0';
            myStack.push(pushCh);
            while(!myStack.isEmpty()&&myStack.peek()==popStr.charAt(popIndex)){
                myStack.pop();
                popIndex += 1;
            }
        }
        return myStack.isEmpty();
        // 出栈视角
//        MyStack myStack = new MyStack();
//        int inIndex = 0;
//        for (int i = 0; i < popStr.length(); i++) {
//            int outCh = popStr.charAt(i) - '0';
//            // 这里对于outStr的每个字符要么出栈，要么抵消，其他情况就需要直接返回，所以后面要用上continue
//            if (myStack.peek()!=null&&myStack.peek() == outCh){
//                myStack.pop();
//                continue;
//            }
//            if (inIndex < pushStr.length()) {
//                for (int j = inIndex; j < pushStr.length(); j++) {
//                    int inCh = pushStr.charAt(j) - '0';
//                    if (outCh != inCh) {
//                        myStack.push(inCh);
//                    } else {
//                        inIndex = j + 1;
//                        break;
//                    }
//                }
//                continue;
//            }
//            return false;
//        }
//        return true;
    }


    // 20. 顺时针打印矩阵（过程模拟）
    public static void printMatrix(int[][] array) {
        if (array == null || array.length == 0) return;
        int left = 0, right = array[0].length, top = 0, bottom = array.length, x = 0, y = 0;
        while (left < right && top < bottom) {
            while (y < right) {
                System.out.print(array[x][y] + " ");
                y += 1;
            }
            top += 1;
            x = top;
            y -= 1;
            while (x < bottom) {
                System.out.print(array[x][y] + " ");
                x += 1;
            }
            right -= 1;
            x -= 1;
            y = right - 1;
            while (y >= left) {
                System.out.print(array[x][y] + " ");
                y -= 1;
            }
            bottom -= 1;
            x = bottom - 1;
            y += 1;
            while (x >= top) {
                System.out.print(array[x][y] + " ");
                x -= 1;
            }
            left += 1;
            x += 1;
            y = left;
        }
    }

    // 19. 镜像二叉树 （一大步骤，使用一个函数即可）
    public static void mirrorBinaryTree(TreeNode treeNode) {
        if (treeNode == null) return;
        TreeNode temp = treeNode.getLeft();
        treeNode.setLeft(treeNode.getRight());
        treeNode.setRight(temp);
        mirrorBinaryTree(treeNode.getLeft());
        mirrorBinaryTree(treeNode.getRight());
    }

    public static void preOrderBinaryTree(TreeNode root) {
        if (root != null) {
            preOrderBinaryTree(root.getLeft());
            System.out.print(root.getVal());
            preOrderBinaryTree(root.getRight());
        }
    }

    // 18. 输入两个二叉树，判断后者是否为前者的子结构(两大步骤，所以要使用两个函数)
    public static boolean isSubBinaryTree(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) return false;
        return __isSubBinaryTree(node1, node2) || isSubBinaryTree(node1.getLeft(), node2) || isSubBinaryTree(node1.getRight(), node2);
    }

    private static boolean __isSubBinaryTree(TreeNode node1, TreeNode node2) {
        //先判断主要关键点
        if (node2 == null) return true;
        if (node1 == null) return false;
        if (node1.getVal() == node2.getVal())
            return __isSubBinaryTree(node1.getLeft(), node2.getLeft()) && __isSubBinaryTree(node1.getRight(), node2.getRight());
        else
            return false;
    }

    // 17. 链表合并 空间复杂度O（1）
    public static ListNode mergeListNodes(ListNode node1, ListNode node2) {
        if (node1 == null) return node2;
        if (node2 == null) return node1;
        ListNode result = new ListNode(-1, null);
        ListNode temp = result;
        ListNode pNode1 = node1;
        ListNode pNode2 = node2;
        while (pNode1 != null && pNode2 != null) {
            if (pNode1.getVal() < pNode2.getVal()) {
                temp.setNext(pNode1);
                temp = temp.getNext();
                pNode1 = pNode1.getNext();
            } else {
                temp.setNext(pNode2);
                temp = temp.getNext();
                pNode2 = pNode2.getNext();
            }
        }
        if (pNode1 == null)
            temp.setNext(pNode2);
        else
            temp.setNext(pNode1);
        return result.getNext();
    }

    // 16. 翻转链表 考察链表基础知识
    public static ListNode reverseListNode(ListNode head) {
        if (head == null) return null;
        ListNode front = null;
        ListNode back = head;
        ListNode temp = back.getNext();
        while (back != null) {
            back.setNext(front);
            front = back;
            back = temp;
            if (temp != null)
                temp = temp.getNext();
        }
        return front;
    }

    // 15. 输出倒数第k个节点 考察链表基础知识，使用快慢指针技巧
    public static ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) return null;
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++) {
            if (fast != null)
                fast = fast.getNext();
            else
                return null;
        }
        while (fast != null) {
            slow = slow.getNext();
            fast = fast.getNext();
        }
        return slow;
    }

    // 14. 奇前偶后 考察排序知识
    public static void reOrderArray(int[] arr) {
        if (arr == null || arr.length == 0) return;
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            if (arr[i] % 2 != 0) {
                while (j > 0) {
                    if (arr[j] % 2 != 0) break;
                    else {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        j--;
                    }
                }
            }
        }
    }

    // 12.打印0～n位数
    public static void printToMaxOfNDigits(int n) {
        // 考虑边界条件
        if (n == 0) return;
        int[] array = new int[n];
        printArray(array, 0);
    }

    public static void printArray(int[] array, int i) {
        for (int j = 0; j <= 9; j++) {
            if (i != array.length) { //不塞满，继续赋值
                array[i] = j;
                printArray(array, i + 1);
            } else { //塞满打印
                boolean isFirstZero = true;
                for (int k = 0; k < array.length; k++) {
                    if (array[k] != 0) {
                        System.out.print(array[k]);
                        isFirstZero = false;
                    } else {
                        if (!isFirstZero) {
                            System.out.print(array[k]);
                        }
                    }
                }
                System.out.print(' ');
                return;
            }
        }
    }

    // 13. 删除链表节点
    public static void deleteListNode(ListNode head, ListNode target) {
        if (head == null || target == null) return;
        ListNode nextNode = target.getNext();
        if (nextNode != null) {
            target.setVal(nextNode.getVal());
            target.setNext(nextNode.getNext());
        } else {
            // 理解按引用传递的本质
//            target = null;
            ListNode temp = head;
            while (temp.getNext().getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(null);
        }
    }

    public static ArrayList listNodesToArrayList(ListNode head) {
        ArrayList<Integer> arr = new ArrayList();
        ListNode temp = head;
        while (temp != null) {
            arr.add(temp.getVal());
            temp = temp.getNext();
        }
        return arr;
    }

    // 3. 二维数组查找目标值
    public static boolean twoDimensionArraysContainsTarget(int[][] arrs, int target) {
        if (arrs == null) return false;
        int i = 0, j = arrs[0].length - 1;
        while (i < arrs.length && j > -1) {
            if (target == arrs[i][j])
                return true;
            else if (target > arrs[i][j])
                i++;
            else
                j--;
        }
        return false;
    }

    //4. 替换字符串中的空格
    public static String replaceSpace(StringBuffer str) {
        if (str == null) return null;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                sb.append("%20");
            else
                sb.append(str.charAt(i));
        }
        return String.valueOf(sb);
    }

    //5. 从尾到头打印链表
    public static ArrayList<Integer> printListNode(ListNode node) {
        if (node == null) return null;
        ArrayList<Integer> result = new ArrayList<>();
        Stack<ListNode> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.getNext();
        }
        while (!stack.empty())
            result.add(stack.pop().getVal());
        return result;
    }

    //6. 由前序和中序遍历重建二叉树
    public static TreeNode reConstructBinaryTree(int[] pre, int[] mid) {
        if (pre == null || mid == null || pre.length == 0 || mid.length == 0) return null;
        if (pre.length == 1 && mid.length == 1)
            return new TreeNode(pre[0], null, null);
        else {
            TreeNode result = new TreeNode(pre[0], null, null);
            for (int i = 0; i < mid.length; i++) {
                if (mid[i] == pre[0]) {
                    result.setLeft(reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(mid, 0, i)));
                    result.setRight(reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(mid, i + 1, mid.length)));
                    break;
                }
            }
            return result;
        }
    }

    //8. 旋转数组最小值
    public static Integer minNumberInRotateArray(int[] arr) {
        // 先考虑特殊情况
        if (arr.length == 0) return 0;
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2; //offset
            // 判断是否为最小值
            if (mid - 1 > -1 && arr[mid - 1] > arr[mid])
                return arr[mid];
            if (mid + 1 < arr.length && arr[mid + 1] < arr[mid])
                return arr[mid + 1];
            // 二分
            if (arr[mid] > arr[left])
                left = mid + 1;
            if (arr[mid] < arr[right])
                right = mid - 1;
        }
        return arr[left];
    }

    //9. 斐波那契数列求值
    public static Integer fibonacci(int n) {
        int result = 0;
        int preOne = 1;
        int preTwo = 0;
        // 先考虑特殊情况
        if (n == 0) return preTwo;
        if (n == 1) return preOne;
        for (int i = 2; i <= n; i++) {
            result = preOne + preTwo;
            preOne = result;
            preTwo = preOne;
        }
        return result;
    }

    // 跳青蛙
    public static Integer jumpFrog(int n) {
        int result = 0;
        int preOne = 2;
        int preTwo = 1;
        if (n == 0) return 0;
        if (n == 1) return preTwo;
        if (n == 2) return preOne;
        for (int i = 3; i <= n; i++) {
            result = preOne + preTwo;
            preTwo = preOne;
            preOne = result;
        }
        return result;
    }

    //10. 输出二进制中1的个数；负数用补码表示
    //考察数据的基础知识
    public static Integer oneCountInBinaryNumber(int i) {
        int count = 0;
        while (i != 0) {
            i = i & (i - 1);
            count++;
        }
        return count;
    }

    //11. double base^int exponent
    // java8 double比较暂无问题
    public static double power(double base, int exponent) {
        if (base == 0)
            return 0;
        if (exponent == 0)
            return 1;
        if (exponent > 0)
            return multiply(base, exponent);
        else
            return multiply(base, -exponent);
    }

    private static double multiply(double a, int b) {
        double result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return result;
    }

}

//21. 定义栈结构并实现其min函数（对于栈后进先出的理解）
class MyStack {
    private ArrayList<Integer> arr = new ArrayList();
    private ArrayList<Integer> minArr = new ArrayList();

    public void push(int e) {
        arr.add(e);
        if (minArr.isEmpty()) {
            minArr.add(e);
        } else if (minArr.get(minArr.size() - 1) > e) {
            minArr.add(e);
        }
    }

    public Integer pop() {
        if (arr.size() != 0) {
            if (arr.get(arr.size() - 1) == minArr.get(minArr.size() - 1)) {
                minArr.remove(minArr.size() - 1);
            }
            return arr.remove(arr.size() - 1);
        } else
            return null;
    }

    public Integer peek() {
        if (arr.size() != 0)
            return arr.get(arr.size() - 1);
        else
            return null;
    }

    public Integer min() {
        if (minArr.isEmpty()) {
            if (arr.isEmpty()) {
                return -1;
            } else {
                // 懒汉式
                for (int i = 0; i < arr.size(); i++) {
                    if (minArr.isEmpty()) {
                        minArr.add(arr.get(i));
                    } else if (minArr.get(minArr.size() - 1) > arr.get(i)) {
                        minArr.add(arr.get(i));
                    }
                }
            }
        }
        return minArr.get(minArr.size() - 1);
    }

    public boolean isEmpty(){
        return arr.isEmpty()?true:false;
    }
}

class ListNode {
    private int val;
    private ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return this.next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}

class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public static void preOrder(TreeNode node, ArrayList<Integer> result) {
        if (node != null) {
            result.add(node.val);
            preOrder(node.getLeft(), result);
            preOrder(node.getRight(), result);
        }
    }
}

class Queue {
    Stack<Integer> inStack = new Stack<>();
    Stack<Integer> outStack = new Stack<>();

    public void push(int val) {
        inStack.add(val);
    }

    public Integer pop() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty())
                outStack.add(inStack.pop());
        }
        if (outStack.isEmpty())
            return -1;
        else
            return outStack.pop();
    }
}

// 2单例模式：多线程安全 饿汉式/Double Check/
class Singleton {
    // volatile修饰变量禁止指令重排序(分配空间->实例指向/初始化对象)
    // Java的指令重排序在不影响单线程的情况下，优化指令顺序，提高程序运行速率（编译器重排序和运行时重排序）
    private volatile static Singleton singleton;

    // 私有构造函数，防止创建类实例
    private Singleton() {
    }

    public static Singleton getInstance1() {
        if (singleton == null) { //double check
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    private static class SingletonHolder {
        private static final Singleton instance = new Singleton();
    }

    public static Singleton getInstance2() {
        return SingletonHolder.instance; // 达到延迟加载；利用类加载进行实例化时，只会使用单线程
    }
}
